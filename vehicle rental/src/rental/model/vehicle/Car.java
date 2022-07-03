package rental.model.vehicle;

public class Car extends Vehicle{

    public Car(String id, int price){
        super(id, price);
    }

    @Override
    public VehicleType type() {
        return VehicleType.CAR;
    }
}
