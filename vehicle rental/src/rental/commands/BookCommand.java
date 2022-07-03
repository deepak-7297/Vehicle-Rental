package rental.commands;

import rental.model.vehicle.VehicleType;
import rental.service.BookingService;

public class BookCommand implements Command{
    public String branchName;
    public String vehicleType;
    public String startTime;
    public String endTime;
    public BookingService bookingService;

    public BookCommand(String branchName, String vehicleType, String startTime, String endTime, BookingService bookingService) {
        this.branchName = branchName;
        this.vehicleType = vehicleType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingService = bookingService;
    }

    @Override
    public CommandType commandName() {
        return CommandType.BOOK;
    }

    @Override
    public void execute() {
       System.out.println(bookingService.book(branchName, VehicleType.valueOf(vehicleType), Integer.parseInt(startTime), Integer.parseInt(endTime)));
    }
}
