package lambdacourse;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming02 {
    /*
    Method References:   CLass Name :: Method Name without method paranthesis
    Example==> String :: length
               ArrayList :: size
     */
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(12);
        l.add(9);
        l.add(13);
        l.add(4);
        l.add(9);
        l.add(2);
        l.add(4);
        l.add(12);
        l.add(15);
        printElFunctional(l);
        System.out.println();
        printEvenFunctional(l);
        System.out.println();
        printSquareOfOdds(l);
        System.out.println();
        printCubeOfDistinctOdds(l);
        System.out.println();
        sumOfSquareDistinctEvens(l);
        productOfCubeDistinctEvens(l);
        System.out.println();
        getMaxElement(l);
        greaterThan7Even1(l);
        getHalfOfDistinctElReversed(l);
    }
    //1)Create a method to print the list elements on the console in the same line with a space between two consecutive elements.(Method Reference)
    //If Java has any mehod we prefer to use it, if Java does not have it, we create the method inside Utils class and use it
    public static void printElFunctional(List<Integer> l){
        l.stream().
                    forEach(Utils::printInTheSameLineWithASpace);
    }

    //  2)Create a method to print the even list elements on the console in the same line with a space between two consecutive elements.(Method Reference)
    public static void printEvenFunctional(List<Integer> l){
         l.stream().
                 filter(Utils::checkToBeEven).
                 forEach(Utils::printInTheSameLineWithASpace);
    }

    //3)Create a method to print the square of odd list elements on the console in the same line with a space between two consecutive elements.
    public static void printSquareOfOdds(List<Integer> l){
        l.stream().
                    filter(Utils::checkToBeOdd).
                    map(Utils::getSquare).
                    forEach(Utils::printInTheSameLineWithASpace);//map() method is used to change the value of elements according to the given function
    }


    //4)Create a method to print the cube of distinct(not same) odd list elements on the console in the same line with a space between two consecutive elements.
    public static void printCubeOfDistinctOdds(List<Integer> list)  {
        list.stream().
                    filter(Utils::checkToBeOdd).
                    distinct().map(Utils::getCube).
                    forEach(Utils::printInTheSameLineWithASpace);//distinct() removes repeated ones
    }

    //5)Create a method to calculate the sum of the squares of distinct even elements
    public static void sumOfSquareDistinctEvens(List<Integer> l){
        Integer sum= l.stream().
                                distinct().
                                filter(Utils::checkToBeEven).
                                map(Utils::getSquare).
                                reduce(0,Math::addExact);
        System.out.println("sum of the squares of even distinct elements is "+sum);
    }

    //6)Create a method to calculate the product of the cubes of distinct even elements
    public static void productOfCubeDistinctEvens(List<Integer> l){
        Integer prod= l.stream().
                                distinct().
                                filter(Utils::checkToBeEven).
                                map(Utils::getCube).
                                reduce(1,Math::multiplyExact);//reduce method returns value
        System.out.println("product of the cubes of even distinct elements is "+prod);
    }

    //7)Create a method to find the maximum value from the list elements
    //1.WAY:
    public static void getMaxElement(List<Integer> l){
        Integer maxEl= l.stream().
                            reduce(Integer.MIN_VALUE,Math::max);//reduce method returns value
        System.out.println("biggest element is: "+maxEl);
    }

    //8)Create a method to find the min value from the list elements
    //1.WAY:
    public static void getMinElement(List<Integer> l){
        Integer minEl= l.stream().
                                reduce(Integer.MAX_VALUE,Math::min);//reduce(Integer.MAX_VALUE,(t,u)-> t>u ? u:t)
        System.out.println("min element is: "+minEl);
    }

    //9) create a method to find the min value which is greater than 7 and even
    //1.WAY:
    public static void greaterThan7Even1(List<Integer> l){
        Integer sevenEven= l.stream().
                                    distinct().
                                    filter(t->t>7).
                                    filter(Utils::checkToBeEven).
                                    reduce(Integer.MAX_VALUE,Math::min);
        System.out.println("sevenEven is: "+sevenEven);
    }

    //10)Create a method to find the half of the elements which are distinct and greater than 5 in reverse order from the list.
    public static void getHalfOfDistinctElReversed(List<Integer> l){
        List<Double> resultL= l.
                                stream().
                                distinct().
                                filter(t->t>5).
                                map(Utils::getHalf).
                                sorted(Comparator.reverseOrder()).
                                collect(Collectors.toList());

        System.out.println("halving greater than 5: "+resultL);
    }




}

