package rental;

import rental.commands.*;
import rental.service.BookingService;
import rental.service.BranchService;

import rental.commands.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VehicleRentalApplication {
    public static void main(String[] args) throws FileNotFoundException {
        BranchService branchService = new BranchService();
        BookingService bookingService = new BookingService(branchService);

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter file path");
        String path = scn.next();

        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] parts = line.trim().split(" ");
            CommandType commandType = CommandType.valueOf(parts[0]);

            switch (commandType) {
                case DISPLAY_VEHICLES : new DisplayCommand(parts[1], parts[2], parts[3], branchService).execute();
                    break;

                case ADD_BRANCH : new AddBranchCommand(parts[1], parts[2], branchService).execute();
                                    break;

                case ADD_VEHICLE : new AddVehicleCommand(parts[1], parts[2], parts[3], parts[4], branchService).execute();
                                    break;

                case BOOK : new BookCommand(parts[1], parts[2], parts[3], parts[4], bookingService).execute();
                                    break;

                default : System.out.println("Command Not found");
            }
        }
    }
}
