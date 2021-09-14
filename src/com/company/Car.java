package com.company;

import java.math.BigDecimal;

public class Car{

    private Integer carType;
    private String carNumber;
    private BigDecimal carMileage;
    private String carAdditionalParam;
    private double carCostFuel;
    private double carRangeFuelBy100km;

    public Car(Integer carType, String carNumber, BigDecimal carMileage, String carAdditionalParam) {
        this.carType = carType;
        this.carNumber = carNumber;
        this.carMileage = carMileage;
        this.carAdditionalParam = carAdditionalParam;
    }
    public Car(Integer carType, String carNumber, BigDecimal carMileage) {
        this.carType = carType;
        this.carNumber = carNumber;
        this.carMileage = carMileage;
    }

    public Integer getCarType() {
        return carType;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public BigDecimal getCarMileage() {
        return carMileage;
    }

    public String getCarAdditionalParam() {
        return carAdditionalParam;
    }

    @Override
    public String toString() {
        if(carAdditionalParam!=null){
        return "Car{" +
                "carType=" + carType +
                ", carNumber='" + carNumber + '\'' +
                ", carMileage=" + carMileage +
                ", carAdditionalParam='" + carAdditionalParam + '\'' +
                '}';
        }else {
            return "Car{" +
                    "carType=" + carType +
                    ", carNumber='" + carNumber + '\'' +
                    ", carMileage=" + carMileage;
        }
    }


}
