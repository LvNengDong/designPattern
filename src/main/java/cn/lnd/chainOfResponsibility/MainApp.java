package cn.lnd.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lnd
 * @Description
 *      <h1>
 *          原则：封装变化
 *      </h1>
 * @Date 2022/8/21 19:40
 */
public class MainApp {
    /*
        模拟场景：
            在论坛中发表文章。
            后台要经过信息处理才可以发表或者进入数据库。
                信息处理：就是一系列审核过程，如敏感词过滤、数据脱敏等...
    */

    public static void main(String[] args) {
        Message message = new Message();
        message.setMsg("欢迎来到<script>澳门皇家赌场，记住网址：baidu.com");
        /*
            需求1：
                1、<script> 可能是非内容部分，需要替换掉
                2、“澳门皇家赌场”是敏感词，需要替换掉
        */

        // 处理msg
        //String str = message.getMsg();
        //str = str.replace("<", "[");
        //str = str.replace(">", "]");
        //str = str.replaceAll("澳门皇家赌场", "小葵花妈妈课堂");
        //message.setMsg(str);
        //
        //System.out.println(message.getMsg());

        /*
            需求2：
                对消息的处理还不确定，还有可能在将来添加其它各种各样的过滤条件。
        */
        new HTMLFilter().doFilter(message);
        new SensitiveFilter().doFilter(message);
        System.out.println(message.getMsg());
        /* 这种方式在添加新的过滤规则时，还是需要修改原有的代码，添加新的 Filter。
        这时我们考虑到的一种优化方式就是将所有的 Filter 串成一串 */

        List<Filter> filters = new ArrayList<>();
        filters.add(new HTMLFilter());
        filters.add(new SensitiveFilter());
        for (Filter filter : filters) {
            filter.doFilter(message);
        }
        System.out.println(message.getMsg());

        /*
            相较于上一种方式，这种方式最大的区别就是：两个链条（FilterChain）可以连在一起。
        */
        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter());
        fc.add(new SensitiveFilter());
        fc.doFilter(message);
        System.out.println(message.getMsg());

    }
}

/* 要传给后台服务器的信息 */
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
    void doFilter(Message message);
}
class HTMLFilter implements Filter{

    @Override
    public void doFilter(Message message) {
        String str = message.getMsg();
        str = str.replace("<", "[");
        str = str.replace(">", "]");
        message.setMsg(str);
    }
}
class SensitiveFilter implements Filter{
    @Override
    public void doFilter(Message message) {
        String str = message.getMsg();
        str = str.replaceAll("澳门皇家赌场", "小葵花妈妈课堂");
        message.setMsg(str);
    }
}

class FilterChain{
    List<Filter> filters = new ArrayList<>();

    public void add(Filter filter){
        filters.add(filter);
    }
    public void delete(Filter filter){
        filters.remove(filter);
    }

    /*
        让链条上的 Filter 都执行一遍
     */
    public void doFilter(Message message){
        for (Filter filter : filters) {
            filter.doFilter(message);
        }
    }
}