package com.company;

import java.math.BigDecimal;

public class CarBuilder {
    private Integer carType;
    private String carNumber;
    private BigDecimal carMileage;
    private String carAdditionalParam;

    public CarBuilder setCarType(Integer carType) {
        this.carType = carType;
        return this;
    }

    public CarBuilder setCarNumber(String carNumber) {
        this.carNumber = carNumber;
        return this;
    }

    public CarBuilder setCarMileage(BigDecimal carMileage) {
        this.carMileage = carMileage;
        return this;
    }

    public CarBuilder setCarAdditionalParam(String carAdditionalParam) {
        this.carAdditionalParam = carAdditionalParam;
        return this;
    }

    public Car buildCar() {

        if (carAdditionalParam!=null) {
            return new Car(carType, carNumber, carMileage, carAdditionalParam);
        }else {
            return new Car(carType, carNumber, carMileage);
        }
    }
}