package rental.model.vehicle;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType, String vehicleId, String price){
        int vehiclePrice = Integer.parseInt(price);
        Vehicle vehicle = null;
        switch(VehicleType.valueOf(vehicleType)){
            case CAR :
                vehicle = new Car(vehicleId, vehiclePrice);
                break;
            case BIKE:
                vehicle = new Bike(vehicleId, vehiclePrice);
                break;
            case BUS:
                vehicle = new Bus(vehicleId, vehiclePrice);
                break;
            case VAN:
                vehicle = new Van(vehicleId, vehiclePrice);
                break;
            default:
                break;
        }
        return vehicle;
    }

}
