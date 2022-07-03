package rental.service.strategy;

import rental.model.vehicle.Vehicle;
import java.util.List;

import static java.util.Comparator.comparing;

public class LowestPriceFirstStrategy implements VehicleAllotmentStrategy{
    public List<Vehicle> vehicleList;

    public LowestPriceFirstStrategy(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public Vehicle getVehicle() {
        vehicleList.sort(comparing(Vehicle::getPrice));
        return vehicleList.get(0);
    }
}
