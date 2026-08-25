package database2;

public class Vehicle {
    private String color;
    private double price;
    private String company_name;
    private String fuel_type;

    public Vehicle() {}

    public Vehicle(String color, double price, String company_name, String fuel_type) {
        this.color = color;
        this.price = price;
        this.company_name = company_name;
        this.fuel_type = fuel_type;
    }

    // Getters & Setters
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getCompany_name() { return company_name; }
    public void setCompany_name(String company_name) { this.company_name = company_name; }

    public String getFuel_type() { return fuel_type; }
    public void setFuel_type(String fuel_type) { this.fuel_type = fuel_type; }
    
    @Override
    public String toString() {
        return "Vehicle [color=" + color +
               ", price=" + price +
               ", company_name=" + company_name +
               ", fuel_type=" + fuel_type + "]";
    }
}