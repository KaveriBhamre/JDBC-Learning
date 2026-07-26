package database2;

public class Car extends Vehicle {
    private int id;
    private String model_name;

    public Car() {}

    public Car(int id, String model_name, String color, double price, String company_name, String fuel_type) {
        super(color, price, company_name, fuel_type);
        this.id = id;
        this.model_name = model_name;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModel_name() { return model_name; }
    public void setModel_name(String model_name) { this.model_name = model_name; }
    
    @Override
    public String toString() {
        return "Car [id=" + id +
               ", model_name=" + model_name + ", " +
               super.toString() + "]";
    }
    
}