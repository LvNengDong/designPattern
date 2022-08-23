package cn.lnd.chainOfResponsibility.pack3;


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

    public static void main(String[] args) {
        Request request = new Request();
        request.setStr("request");
        Response response = new Response();
        response.setStr("response");

        FilterChain fc = new FilterChain();
        HTMLFilter htmlFilter = new HTMLFilter();
        SensitiveFilter sensitiveFilter = new SensitiveFilter();
        fc.add(htmlFilter).add(sensitiveFilter);
        FilterChain fc2 = new FilterChain();
        fc2.add(sensitiveFilter).add(htmlFilter);

        System.out.println("");
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
class Request{
    String str;

    @Override
    public String toString() {
        return "Request{" +
                "str='" + str + '\'' +
                '}';
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
class Response{
    String str;
    @Override
    public String toString() {
        return "Request{" +
                "str='" + str + '\'' +
                '}';
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

interface Filter{
    boolean doFilter(Request request, Response response);
}

class HTMLFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response response) {
        String str = request.getStr() + "request filter1";
        request.setStr(str);
        return false;
    }
}

class SensitiveFilter implements Filter{
    @Override
    public boolean doFilter(Request request, Response response) {
        return false;
    }
}

class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }
    public void delete(Filter filter){
        filters.remove(filter);
    }

    /*
        让链条上的 Filter 都执行一遍
     */

    @Override
    public boolean doFilter(Request request, Response response) {
        for (Filter filter : filters) {
            boolean b = filter.doFilter(request, response);
            if (!b) return false;
        }
        return true;
    }
}