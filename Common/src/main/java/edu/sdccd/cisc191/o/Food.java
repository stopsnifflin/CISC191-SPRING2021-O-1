package edu.sdccd.cisc191.o;

import java.util.ArrayList;

public class Food extends Database{
    private static String foodName;
    private static int totalCalories;


    public static int calculateCaloriesForFood(String name){
        foodName = name;
        totalCalories = 0;
        //calculate and assign to totalCalories

        return totalCalories;
    }

    @Override
    public int getTotalCalories() {
        return totalCalories;
    }
}
