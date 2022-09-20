package cn.lnd.chainOfResponsibility.pack3;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author lnd
 * @Description <h1>
 * 原则：封装变化
 * </h1>
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
        //FilterChain fc2 = new FilterChain();
        //fc2.add(sensitiveFilter).add(htmlFilter);
        fc.doFilter(request, response, fc); //第一次调用chain#doFilter
        System.out.println(request.getStr());
        System.out.println(response.getStr());
        /*
            在 filterChain 中处理加入位置的记录，同时在 filter 中加入第三个参数
        */
    }
}

/* 要传给后台服务器的信息 */
class Message {
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

class Request {
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

class Response {
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

interface Filter {
    boolean doFilter(Request request, Response response, FilterChain chain);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        String str = request.getStr() + "request filter1;";
        request.setStr(str);
        // 如果不调用 chain#doFilter 方法，整个链路就不会继续往下执行了
        chain.doFilter(request, response, chain);
        response.setStr(response.getStr() + "--response filter1");
        return false;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        String str = request.getStr() + "request filter2;";
        request.setStr(str);
        chain.doFilter(request, response, chain);
        response.setStr(response.getStr() + "--response filter2");
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    int index = 0; //记录当前FilterChain执行到了哪一个Filter

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void delete(Filter filter) {
        filters.remove(filter);
    }

    /*
        让链条上的 Filter 都执行一遍
     */

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        //如果整个链条都执行完毕了，就结束
        if (index == filters.size()) return false;
        // 如果链条没执行完，就拿到应该执行的filter去执行
        Filter filter = filters.get(index);
        index++;
        boolean b = filter.doFilter(request, response, chain);
        return b;
    }
}

/*
    类似于递归调用
*/