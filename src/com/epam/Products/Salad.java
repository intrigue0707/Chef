package com.epam.Products;

import com.epam.Exceptions.MyIOEforstring;
import com.epam.Ingridients.Products;
import com.epam.InpitOutput.ReadFromFile;
import com.epam.InpitOutput.SavetoFile;
import com.epam.JSON.ReadJSON;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maryia_Ihnatsenka on 2015-11-10.
 */
public class Salad {

    public static ArrayList<Products> mix= new ArrayList<Products>();

    public void getTotalCallories(){
        double totalcalories = 0;
        for (Products ingridient : mix) {
            totalcalories = ingridient.getWeight() * ingridient.getCalories() / 100;
        }
        System.out.println("Total amount of callories: " + totalcalories);
        }



        public static Comparator<Products> nameComparator = new Comparator<Products>() {

            public int compare(Products ingr1, Products ingr2) {

                String ingrName1 = ingr1.getName().toUpperCase();
                String ingrName2 = ingr2.getName().toUpperCase();


                return ingrName1.compareTo(ingrName2);
            }
        };
    public static void sortCollection(){
        Collections.sort(mix, nameComparator);
        for (Products e:mix){
            System.out.println(e);
        }
    }

    public static void findIngr () throws IOException, MyIOEforstring {
        String message = IOStreams.scanMessage();
        List<Products> findIngr =
                mix.stream().filter((p)-> p.getName().equals((message))).collect(Collectors.toList());
        System.out.println(findIngr);
        SavetoFile.savetoFile(mix);
    }


}

