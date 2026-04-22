package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class SearchInventory {

    private static final String INV_FILE_NAME = "inventory.csv";

    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();



        for (Product product : inventory) {
            System.out.println(product);
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
