package org.example;

public class Main {
    public static void main(String[] args){
        Child child = new Child("Lebo","Selahle",54);
        Father father = new Father("Joe","Selahle");

        Child.printChild(child.getDetails());
        father.getDetails();
    }
}