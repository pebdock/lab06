package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    //05
    static long addDuration(List<Integer> myList) {

        long time = System.nanoTime();

        for(int i = 1 ; i <= 100000 ; i++) {
            myList.addFirst(i);
        }

        time = System.nanoTime() - time;
        long millis = TimeUnit.NANOSECONDS.toMillis(time);
        return millis;
    }

    //06
    static long readDuration(List<Integer> myList) {
        long time = System.nanoTime();

        for(int i = 1 ; i <= 1000 ; i++) {
            myList.get(myList.size()/2);
        }

        time = System.nanoTime() - time;
        long millis = TimeUnit.NANOSECONDS.toMillis(time);
        return millis;
    }

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {

        final String SPACE = " ";

        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> myArrayList = new ArrayList<>();

        int firstInteger = 1000;

        while(firstInteger < 2000) {
            myArrayList.add(firstInteger);
            firstInteger += 1;
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        LinkedList<Integer> myLinkedList = new LinkedList<>(myArrayList);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        firstInteger = myArrayList.get(0);
        myArrayList.set(0,myArrayList.get(myArrayList.size()-1));
        myArrayList.set(myArrayList.size()-1,firstInteger);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        for (Integer integer : myArrayList) {
            System.out.print(integer + SPACE);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        /* long time = System.nanoTime();

        for(int i = 1; i <= 1000000; ++i) {
         set.add(Integer.toString(i));
        }

        time = System.nanoTime() - time;
        long millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Converting " + set.size() + " ints to String and inserting them in a Set took " + time + "ns (" + millis + "ms)");*/

        System.out.println("\nmyArrayList addFirst time is: " + addDuration(myArrayList) + "ms");
        System.out.println("\nmyLinkedList addFirst time is: " + addDuration(myLinkedList) + "ms");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        System.out.println("\nmyArrayList reading in the middle time is: " + readDuration(myArrayList) + "ms");
        System.out.println("\nmyLinkedList reading in the middle time is: " + readDuration(myLinkedList) + "ms");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        
        Map<String, Long> mapOfTheWorld = new HashMap<>();
        mapOfTheWorld.put("Africa", 1_110_635_000L);
        mapOfTheWorld.put("Americas", 972_005_000L);
        mapOfTheWorld.put("Antarctica", 0L);
        mapOfTheWorld.put("Asia", 4_298_723_000L);
        mapOfTheWorld.put("Europe", 742_452_000L);
        mapOfTheWorld.put("Oceania", 36_304_000L);

        /*
         * 8) Compute the population of the world
         */
        
        Long totalPopulation = 0L;

        for (String myString : mapOfTheWorld.keySet()) {
            totalPopulation += mapOfTheWorld.get(myString);
        }

        System.out.println("\nLa popolazione mondiale è " + totalPopulation);
    }
}
