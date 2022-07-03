package rental.commands;

import rental.model.vehicle.Vehicle;
import rental.model.vehicle.VehicleFactory;
import rental.service.BranchService;

public class AddVehicleCommand implements Command{

    public String branchName;
    public String vehicleType;
    public String vehicleId;
    public String price;
    public BranchService branchService;

    public AddVehicleCommand(String branchName, String vehicleType, String vehicleId, String price, BranchService branchService) {
        this.branchName = branchName;
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.price = price;
        this.branchService = branchService;
    }

    @Override
    public CommandType commandName() {
        return CommandType.ADD_VEHICLE;
    }

    @Override
    public void execute() {
        Vehicle vehicle = VehicleFactory.getVehicle(vehicleType, vehicleId, price);
        System.out.println(branchService.addVehicle(branchService.getBranch(branchName), vehicle));
    }
}
