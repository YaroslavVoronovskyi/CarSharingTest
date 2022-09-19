package carsharing.model;

import carsharing.Constants;

public class Customer {

    private int id;

    private String name;

    private int rentedCarId;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, int rentedCarId) {
        this.name = name;
        this.rentedCarId = rentedCarId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRentedCarId() {
        return rentedCarId;
    }

    public void setRentedCarId(int rentedCarId) {
        this.rentedCarId = rentedCarId;
    }

    @Override
    public String toString() {
        return id + Constants.DOT_SEPARATOR + name + rentedCarId;
    }
}
