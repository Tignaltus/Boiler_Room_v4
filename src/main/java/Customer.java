public class Customer
{
    private String name;
    private String city;
    private double orderValue;

    public Customer(String name, String city, double orderValue)
    {
        this.name = name;
        this.city = city;
        this.orderValue = orderValue;
    }

    //<editor-fold desc="Getters">

    public String getName()
    {
        return name;
    }

    public String getCity()
    {
        return city;
    }

    public double getOrderValue()
    {
        return orderValue;
    }

    //</editor-fold>


    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", orderValue=" + orderValue +
                '}';
    }
}
