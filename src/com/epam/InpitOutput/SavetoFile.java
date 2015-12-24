package com.epam.InpitOutput;

import com.epam.Ingridients.Products;
import com.epam.Products.Salad;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maryia on 11/12/2015.
 */

public class SavetoFile {

    public static void savetoFile(ArrayList<Products> mix) throws IOException {
        File file = new File("src/com/epam/products/salad.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File does not exist");
        }
        try{
        PrintWriter writer = new PrintWriter(new FileWriter("src/com/epam/products/salad.txt"));
        for (Products prod : mix) {
            writer.write("|" + prod.getName() + "|\t|" + prod.getCategory() + "|\t| Weight: " + prod.getWeight() + "|\n|");
        }
        writer.close();}
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Data was not written to file");
        }

    }
    public static void main(String[] args) throws IOException {

        savetoFile(Salad.mix);
    }
}
