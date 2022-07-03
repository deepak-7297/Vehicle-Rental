package rental.model.vehicle;

public abstract class Vehicle {
    //assuming default vehicleStatus of all new vechile as AVAILABKE
    public VehicleStatus vehicleStatus = VehicleStatus.AVAILABLE;
    public String id;
    public int price;

    public Vehicle(String id, int price){
        this.id = id;
        this.price = price;
    }

    public abstract VehicleType type();

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}
