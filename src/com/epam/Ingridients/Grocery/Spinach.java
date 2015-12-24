package com.epam.Ingridients.Grocery;

import com.epam.Ingridients.Products;

/**
 * Created by Maryia_Ihnatsenka on 2015-11-11.
 */
public class Spinach extends Products {
    public Spinach(double weight){
        super.setName("Spinach");
        super.setCalories();
        super.setCategory("Grocery");
        super.setWeight(weight);
    }
}
