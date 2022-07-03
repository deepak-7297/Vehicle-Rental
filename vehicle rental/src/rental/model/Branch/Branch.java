package rental.model.Branch;

import rental.model.booking.Booking;
import rental.model.vehicle.Vehicle;
import rental.model.vehicle.VehicleType;

import java.util.*;

public class Branch {
    public UUID id;
    public String name;
    public List<Vehicle> vehicleList;
    public Set<VehicleType> vehicleTypes = new HashSet<>();

    //Keeping track of all branch booking
    public List<Booking> bookings;

    public Branch(String name, Set<VehicleType> vehicleTypes) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.vehicleTypes = vehicleTypes;
        this.vehicleList = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public Set<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }


    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicleList.add(vehicle);
    }

    public void addVehicleType(VehicleType vehicleType){
        this.vehicleTypes.add(vehicleType);
    }

    public void addBookingDetail(Booking booking){
       bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
