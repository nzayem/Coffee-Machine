import java.util.Scanner;

public class Main {

    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int cups = 9;
    private static int money = 550;
    private static int coffee;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("Write action (buy, fill, take, remaining, exit):");

            String userSelection = scanner.next();

            switch (userSelection) {


                case "buy":

                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

                    String selectedCoffee = scanner.next();

                    if (selectedCoffee.equals("1")) {

                        coffee = 1;

                    } else if (selectedCoffee.equals("2")) {

                        coffee = 2;

                    } else if (selectedCoffee.equals("2")) {

                        coffee = 3;

                    }

                    if (minCups(water, milk, coffeeBeans) >= coffee) {

                        System.out.println("I have enough resources, making you a coffee!");

                        buy(selectedCoffee);
                        break;

                    } else if ((water <= 250 && coffee == 1)
                            || (water <= 350 && coffee == 2)
                            || (water <= 200 && coffee == 3)) {

                        System.out.println("Sorry, not enough water!");
                        break;

                    } else if ((milk <= 75 && coffee == 2)
                            || (water <= 100 && coffee == 3)) {

                        System.out.println("Sorry, not enough milk!");
                        break;

                    } else if ((coffeeBeans <= 16 && coffee == 1)
                            || (coffeeBeans <= 20 && coffee == 2)
                            || (coffeeBeans <= 12 && coffee == 3)) {

                        System.out.println("Sorry, not enough coffee beans!");
                        break;

                    } else if (cups == 0) {

                        System.out.println("Sorry, not enough cups!");
                        break;
                    }



                case "fill":

                    System.out.println("Write how many ml of water you want to add:");

                    int waterToAdd = scanner.nextInt();

                    System.out.println("Write how many ml of milk you want to add:");

                    int milktoAdd = scanner.nextInt();

                    System.out.println("Write how many grams of coffee beans you want to add:");

                    int coffeeBeanstToAdd = scanner.nextInt();

                    System.out.println("Write how many disposable cups of coffee you want to add:");

                    int cupsToAdd = scanner.nextInt();

                    water += waterToAdd;
                    milk += milktoAdd;
                    coffeeBeans += coffeeBeanstToAdd;
                    cups += cupsToAdd;

                    break;

                case "take":

                    System.out.println("I gave you $" + money);

                    money = 0;

                    break;

                case "remaining":

                    printStats(water, milk, coffeeBeans, cups, money);

                    break;

                case "exit":

                    scanner.close();

                    System.exit(0);

            }

        }

    }

    public static void buy(String choice) {

        switch (choice) {

            case "1":

                water  -= 250;
                coffeeBeans -= 16;
                money += 4;
                cups--;

                break;

            case "2":

                water  -= 350;
                milk -= 75;
                coffeeBeans -= 20;
                money += 7;
                cups--;

                break;


            case "3":

                water  -= 200;
                milk -= 100;
                coffeeBeans -= 12;
                money += 6;
                cups--;

                break;

        }

    }

    public static void printStats(int water, int milk, int coffeeBeans, int cups, int money) {

        System.out.println("The coffee machine has:\r\n"
                + water + " ml of water\r\n"
                + milk +" ml of milk\r\n"
                + coffeeBeans + " g of coffee beans\r\n"
                + cups + " disposable cups\r\n"
                + "$" + money + " of money");

    }

    public static int minCups(int water, int milk, int coffeBeans) {

        return Math.min(water/200, Math.min(milk/50, coffeBeans/15));

    }

}
