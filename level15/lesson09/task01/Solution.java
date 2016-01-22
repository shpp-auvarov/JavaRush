package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static{
        labels.put((double)1, "asdf1");
        labels.put((double)2, "asasdfdf2");
        labels.put((double)3, "asdasdff3");
        labels.put((double)4, "asasdfasdfasdfdf4");
        labels.put((double)5, "asdadsfgdsfgsdff5");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
