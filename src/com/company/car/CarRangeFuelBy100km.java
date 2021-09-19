package com.company.car;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public enum CarRangeFuelBy100km {
    LIGHTCAR(new BigDecimal("12.5")),
    HEAVYCAR(new BigDecimal("12")),
    PASSANGERSTRANSPORT(new BigDecimal("11.5")),
    HEAVYTRUCKS(new BigDecimal("20"));

    //private final double carRangeFuelBy100km;
    private final BigDecimal carRangeFuelBy100km;
    private static final Map<String, BigDecimal> carRangeFuelBy100kmToBigDecimalMap = new HashMap<>();

    CarRangeFuelBy100km(BigDecimal carRangeFuelBy100km){//double carRangeFuelBy100km) {
        this.carRangeFuelBy100km = carRangeFuelBy100km;
    }
    public BigDecimal getCarRangeFuelBy100km() {
        return carRangeFuelBy100km;
    }

    static {
        for (CarType carType : CarType.values()) {
            carRangeFuelBy100kmToBigDecimalMap.put(carType.name(), CarRangeFuelBy100km.valueOf(carType.name()).getCarRangeFuelBy100km());
        }
    }

    public static BigDecimal getCarRangeFuelOn100kmByCarType(String carType) {
        return carRangeFuelBy100kmToBigDecimalMap.get(carType);
    }

}
