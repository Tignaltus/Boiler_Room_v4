import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class customerCSV
{
    public static void main(String[] args)
    {
        Path csvinput = null;
        List<Customer> customers = new ArrayList<>();

        try
        {
            csvinput = Paths.get("boilerroom.csv");
            System.out.println("File found");

            customers = Files.lines(csvinput)
                .skip(1)
                .map(line -> line.split(","))
                .map(p -> new Customer(
                        p[0].trim(),
                        p[1].trim(),
                        Double.parseDouble(p[2].trim())
                ))
                .toList();
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        if (csvinput == null)
        {
            return;
        }

        List<String> topCustomer = customers.stream()
                .filter(c -> c.getOrderValue()>=1000)
                .sorted((val1, val2)-> (int) (val2.getOrderValue() - val1.getOrderValue()))
                .limit(10)
                .map(c -> "name: " + c.getName() + " city: " + c.getCity() + " order value(sek): " + c.getOrderValue() + "\n")
                .collect(Collectors.toList());

        System.out.println(topCustomer);

        try
        {
            Path filepath = Paths.get("report.txt");
            Files.write(filepath, topCustomer);
            System.out.println("Report created");
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
