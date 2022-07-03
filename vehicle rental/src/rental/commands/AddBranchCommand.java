package rental.commands;

import rental.model.vehicle.VehicleType;
import rental.service.BranchService;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddBranchCommand implements Command{
    public  String branchName;
    public String vehicleTypes;
    public BranchService branchService;

    public AddBranchCommand(String branchName, String vehicleTypes, BranchService branchService){
        this.branchName = branchName;
        this.vehicleTypes = vehicleTypes;
        this.branchService = branchService;
    }

    @Override
    public CommandType commandName() {
        return CommandType.ADD_BRANCH;
    }

    @Override
    public void execute() {
        Set<VehicleType> vehicleTypeSet = Stream.of(vehicleTypes.trim().split(",")).map(type -> VehicleType.valueOf(type)).collect(Collectors.toSet());
        System.out.println(branchService.addBranch(branchName, vehicleTypeSet));
    }
}
