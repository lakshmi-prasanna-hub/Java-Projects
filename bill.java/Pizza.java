package bill.java;

import java.util.Scanner;

public class Pizza {
    protected int price;
    private boolean veg;

    protected final int extraCheesePrice = 100;
    protected final int extraToppingsPrice = 150;
    protected final int takeAwayPrice = 20;

    protected int basePizzaPrice;
    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingsAdded = false;
    private boolean isTakeawayOpted = false;

    public Pizza(boolean veg) {
        this.veg = veg;
        if (this.veg) {
            this.price = 300;
        } else {
            this.price = 400;
        }
        basePizzaPrice = this.price;
    }

    public void addExtraCheese() {
        Scanner in = new Scanner(System.in);
        System.out.println("Add extra cheese (y/n)? => ");
        char ch = in.next().charAt(0);
        if (ch == 'y') {
            isExtraCheeseAdded = true;
            this.price += extraCheesePrice;
        }
    }

    public void addExtraToppings() {
        Scanner in = new Scanner(System.in);
        System.out.println("Add extra toppings (y/n)? => ");
        char ch = in.next().charAt(0);
        if (ch == 'y') {
            isExtraToppingsAdded = true;
            this.price += extraToppingsPrice;
        }
    }

    public void takeAway() {
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want takeaway (y/n)? => ");
        char ch = in.next().charAt(0);
        if (ch == 'y') {
            isTakeawayOpted = true;
            this.price += takeAwayPrice;
        }
    }

    public void getBill() {
        System.out.println("\n--------- Bill ---------");
        System.out.println("Base Pizza Price: ₹" + basePizzaPrice);
        if (isExtraCheeseAdded) {
            System.out.println("Extra Cheese: ₹" + extraCheesePrice);
        }
        if (isExtraToppingsAdded) {
            System.out.println("Extra Toppings: ₹" + extraToppingsPrice);
        }
        if (isTakeawayOpted) {
            System.out.println("Takeaway Charges: ₹" + takeAwayPrice);
        }
        System.out.println("Total Price: ₹" + price);
        System.out.println("------------------------\n");
    }
}
