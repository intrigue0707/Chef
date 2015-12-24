package com.epam.Ingridients.Fruits;

import com.epam.Ingridients.Products;

/**
 * Created by Maryia_Ihnatsenka on 2015-11-11.
 */
public class Apple extends Products {
    public Apple(double weight){
        super.setName("Apple");
        super.setCalories();
        super.setCategory("Fruits");
        super.setWeight(weight);
    }
}
