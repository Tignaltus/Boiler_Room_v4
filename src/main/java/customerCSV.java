import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class customerCSV
{
    public static void main(String[] args) throws IOException
    {
        Path csvinput = Paths.get("boilerroom.csv");

        List<Customer> customers = Files.lines(csvinput)
                .skip(1)
                .map(line -> line.split(","))
                .map(p -> new Customer(
                        p[0].trim(),
                        p[1].trim(),
                        Double.parseDouble(p[2].trim())
                ))
                .toList();

        List<String> topCustomer = customers.stream()
                .filter(c -> c.getOrderValue()>=1000)
                .sorted((val1, val2)-> (int) (val2.getOrderValue() - val1.getOrderValue()))
                .limit(10)
                .map(c -> "name: " + c.getName() + " city: " + c.getCity() + " order value(sek): " + c.getOrderValue() + "\n")
                .collect(Collectors.toList());

        System.out.println(topCustomer);

        Path filepath = Paths.get("report.txt");
        Files.write(filepath, topCustomer);
    }
}
