package com.elie.problems;

import java.util.*;

public class Solution {
    public static void main (String[] args) {
        String[] recipes = new String[] {"bread"};
        List<List<String>> ingredients = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list.add("yeast");
        list.add("flour");
        ingredients.add(list);
        String[] supplies = new String[] {"yeast"};
        List<String> ret = findAllRecipes(recipes, ingredients, supplies);

    }


    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ret = new ArrayList<>();
        List<String> newSupplies = new ArrayList<>();
        newSupplies.addAll(List.of(supplies));

        Map<String, List<String>> map = new HashMap<>();
        int index = 0;
        for (String recipe : recipes) {
            map.put(recipe, ingredients.get(index));
            index++;
        }

        for (String recipe : recipes) {
            if (canBeDone(recipe, map, newSupplies)) {
                ret.add(recipe);
            }
        }

        return ret;
    }

    private static boolean canBeDone(String recipe, Map<String, List<String>> map, List<String> newSupplies) {
        for (String ingredient : map.get(recipe)) {
            if (!newSupplies.contains(ingredient) && !map.keySet().contains(recipe)) {
                return false;
            }

            if (isDependendingCanBeFound(Arrays.asList(ingredient), map, newSupplies)) {
                newSupplies.add(recipe);
                return true;
            }
        }
        return false;
    }

    private static boolean isDependendingCanBeFound(List<String> ingredient, Map<String, List<String>> map, List<String> newSupplies) {
        if(newSupplies.containsAll(ingredient)) {
            return true;
        }

        if (map.keySet().containsAll(ingredient)) {
            List<String> dependencies = map.get(ingredient);
            return isDependendingCanBeFound(dependencies, map, newSupplies);
        }
        return false;
    }
}
