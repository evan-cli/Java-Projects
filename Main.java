//This project idea is borrowed from Chuck Keith aka NetworkChuck. I have expanded on it and
// added my own ideas. This program is a simple interaction between you and a coffee barista .When you
// run the program the barista generates their menu. You are then prompted for input from the console.
// The barista wants to know what items you would like to order. The program comes to it's
// conclusion after you have finished ordering and reads back your order. This is a work-in-progress.

package com.company;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        welcome();
    }

    public static void welcome() {
        Scanner nameObject = new Scanner(System.in);
        Scanner custOrder = new Scanner(System.in);
        Scanner prompt = new Scanner(System.in);
        System.out.print("Hello! What is your name? ");
        String name = nameObject.nextLine();
        System.out.print("Hi " + name + "! Welcome to the barista. What would you like to order? \n");
        order();
    }

    public static ArrayList<String> getMenu() {
        List<String> treats = Arrays.asList("Black Coffee", "Green Tea", "Caramel Macchiato",
                "Americano", "Cookie", "Eggnog", "Expresso", "Chai Latte", "Vanilla Latte",
                "Chamomile Tea", "Black Tea", "Frappucino", "Mocha", "Toast");
        ArrayList<String> menu = new ArrayList<String>(treats);
        ArrayList<String> todaysMenu = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            int r = new Random().nextInt(menu.size());
            todaysMenu.add(menu.get(r));
            menu.remove(r);
        }
        return todaysMenu;
    }

    public static void order() {
        ArrayList<String> todaysMenuArray = new ArrayList<>(getMenu());
        String todaysMenuString = String.join(", ", todaysMenuArray);
        ArrayList<String> wholeOrder = new ArrayList<>();
        Scanner customerOrder = new Scanner(System.in);
        String customerOrderString = "";
        while (true) {
            System.out.print("Today we have: " + todaysMenuString + "...? ");
            customerOrderString = customerOrder.nextLine();
            while (!customerOrderString.equals(todaysMenuArray.get(0)) &&
                    !customerOrderString.equals(todaysMenuArray.get(1)) &&
                    !customerOrderString.equals(todaysMenuArray.get(2)) &&
                    !customerOrderString.equals(todaysMenuArray.get(3))){
                System.out.print("That's not on today's menu. What would you like to order? ");
                customerOrderString = customerOrder.nextLine();
            }
            wholeOrder.add(customerOrderString);
            System.out.print("Excellent choice! Will that complete your order? Please type \"Y\" or \"N\" ");
            customerOrderString = customerOrder.nextLine();
            if (customerOrderString.equalsIgnoreCase("N")){
                   System.out.print("Ok, what else would you like? ");
                   continue;} else if(customerOrderString.equalsIgnoreCase("Y"))  {
                       System.out.println("OK! Your " + String.join(", ", wholeOrder) + " is coming right up!");
                       break;}
           }

        }

    }

