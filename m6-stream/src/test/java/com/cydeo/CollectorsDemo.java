package com.cydeo;

import com.cydeo.task.Dish;
import com.cydeo.task.DishData;
import com.cydeo.task.Type;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3,4,5,6,6,7);

       List<Integer>numberList =  numbers.stream()
                .filter(x-> x %2==0)
                .collect(Collectors.toCollection(ArrayList::new));
       System.out.println(numberList);

        System.out.println("-------------------");

        Set<Integer> numberSet = numbers.stream()
                .filter(x-> x%2==0)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(numberSet);

        // toList() :

       List<Integer> numberList2=  numbers.stream()
                .filter(x-> x%2==0)
                .collect(Collectors.toList());

       // toSet () :
        Set<Integer> numberList3=  numbers.stream()
                .filter(x-> x%2==0)
                .collect(Collectors.toSet());

        System.out.println(numberList3);

        // toMap (Function, Function):
        Map<String, Integer> dishMap =  DishData.getAll().stream()
                .collect(Collectors.toMap(Dish::getName, Dish::getCalories));
        System.out.println(dishMap);

        // summingInt (ToIntFunction) : returns a Collector that produces the sum of integer value

      Integer sum =  DishData.getAll().stream()
                .collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(sum);

        //counting () : returns a Collector that counts number of elements
        Long evenCount = numbers.stream()
                .filter(x-> x%2==0)
                .collect(Collectors.counting());

        // averagingInt (ToIntFunction): returns the average of integer passed value

      Double caloriesAverage =  DishData.getAll().stream()
                .collect(Collectors.averagingInt(Dish::getCalories));

        System.out.println(caloriesAverage);

        // joining : is used to join variouse elements of a character or string array

        List<String> courses = Arrays.asList("Java", "JS", "TS");
        String course1=   courses.stream()
                .collect(Collectors.joining(","));
        System.out.println(course1);

        // partitioningBy() : is used to partition a stream of objects
        Map<Boolean,List<Dish>> veggieDish =  DishData.getAll().stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(veggieDish);

        //groupingBy() : is used for grouping objects by some property and storing result in a Map instance

         Map <Type, List<Dish>>  dishType = DishData.getAll().stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishType);

    }
}
