package edu.sdccd.cisc191.o;

import edu.sdccd.cisc191.o.Database;

public class Ingredient extends Database {
    private static String ingredient;
    private static Double amount;
    private static int totalCalories;

    public static int calculateCaloriesForIngredient(String ingredientName, double ingredientAmount){
        ingredient = ingredientName;
        amount = ingredientAmount;
        totalCalories = 0;
        //calculate and assign to totalCalories
        return totalCalories;
    }


    @Override
    public int getTotalCalories() {
        return totalCalories;
    }
}
