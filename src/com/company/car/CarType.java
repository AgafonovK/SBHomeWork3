package com.company.car;

import java.util.HashMap;
import java.util.Map;

public enum CarType {

    LIGHTCAR(100),
    HEAVYCAR(200),
    PASSANGERSTRANSPORT(300),
    HEAVYTRUCKS(400);

    private final Integer carType;

    CarType(Integer carType) {
        this.carType = carType;
    }

    public Integer getCarType() {
        return carType;
    }

    private static final Map<java.lang.Integer, CarType> carTypeToIntMap = new HashMap<>();

    static {
        for (CarType carType : CarType.values()) {
            carTypeToIntMap.put(carType.getCarType(), carType);
        }
    }

    public static CarType castIntToEnum(int carTypeInt) {
        return carTypeToIntMap.get(carTypeInt);
    }


}
