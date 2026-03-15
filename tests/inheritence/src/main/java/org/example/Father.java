package org.example;

import java.util.Scanner;

public class Father {
    private final String name;
    private final String surname;
    private boolean children;
    private static int numberOfChildren;
    private final double estate;

    //Constructor
    Father(String name, String surname, boolean children, int numberOfChildren, double estate){
        this.valid();
        this.name = name;
        this.surname = surname;
        this.children = children;
        Father.numberOfChildren = numberOfChildren;
        this.estate = estate;
    }
    //INPUTS constructor
    Father(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter Father's following details\nName: "); this.name = input.nextLine();
        System.out.print("\nSurname: "); this.surname = input.nextLine();

        System.out.print("\nChildren Y/N: ");
        String answer = input.next();
        do {
            if(answer != null) {
                if (answer.equalsIgnoreCase("Y")) this.children = true;
                else if (answer.equalsIgnoreCase("N")) this.children = false;
                break;
            }
            System.out.println("Enter Y/N: "); answer = input.next();
        }while ( answer == null);


        System.out.print("\nNet Worth: ");
        this.estate = input.nextDouble();

        input.close();
    }
    public void valid(){
        if(name == null || surname == null ) throw new NullPointerException("Cannot be null!");
        //Add more error handling(estate not null)
    }

    public void getDetails(){
        System.out.printf("Name: %s\nSurname: %s\nNumber of children: %d\nInheritance assets: %f\n", this.name, this.surname, Father.numberOfChildren, this.estate);
    }

}
