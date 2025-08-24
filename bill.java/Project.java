package bill.java;

import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        System.out.println("___________________________ Welcome to Pizzamania ___________________________");
        System.out.println("Which pizza: (1. Veg Pizza 2. Non-Veg Pizza 3. Deluxe Veg Pizza 4. Deluxe Non-Veg Pizza)");

        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                Pizza vegPizza = new Pizza(true);
                vegPizza.addExtraCheese();
                vegPizza.addExtraToppings();
                vegPizza.takeAway();
                vegPizza.getBill();
                break;
            case 2:
                Pizza nonvegPizza = new Pizza(false);
                nonvegPizza.addExtraCheese();
                nonvegPizza.addExtraToppings();
                nonvegPizza.takeAway();
                nonvegPizza.getBill();
                break;
            case 3:
                DeluxPizza deluxVeg = new DeluxPizza(true);
                deluxVeg.takeAway();
                deluxVeg.getBill();
                break;
            case 4:
                DeluxPizza deluxNonveg = new DeluxPizza(false);
                deluxNonveg.takeAway();
                deluxNonveg.getBill();
                break;
            default:
                System.out.println("Sorry, please enter a valid option!");
                break;
        }

        sc.close();
    }
}

