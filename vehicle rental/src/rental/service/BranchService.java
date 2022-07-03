package rental.service;

import rental.model.Branch.Branch;
import rental.model.booking.Booking;
import rental.model.vehicle.Vehicle;
import rental.model.vehicle.VehicleType;

import java.awt.print.Book;
import java.util.*;
import java.util.stream.Collectors;

public class BranchService {
    public Map<String, Branch> branchList;

    public BranchService() {
        this.branchList = new HashMap<>();
    }

    public boolean addBranch(String name, Set<VehicleType> vehicleTypes){
        if(branchList.containsKey(name))
            return false;

        Branch branch = new Branch(name, vehicleTypes);
        branchList.put(name, branch);
        return true;
    }

    public boolean addVehicle(Branch branch,Vehicle vehicle){
        if(!branch.getVehicleTypes().contains(vehicle.type()))
            return false;

        branch.addVehicleType(vehicle.type());
        branch.addVehicle(vehicle);
        return true;
    }

    public Branch getBranch(String branchName){
        return branchList.get(branchName);
    }

    public List<String> displayVehicles(String branchName, Integer startTime, Integer endTime){
        List<VehicleType> vehicleTypes = Arrays.asList(VehicleType.BUS, VehicleType.BIKE, VehicleType.CAR, VehicleType.VAN);

        List<String> vehicles = new ArrayList<>();
        for(VehicleType vehicleType: vehicleTypes){
            List<Vehicle> avlVehicles = getAvailableVehicles(branchName, vehicleType, startTime, endTime);
            vehicles.addAll(avlVehicles.stream().map(Vehicle::getId).collect(Collectors.toList()));
        }
        return vehicles;
    }

    public List<Vehicle> getAvailableVehicles(String branchName, VehicleType vehicleType, Integer startTime, Integer endTime){
        Branch branch = getBranch(branchName);
        List<Booking> bookings = branch.getBookings();
        List<Vehicle> vehicles = branch.getVehicleList().stream().filter(vehicle -> vehicle.type().equals(vehicleType)).collect(Collectors.toList());

        List<Vehicle> availableVehicles = new ArrayList<>();

        for(Vehicle vehicle: vehicles){
            if(Objects.isNull(bookings) || bookings.size()==0) {
                availableVehicles.add(vehicle);
                continue;
            }

            List<Booking> bookingsOfSameVehicleType = bookings.stream().
                    filter(booking -> booking.getVehicle().getId().equals(vehicle.getId())).collect(Collectors.toList());

            boolean addflag = true;
            for(Booking booking: bookingsOfSameVehicleType){
                if(startTime < endTime && (endTime <= booking.getStartTime() || startTime >=booking.getEndTime())) {
                    continue;
                }
                else{
                    addflag = false;
                    break;
                }
            }
            if(addflag) availableVehicles.add(vehicle);
        }

        return availableVehicles;
    }
}
