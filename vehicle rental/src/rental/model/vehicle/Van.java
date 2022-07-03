package rental.model.vehicle;

public class Van extends Vehicle{

    public Van(String id, int price){
        super(id, price);
    }

    @Override
    public VehicleType type() {
        return VehicleType.VAN;
    }

}
