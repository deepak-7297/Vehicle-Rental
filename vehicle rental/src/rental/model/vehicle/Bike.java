package rental.model.vehicle;

public class Bike extends Vehicle{

    public Bike(String id, int price){
        super(id, price);
    }

    @Override
    public VehicleType type() {
        return VehicleType.BIKE;
    }

}
