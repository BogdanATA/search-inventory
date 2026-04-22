package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SearchInventory {

    private static final String INV_FILE_NAME = "inventory.csv";

    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);

        boolean isDone = false;
        while (!isDone) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1) List all products");
            System.out.println("2) Lookup a product by its id");
            System.out.println("3) Find all products within a price range");
            System.out.println("4) Add a new product");
            System.out.println("5) Quit the application");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command){
                case 1:
                    //list all products
                    for (Product product : inventory) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    //Lookup a product by its id
                    break;
                case 3:
                    //Find all products within a price range
                    break;
                case 4:
                    //Add a new product
                    break;
                case 5:
                    System.out.println("Goodbye");
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid Command");
                    break;



            }
        }




    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        // Write your code here
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INV_FILE_NAME));
            String input;

            while ((input = bufferedReader.readLine()) != null) {
                String[] tokens = input.split("\\|"); // break line into parts everytime it reads "|"

                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double price = Double.parseDouble(tokens[2]);
                // create new Product object
                Product product = new Product(id, name, price);
                inventory.add(product); // adds product to array list
            }
            inventory.sort(Comparator.comparing(Product::getName)); // sort the list by name
            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("Error reading inventory file.");
        }
        return inventory;
    }
}
