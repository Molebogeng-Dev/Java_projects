package com.Molebogeng.profile.dataBase;

import java.util.List;

public class diplaydb {
    private static List<contactmedb> list ;

    public diplaydb(List<contactmedb> all) {
        list = List.copyOf(all);
    }

    public static void printList(){
        System.out.println(list);
    }
}
