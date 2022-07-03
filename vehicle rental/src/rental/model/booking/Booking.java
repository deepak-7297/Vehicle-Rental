package rental.model.booking;

import rental.model.Branch.Branch;
import rental.model.vehicle.Vehicle;

import java.util.UUID;

public class Booking {
    public UUID id;
    public Integer startTime;
    public Integer endTime;
    public Vehicle vehicle;
    public int cost;
    public Branch branch;

    public Booking() {
        this.id = UUID.randomUUID();
    }


    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}

