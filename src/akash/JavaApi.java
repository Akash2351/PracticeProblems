package akash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by akash on 19-10-2017.
 */
public class JavaApi {

    public static void main(String[] args) {

        //no format
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println(formatter.format(4.0));

        double price = 52000;
        System.out.println(String.format("%.2f", price));

        System.out.printf("Hello %s, my name is %s, age: %d", "akash", "aka", 27);

        //files with java 8:
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("res/nashorn1.js"));
            lines.add("print('foobar');");
            Files.write(Paths.get("res/nashorn1-modified.js"), lines);
            HashSet s;

            //using stream, read one by one, instead of reading all at once..
            try (Stream<String> stream = Files.lines(Paths.get("res/nashorn1.js"))) {
                stream
                        .filter(line -> line.contains("print"))
                        .map(String::trim)
                        .forEach(System.out::println);
            }

            //other ways of doing it
            Path path = Paths.get("res/nashorn1.js");
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                System.out.println(reader.readLine());
            }

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write("print('Hello World');");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread tl;

    }
}
