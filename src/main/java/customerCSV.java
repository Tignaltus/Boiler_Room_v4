import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class customerCSV
{
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        List<Customer> customers = Arrays.asList(
                new Customer("Jonatan", "Lund", 24000),
                new Customer("Felix", "Dalby", 4000),
                new Customer("Rasha", "Malmö", 2000),
                new Customer("Kostas", "Lund", 200));



//.sorted(Comparator.comparing(Customer::getOrderValue).reversed())
    List<String> topCustomer = customers.stream()
            .filter(c -> c.getOrderValue()>=1000)
            .sorted((val1, val2)-> (int) (val2.getOrderValue() - val1.getOrderValue()))
            .limit(10)
            .map(c -> "name: " + c.getName() + " city: " + c.getCity() + " order value: " + c.getOrderValue() + "\n")
            .collect(Collectors.toList());

        System.out.println(topCustomer);


        Path filepath = Paths.get("report.txt");
        Files.write(filepath, topCustomer);


        }
}
