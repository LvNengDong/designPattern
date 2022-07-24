package cn.lnd.adapter_pattern.principle;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/21 19:31
 */
public class MainClassAdaptor {

    public static void main(String[] args) {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3);
        Enumeration<Integer> enumeration = Collections.enumeration(integers);
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }
    /* 执行以上代码，输出结果为：
    --------------------------------------
        1
        2
        3
    -----------------------------------
    分析：
    */
}
