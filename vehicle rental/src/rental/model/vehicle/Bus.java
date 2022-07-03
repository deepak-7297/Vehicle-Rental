package rental.model.vehicle;

public class Bus extends Vehicle{

    public Bus(String id, int price){
       super(id, price);
    }

    @Override
    public VehicleType type() {
        return VehicleType.BUS;
    }
}
