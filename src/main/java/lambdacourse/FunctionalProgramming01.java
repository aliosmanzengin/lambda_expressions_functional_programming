package lambdacourse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming01 {
    /*
    1)Lambda is Functional Programming
    2)Functional Programming was added to Java 8, before Java 8 we were using just Structured Programming.
        But after Java 8, we are able to use both Functionalr Programming and Structured Programming.
    3)Structured Programming focuses on "How to do" most of the times,
      Functional Programming focuses on "What to do".
    4)Functional Programming is used with Collections and Arrays

     */
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(12);
        l.add(9);
        l.add(131);
        l.add(4);
        l.add(9);
        l.add(10);
        l.add(44);
        l.add(12);
        l.add(15);
        printElStructured(l);
        System.out.println();
        printElFunctional(l);
        System.out.println();
        printEvenElementsStructured(l);
        System.out.println();
        printEvenFunctional(l);
        System.out.println();
        printSquareOfOdds(l);
        System.out.println();
        printCubeOfDistinctOdds(l);
        System.out.println();
        sumOfSquareDistinctEvens(l);
        System.out.println();
        productOfCubeDistinctEvens(l);
        System.out.println();
        getMaxElement2(l);
        System.out.println();
        getMinElement(l);
        getMinElement2(l);
        greaterThan7Even1(l);
        greaterThan7Even2(l);
        getHalfOfDistinctElReversed(l);



    }
//1)Create a method to print the list elements on the console in the same line with a space between two consecutive elements.(Structured)
public static void printElStructured(List<Integer> l){

    for (Integer w: l) {
        System.out.print(w +" ");
    }
}
//1)Create a method to print the list elements on the console in the same line with a space between two consecutive elements.(functional)
public static void printElFunctional(List<Integer> l){

        l.stream().forEach(t->System.out.print(t + " "));
}

//2)Create a method to print the even list elements on the console in the same line with a space between two consecutive elements.(Structured)
public static void printEvenElementsStructured(List<Integer> l){
    for (Integer w: l) {
        if (w%2==0)
        System.out.print(w +" ");
    }
}
//2)Create a method to print the even list elements on the console in the same line with a space between two consecutive elements.(functional)
public static void printEvenFunctional(List<Integer> l){
        l.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" "));//t->t%2==0 the name of that structure is named "Lambda Expression"
}

//3)Create a method to print the square of odd list elements on the console in the same line with a space between two consecutive elements.
public static void printSquareOfOdds(List<Integer> l){
        l.stream().filter(t->t%2!=0).map(t->t*t).forEach(t-> System.out.print(t+" "));//map() method is used to change the value of elements according to the given function
}

//4)Create a method to print the cube of distinct(not same) odd list elements on the console in the same line with a space between two consecutive elements.
public static void printCubeOfDistinctOdds(List<Integer> list)  {
    list.stream().filter(t->t%2!=0).distinct().map(t->t*t*t).forEach(t-> System.out.print(t+" "));//distinct() removes repeated ones
}

//5)Create a method to calculate the sum of the squares of distinct even elements
    public static void sumOfSquareDistinctEvens(List<Integer> l){
       /*Integer sum= l.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0,(t,u)->t+u);*/ //reduce method returns value
        Integer sum= l.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0, Integer::sum);
        System.out.println("sum of the squares of even distinct elements is "+sum);
    }

    //6)Create a method to calculate the product of the cubes of distinct even elements
    public static void productOfCubeDistinctEvens(List<Integer> l){
        Integer prod= l.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1,(t,u)->t*u);//reduce method returns value
        System.out.println("product of the cubes of even distinct elements is "+prod);
    }

    //7)Create a method to find the maximum value from the list elements
    //1.WAY:
    public static void getMaxElement(List<Integer> l){
        Integer maxEl= l.stream().reduce(Integer.MIN_VALUE,(t,u)-> t>u ? t:u);//reduce method returns value
        System.out.println("biggest element is: "+maxEl);
    }
    //2.WAY:
    public static void getMaxElement2(List<Integer> l){
        //Returns a stream consisting of the elements of this stream, sorted according to natural order.
        Integer maxEl= l.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t,u)->u);
        System.out.println("biggest element is: "+maxEl);
    }

    //8)Create a method to find the min value from the list elements
    //1.WAY:
    public static void getMinElement(List<Integer> l){
        Integer minEl= l.stream().reduce(Integer.MAX_VALUE,(t,u)-> t<u ? t:u);//reduce(Integer.MAX_VALUE,(t,u)-> t>u ? u:t)
        System.out.println("min element is: "+minEl);
    }

    //2.WAY:
    public static void getMinElement2(List<Integer> l){
        Integer minEl= l.stream().distinct().sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE, (t, u)->u);
        System.out.println("min element is: "+minEl);
    }
    //9) create a method to find the min value which is greater than 7 and even
    //1.WAY:
    public static void greaterThan7Even1(List<Integer> l){
        Integer sevenEven= l.stream().distinct().filter(t->t%2==0 && t>7).reduce(Integer.MAX_VALUE,(t,u)-> t<u ? t:u);
        System.out.println("sevenEven is: "+sevenEven);
    }

    //2.WAY:
    public static void greaterThan7Even2(List<Integer> l){
        Integer sevenEven= l.stream().distinct().filter(t->t%2==0 && t>7).sorted().findFirst().get();
        //use findFirst() together with .get() to get Integer return type. Otherwise you will get optional integer
        System.out.println("sevenEven is: "+sevenEven);
    }

    //10)Create a method to find the half of the elements which are distinct and greater than 5 in reverse order from the list.
    public static void getHalfOfDistinctElReversed(List<Integer> l){
        List<Double> resultL= l.stream().distinct().filter(t->t>7).map(t->t/2.0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        //toList() returns List
        //.collect(Collectors.toList()); //to make it structured usability

        System.out.println("halving greater than 5: "+resultL);
    }



}
