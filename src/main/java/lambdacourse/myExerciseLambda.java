package lambdacourse;

import java.util.ArrayList;
import java.util.List;

public class myExerciseLambda {
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
        printEven(l);
    }


    public static void printEven(List<Integer> l){
        l.stream().filter(t -> t%2 ==0).forEach(t -> System.out.print(t+" "));
    }
}
