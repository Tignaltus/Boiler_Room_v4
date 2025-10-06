public class Customer
{
    private String name;
    private String city;
    private float orderValue;

    public Customer(String name, String city, float orderValue)
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

    public float getOrderValue()
    {
        return orderValue;
    }

    //</editor-fold>
}
