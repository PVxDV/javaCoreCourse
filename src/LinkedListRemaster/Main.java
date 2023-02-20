package LinkedListRemaster;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        //  LinkedList<String>  placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);

//        gettingElements(placesToVisit);

//        printItinerary(placesToVisit);
//        printItinerary2(placesToVisit);
//        printItinerary3(placesToVisit);

        testIterator(placesToVisit);
    }

    private static void addMoreElements(LinkedList<String> list) {
        list.addFirst("Darwin");
        list.addLast("Hobart");

        // Queue methods
        list.offer("Melbourne"); // same that addLast() method
        list.offerFirst("Brisbane"); // same that addFirst() method
        list.offerLast("Toowoomba"); // same that addLast() method

        // Stack methods
        list.push("Alice Springs"); // same that addFirst() method
    }

    private static void removeElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);

        String s1 = list.remove(); //removes first element
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst(); // remove first element
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast(); // remove last element
        System.out.println(s3 + " was removed");

        // Queue /Deque poll methods
        String p1 = list.poll(); // removes first element
        System.out.println(p1 + " was removed");

        String p2 = list.pollFirst(); // removes first element
        System.out.println(p2 + " was removed");

        String p3 = list.pollLast(); // removes last element
        System.out.println(p3 + " was removed");

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        String p4 = list.pop(); // removes first element
        System.out.println(p4 + " was removed");
    }

    private static void gettingElements(LinkedList<String> list) {
        System.out.println("Retrieved Element = " + list.get(4));
        System.out.println("First Element = " + list.getFirst());
        System.out.println("Last Element = " + list.getLast());

        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: " + list.indexOf("Melbourne"));

        // Queue retrieval method
        System.out.println("Element from element() = " + list.element()); // returns fist element cos it`s a queue method
        // queue is FIFO (first in, first out)

        //Stack retrieval methods
        System.out.println("Element from peek() = " + list.peek());
        System.out.println("Element from peekFirst() = " + list.peekFirst());
        System.out.println("Element from peekLast() = " + list.peekLast());
    }

    private static void printItinerary(LinkedList<String> list) {
        System.out.println("Trip starts at" + list.getFirst());
        for (int i = 1; i < list.size(); i++) {
            System.out.println("\t---> From: " + list.get(i - 1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    private static void printItinerary2(LinkedList<String> list) {
        System.out.println("Trip starts at" + list.getFirst());
        String previousTown = list.getFirst();
        for(String town: list){
            System.out.println("\t---> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    private static void printItinerary3(LinkedList<String> list) {
        System.out.println("Trip starts at" + list.getFirst());
        String previousTown = list.getFirst();
      //ListIterator<String> iterator = list.listIterator();
        ListIterator<String> iterator = list.listIterator(1); // started on 1! overloaded version
        while (iterator.hasNext()){
            var town = iterator.next();
            System.out.println("\t---> From: " + previousTown + " to " + town);
            previousTown = town;
        }

        System.out.println("Trip ends at " + list.getLast());
    }

    private static void testIterator(LinkedList<String> list) {

        // iterator can only move forward and remove method

//        var iterator = list.iterator();
//        while (iterator.hasNext()){
//            //System.out.println(iterator.next());
//            if(iterator.next().equals("Brisbane")){
//                iterator.remove();
//            }
//        }

        // ListIterator can move forward and backward and remove, set and add methods
        var iterator = list.listIterator();
        while (iterator.hasNext()){
            //System.out.println(iterator.next());
            if(iterator.next().equals("Brisbane")){
                iterator.add("Lake Wivenhoe");
            }
        }

        // after first loop we have to moves backward or crete a new instance of Iterator
        // so we use hasPrevious() method
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        System.out.println(list);

        var iterator2 = list.listIterator(3);
        //System.out.println(iterator2.next());
        System.out.println(iterator2.previous());
    }
}
