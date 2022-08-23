package cn.lnd.chainOfResponsibility.pack2;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2022/8/22 23:33
 */
public class MainApp2 {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMsg("欢迎来到<script>澳门皇家赌场:)。点击链接“baidu.com”");

        FilterChain fc = new FilterChain();
        /* 链式编程的简单使用 */
        fc.add(new HTMLFilter()).add(new SensitiveFilter());
        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter()).add(new URLFilter());
        // case1：链条fc先处理，之后链条fc2再处理
        //fc.doFilter(message);
        //fc2.doFilter(message);
        // case2：将两个链条连起来，只调用一次 doFilter 方法 -> 让 FilterChain 自身也去实现 Filter 接口
        fc.add(fc2);
        fc.doFilter(message);
        System.out.println(message.getMsg());


        /*
            继续：由FilterChain中的某一个Filter决定链条是否继续？
        */

        /*
            继续：同一个 Filter 既能处理 request，也能处理response消息
        */

    }
}
class Message{
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msg='" + msg + '\'' +
                '}';
    }

}
interface Filter{
    /* 当doFilter返回值为true时继续往下执行，否则终止 */
    boolean doFilter(Message message);
}
class HTMLFilter implements Filter{
    @Override
    public boolean doFilter(Message message) {
        String str = message.getMsg();
        str = str.replace("<", "[");
        str = str.replace(">", "]");
        message.setMsg(str);
        return true;
    }
}
class SensitiveFilter implements Filter{
    @Override
    public boolean doFilter(Message message) {
        String str = message.getMsg();
        str = str.replaceAll("澳门皇家赌场", "小葵花妈妈课堂");
        message.setMsg(str);
        return false;
    }
}
class FaceFilter implements Filter{
    @Override
    public boolean doFilter(Message message) {
        String str = message.getMsg();
        str = str.replace(":)", "^V^");
        message.setMsg(str);
        return true;
    }
}

class URLFilter implements Filter{
    @Override
    public boolean doFilter(Message message) {
        String str = message.getMsg();
        str = str.replaceAll("baidu.com", "http://www.baidu.com");
        message.setMsg(str);
        return true;
    }
}

class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }

    /*
        让链条上的 Filter 都执行一遍
     */
    @Override
    public boolean doFilter(Message message){
        for (Filter filter : filters) {
            boolean b = filter.doFilter(message);
            if (!b) return false;
        }
        return true;
    }
}