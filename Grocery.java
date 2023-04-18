import java.util.Scanner;

public class GroceryManagementSystem {
    static Scanner input = new Scanner(System.in);
    static String[] groceryList = new String[50];
    static int[] groceryQuantity = new int[50];
    static int numberOfGroceries = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Grocery Management System!");

        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Please select an option:");
            System.out.println("1. Add a grocery item");
            System.out.println("2. Remove a grocery item");
            System.out.println("3. View grocery list");
            System.out.println("4. Exit");

            int selection = input.nextInt();

            switch (selection) {
                case 1:
                    addGroceryItem();
                    break;
                case 2:
                    removeGroceryItem();
                    break;
                case 3:
                    viewGroceryList();
                    break;
                case 4:
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }

        System.out.println("Thank you for using the Grocery Management System!");
    }

    public static void addGroceryItem() {
        System.out.println("Please enter the name of the grocery item:");
        String itemName = input.next();

        System.out.println("Please enter the quantity of the grocery item:");
        int itemQuantity = input.nextInt();

        groceryList[numberOfGroceries] = itemName;
        groceryQuantity[numberOfGroceries] = itemQuantity;
        numberOfGroceries++;

        System.out.println(itemQuantity + " " + itemName + "(s) added to the grocery list.");
    }

    public static void removeGroceryItem() {
        System.out.println("Please enter the name of the grocery item you want to remove:");
        String itemName = input.next();

        boolean itemRemoved = false;
        for (int i = 0; i < numberOfGroceries; i++) {
            if (groceryList[i].equals(itemName)) {
                itemRemoved = true;
                numberOfGroceries--;

                for (int j = i; j < numberOfGroceries; j++) {
                    groceryList[j] = groceryList[j + 1];
                    groceryQuantity[j] = groceryQuantity[j + 1];
                }

                groceryList[numberOfGroceries] = null;
                groceryQuantity[numberOfGroceries] = 0;

                System.out.println(itemName + " removed from the grocery list.");
                break;
            }
        }

        if (!itemRemoved) {
            System.out.println(itemName + " not found in the grocery list.");
        }
    }

    public static void viewGroceryList() {
        if (numberOfGroceries == 0) {
            System.out.println("Grocery list is empty.");
        } else {
            System.out.println("Grocery List:");
            for (int i = 0; i < numberOfGroceries; i++) {
                System.out.println(groceryQuantity[i] + " " + groceryList[i]);
            }
        }
    }
}
