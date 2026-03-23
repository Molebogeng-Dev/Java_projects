package org.example;

import org.w3c.dom.Text;

class Child extends Father{

    Child(String name,String surname,double shares){
        super(name,surname,(float) shares);
    }

    public static void printChild(String text){
        System.out.println(text);
    }
}
