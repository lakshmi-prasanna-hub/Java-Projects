package bill.java;

public class DeluxPizza extends Pizza {
bill.java/DeluxPizza.java
    public DeluxPizza(boolean veg) {
        super(veg);
        super.addExtraCheese();     // Auto include cheese
        super.addExtraToppings();   // Auto include toppings
    }

    @Override
    public void addExtraCheese() {
        System.out.println("Deluxe pizza already includes extra cheese.");
    }

    @Override
    public void addExtraToppings() {
        System.out.println("Deluxe pizza already includes extra toppings.");
    }
}
