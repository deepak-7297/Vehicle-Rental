package rental.commands;

import rental.service.BranchService;

public class DisplayCommand implements Command{
    public String branchName;
    public String startTime;
    public String endTime;
    public BranchService branchService;

    public DisplayCommand(String branchName, String startTime, String endTime, BranchService branchService) {
        this.branchName = branchName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.branchService = branchService;
    }


    @Override
    public CommandType commandName() {
        return CommandType.DISPLAY_VEHICLES;
    }

    @Override
    public void execute() {
        System.out.println(branchService.displayVehicles(branchName, Integer.parseInt(startTime), Integer.parseInt(endTime)));
    }
}
