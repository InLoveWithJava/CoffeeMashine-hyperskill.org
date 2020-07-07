package machine;
import java.util.*;
public class CoffeeMachine {

    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int money = 550;
    private static int cups = 9;

    private static Scanner scanner = new Scanner(System.in);

    public static void print() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static boolean check(int water, int milk, int beans) {
        if (CoffeeMachine.water - water > 0 && CoffeeMachine.milk - milk > 0 &&
                CoffeeMachine.beans - beans > 0 && cups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }

    public static void remaining() {
        print();
    }

    public static void buy(String answer) {
        switch (answer) {
            case "1":
                if (check(250, 0, 16)) {
                    water -= 250;
                    beans -= 16;
                    cups -= 1;
                    money += 4;
                }
                break;
            case "2":
                if (check(350, 75, 20)) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups -= 1;
                    money += 7;
                }
                break;
            case "3":
                if (check(200, 100, 12)) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups -= 1;
                    money += 6;
                }
                break;
            case "4":
                break;
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();
    }

    public static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }


    public static void main(String[] args) {
        String mainAnswer;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            mainAnswer = scanner.next();
            switch (mainAnswer) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, " +
                            "3 - cappuccino, back - to main menu:");
                    buy(scanner.next());
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
            }
        } while (!mainAnswer.equals("exit"));
    }
}
