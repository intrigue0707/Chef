package com.epam.Products;

import com.epam.Exceptions.MyIOEforstring;
import com.epam.Exceptions.MyIOException;
import com.epam.Exceptions.MyInputException;
import com.epam.Ingridients.Fruits.Apple;
import com.epam.Ingridients.Fruits.Peaches;
import com.epam.Ingridients.Fruits.Pear;
import com.epam.Ingridients.Grocery.Dill;
import com.epam.Ingridients.Grocery.Onion;
import com.epam.Ingridients.Grocery.Spinach;
import com.epam.Ingridients.Products;
import com.epam.Ingridients.Vegetables.Cabbage;
import com.epam.Ingridients.Vegetables.Cucumber;
import com.epam.Ingridients.Vegetables.Tomato;
import com.epam.InpitOutput.SavetoFile;
import com.epam.DB.ConnectToSQLLite;
import java.io.IOException;
import java.util.InputMismatchException;

import static com.epam.InpitOutput.ReadFromFile.readFromFile;
import static com.epam.Products.IOStreams.*;

/**
 * Created by Maryia_Ihnatsenka on 2015-11-11.
 */
public class Main {
    Salad salad = new Salad();

    public static void main(String[] args) throws IOException, MyInputException, MyIOException, MyIOEforstring {
        Salad salad = new Salad();

        System.out.println("How many ingridients do you want to mix in salad?");
        int quantityOfingr = scanNumbers();
        ConnectToSQLLite.createTable();
        for (int i = 0; i < quantityOfingr; i++) {
                System.out.println("What ingridient do you want to choose:Cabbage, Cucumber,Tomato,Dill, Onion, Spinach,Apple,Peaches,Pear?");
                String ingr = scanMessage();

            System.out.println("Insert required weight of ingridient in grams");
            double reqweight = scanDouble();

            switch (ingr) {
                case "Cabbage":
                    salad.mix.add(new Cabbage(reqweight));
                    break;
                case "Cucumber":
                    salad.mix.add(new Cucumber(reqweight));
                    break;
                case "Tomato":
                    salad.mix.add(new Tomato(reqweight));
                    break;
                case "Dill":
                    salad.mix.add(new Dill(reqweight));
                    break;
                case "Onion":
                    salad.mix.add(new Onion(reqweight));
                    break;
                case "Spinach":
                    salad.mix.add(new Spinach(reqweight));
                    break;
                case "Apple":
                    salad.mix.add(new Apple(reqweight));
                    break;
                case "Peaches":
                    salad.mix.add(new Peaches(reqweight));
                    break;
                case "Pear":
                    salad.mix.add(new Pear(reqweight));
                    break;
                default:
                    try {
                        throw new MyInputException();
                    } catch (MyInputException e) {
                        e.printStackTrace();
                    }
            }
                   }

        salad.getTotalCallories();
        salad.sortCollection();
        salad.findIngr();
        SavetoFile.savetoFile(Salad.mix);
        ConnectToSQLLite.insertTable(Salad.mix);
        throw new MyIOException();

    }
}