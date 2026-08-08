package database2;

public class CarMain {

    public static void main(String[] args) {

        // DISPLAY existing data
        System.out.println("---- ALL CARS ----");
        DatabaseOperation.getAllCars();

        // INSERT
        System.out.println("---- INSERT ----");
        Car car = new Car(1, "i20", "Red", 800000, "Hyundai", "Petrol");
        DatabaseOperation.insertCar(car);

        // DISPLAY after insert
        System.out.println("---- AFTER INSERT ----");
        DatabaseOperation.getAllCars();

        // UPDATE
        System.out.println("---- UPDATE ----");
        Car updatedCar = new Car(1, "i20 Sportz", "Blue", 850000, "Hyundai", "Petrol");
        DatabaseOperation.updateCar(1, updatedCar);

        // SEARCH (if you have method)
        System.out.println("---- SEARCH ----");
        Car found = DatabaseOperation.searchCarById(1);
        if(found != null) {
            System.out.println(found);
        } else {
            System.out.println("Car not found");
        }

        // DELETE
        System.out.println("---- DELETE ----");
        DatabaseOperation.deleteCar(2);

        // FINAL DISPLAY
        System.out.println("---- FINAL DATA ----");
        DatabaseOperation.getAllCars();
    }
}