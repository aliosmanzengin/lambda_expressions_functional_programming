package lambdacourse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FunctionalProgramming04 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(12);
        l.add(9);
        l.add(13);
        l.add(4);
        l.add(9);
        l.add(2);
        l.add(4);
        l.add(12);
        l.add(15);
        getSumOfAllElements(l);
        getSumOfIntFrom7To100A();
        getSumOfIntFrom7To100B();
        getSumOfIntFromXToY(-1071,1985);
        getProductOfIntFromXToY(2,4);
        getFactorial(5);
        getSumOfEvenIntFromXToY(4,8);
        sumOfDigitsInAllIntegers(23,27);
    }

    //1)Create a method to find the sum of all elements in the list
    public static void getSumOfAllElements(List<Integer> l){
        //in functional programming some methods must be the last method(e.g. reduce()..) , that kind of methods are called "terminal methods"
        Integer sum=l.stream().reduce(0,Math::addExact);
        System.out.println(sum);
    }

    //2)Create a method to find the sum of integers from 7 to 100
    //1.WAY:
    public static void getSumOfIntFrom7To100A(){
        Integer sum=IntStream.range(7, 101).reduce(0,Math::addExact);
        System.out.println(sum);
    }

    //2.WAY:
    public static void getSumOfIntFrom7To100B(){
        Integer sum=IntStream.rangeClosed(7, 100).reduce(0,Math::addExact);
        System.out.println(sum);
    }

    //3.WAY:
    public static void getSumOfIntFromXToY(int x, int y){
        Integer sum=IntStream.rangeClosed(x, y).reduce(0,Math::addExact);
        System.out.println(sum);
    }

    //3)Create a method to find the multiplication of the integers from 2(inc) to 11(inc)
    public static void getProductOfIntFromXToY(int x, int y){
        Integer sum=IntStream.rangeClosed(x, y).reduce(1,Math::multiplyExact);
        System.out.println(sum);
    }

    //4)Create a method to calculate the factorial of a given number.(5 factorial = 1*2*3*4*5  ==> 5! = 1*2*3*4*5)
    public static void getFactorial(int x){
        Integer fac=IntStream.rangeClosed(1, x).reduce(1,Math::multiplyExact);
        System.out.println(fac);
    }

    //5)Create a method to calculate the sum of even integers between given two integers
    public static void getSumOfEvenIntFromXToY(int x, int y){
        Integer sum=IntStream.rangeClosed(x, y).filter(Utils::checkToBeEven).reduce(0,Math::addExact);
        System.out.println(sum);
    }

    //6)Create a method to calculate the sum of digits of every integers between given two integers
    //1.WAY:
    public static void sumOfDigitsInAllIntegers(int x , int y){
        Integer sum=IntStream.rangeClosed(x, y).map(Utils::getSumOfDigits).reduce(0,Math::addExact);
        System.out.println(sum);
    }
    //2.WAY
    //instead of "reduce(0,Math::addExact);" , You can use sum()
    public static void sumOfDigitsInAllIntegers1(int x , int y){
        Integer sum=IntStream.rangeClosed(x, y).map(Utils::getSumOfDigits).sum();
        System.out.println(sum);
    }

}
