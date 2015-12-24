package com.epam.Ingridients;

import com.epam.JSON.ReadJSON;
import org.json.JSONException;

import java.io.IOException;


/**
 * Created by Maryia_Ihnatsenka on 2015-11-06.
 */
public abstract class Products{

    private double weight, calories, totalcalories;
    private String name;
    private String category;

    public double getCalories(){
        return calories;
    }
    //public void setCalories(double calories) {
      //  this.calories = calories;
  //  }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setCategory(String category){
        this.category = category;
    }
    public String getCategory(){
        return category;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setCalories() {
        ReadJSON read = new ReadJSON();
        try {
            this.calories = (read.ReadJSON(this.getClass().getSuperclass().getSimpleName(), name) * getWeight()) /100;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
    public double getTotalCallories(){return totalcalories;}
public void getIOStreams(){
    return
    ;}
    @Override
    public String toString (){
        return "Name of ingridient: " + name + " " +  "Weight: " + weight + " " + "category: " + category;
    }
}
