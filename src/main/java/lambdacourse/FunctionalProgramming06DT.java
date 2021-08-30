package lambdacourse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FunctionalProgramming06DT {
    public static void main(String[] args) throws IOException {
        //how to read text from the file
        Files.lines(Paths.get("src/main/java/lambdacourse/myText.txt")).forEach(System.out::println);
        System.out.println("====================");
        //How to convert all characters in the file to upper case
        Files.lines(Paths.get("src/main/java/lambdacourse/myText.txt")).map(String::toUpperCase).forEach(System.out::println);

        System.out.println("=========================");
        //How to check if a specific word(Lambda) exists in the text
        boolean result = Files.lines(Paths.get("src/main/java/lambdacourse/myText.txt")).anyMatch(t->t.contains("Lambda"));
        System.out.println(result);

        System.out.println("=========================");
        //****** Print distinct words on the console in the file
        Files.
                lines(Paths.get("src/main/java/lambdacourse/myText.txt")).
                map(t->t.split(" ")).
                flatMap(Arrays::stream).
                distinct().
                forEach(System.out::println);
        System.out.println("=========================");
        //Get the words which end with “e” and print them on the console
        Files.
                lines(Paths.get("src/main/java/lambdacourse/myText.txt")).
                map(t->t.split(" ")).
                flatMap(Arrays::stream).
                filter(t->t.endsWith("e")).
                forEach(System.out::println);

    }
}
