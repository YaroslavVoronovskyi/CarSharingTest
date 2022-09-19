package carsharing.model;

import carsharing.Constants;

public class Car {
    int id;
    String name;
    int companyId;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int companyId) {
        this.name = name;
        this.companyId = companyId;
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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return id + Constants.DOT_SEPARATOR + name + companyId;
    }
}
