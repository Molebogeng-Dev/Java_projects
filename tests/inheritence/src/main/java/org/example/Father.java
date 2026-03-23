package org.example;

import java.util.Scanner;

public class Father {
    private final String name;
    private final String surname;
    private boolean children;
    private static int numberOfChildren;
    private float shares = 100;

    //Parent Constructor
    Father(String name, String surname){
        this.name = name;
        this.surname = surname;
        if(Father.numberOfChildren > 0) this.children = true;
        this.valid();
    }
    //For children Constructor
    Father(String name, String surname, float shares){
        this.shares -= shares;
        this.name = name;
        this.surname = surname;
        this.valid();
        Father.numberOfChildren++;
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
        this.shares = input.nextFloat();

        input.close();
    }

    private void valid(){
        if(this.name == null || this.surname == null ) throw new NullPointerException("Cannot be null!");
        if(this.shares < 0) System.out.println("Shares depleted");
        //Add more error handling(estate not null)
    }

    public String getDetails(){
        System.out.printf("Name: %s\nSurname: %s\nNumber of children: %d\nInheritance shares: %d\n\n", this.name, this.surname, Father.numberOfChildren, Math.round(this.shares));
        return null;
    }

}
