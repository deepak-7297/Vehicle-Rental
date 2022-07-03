package rental.service;

import rental.service.strategy.LowestPriceFirstStrategy;
import rental.model.booking.Booking;
import rental.model.vehicle.Vehicle;
import rental.model.vehicle.VehicleType;

import java.util.List;
import java.util.Objects;

public class BookingService {
    public BranchService branchService;
    public Integer dynamicPricingLimit;
    public Integer dynamicPricingIncrease;

    public BookingService(BranchService branchService) {
        this.branchService = branchService;
        this.dynamicPricingLimit = 80;
        this.dynamicPricingIncrease = 10;
    }

    public Integer book(String branchName, VehicleType vehicleType, Integer startTime, Integer endTime){
        List<Vehicle> vehicleList = branchService.getAvailableVehicles(branchName, vehicleType, startTime, endTime);

        if(Objects.isNull(vehicleList) || vehicleList.size() < 1)
            return -1;

        Vehicle vehicle = getBookingVehicle(vehicleList);

        int branchVehicleCount = branchService.getBranch(branchName).getVehicleList().size();
        int idealCost = (endTime-startTime) * vehicle.getPrice();
        int bookedVehicle = branchVehicleCount - vehicleList.size();
        int cost = (dynamicPricingLimit * branchVehicleCount)/100 <= bookedVehicle ? idealCost*dynamicPricingIncrease/100 + idealCost : idealCost;
        Booking booking = new Booking();
        booking.setBranch(branchService.getBranch(branchName));
        booking.setCost(cost);
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);
        booking.setVehicle(vehicle);
        branchService.getBranch(branchName).addBookingDetail(booking);
        return cost;
    }

    private Vehicle getBookingVehicle(List<Vehicle> vehicleList){
        LowestPriceFirstStrategy lowestPriceFirstStrategy = new LowestPriceFirstStrategy(vehicleList);
        return lowestPriceFirstStrategy.getVehicle();
    }

}
