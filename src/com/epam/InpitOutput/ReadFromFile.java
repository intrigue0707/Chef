package com.epam.InpitOutput;
import com.epam.Ingridients.Products;

import java.io.*;
import java.util.List;

/**
* Created by Maryia on 11/12/2015.
        */
public class ReadFromFile {
    public static void readFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/com/epam/Products/salad.txt"));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't read file");
        }
    }}



