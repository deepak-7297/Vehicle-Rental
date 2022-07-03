package test;

import org.junit.Test;
import rental.commands.AddBranchCommand;
import rental.model.Branch.Branch;
import rental.model.vehicle.Vehicle;
import rental.model.vehicle.VehicleFactory;
import rental.model.vehicle.VehicleType;
import rental.service.BookingService;
import rental.service.BranchService;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class BranchServiceTest {
    @Test
    public void addBranchTest(){
        BranchService branchService = new BranchService();
        Set<VehicleType> vehicleTypeSet = new HashSet<>();
        vehicleTypeSet.add(VehicleType.BIKE);
        assertEquals(branchService.addBranch("branchName", vehicleTypeSet), true);
    }

    @Test
    public void addVehicleTest(){
        BranchService branchService = new BranchService();
        Set<VehicleType> vehicleTypeSet = new HashSet<>();
        vehicleTypeSet.add(VehicleType.CAR);
        Branch branch = new Branch("branchName", vehicleTypeSet);
        Vehicle vehicle = VehicleFactory.getVehicle("CAR","213","123");
        assertEquals(branchService.addVehicle(branch, vehicle), true);
    }

}
