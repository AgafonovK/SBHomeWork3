package com.company.car;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public enum CarTypeCostFuel {

    LIGHTCAR(new BigDecimal("46.10")),
    HEAVYCAR(new BigDecimal("48.90")),
    PASSANGERSTRANSPORT(new BigDecimal("47.50")),
    HEAVYTRUCKS(new BigDecimal("48.90"));

    private final BigDecimal carTypeCostFuel ;
    private static final Map<String, BigDecimal> carTypeCostFuelToDoubleMap = new HashMap<>();

    CarTypeCostFuel(BigDecimal carTypeCostFuel) {
        this.carTypeCostFuel = carTypeCostFuel;
    }
    public BigDecimal getCarTypeCostFuel() {
        return carTypeCostFuel;
    }

    static {
        for (CarType carType : CarType.values()) {
            carTypeCostFuelToDoubleMap.put(carType.name(), CarTypeCostFuel.valueOf(carType.name()).getCarTypeCostFuel());
        }
    }

    /*public static CarTypeCostFuel castDoubleByCarType(double carTypeCostFuelDouble) {
        return carTypeCostFuelToDoubleMap.get(carTypeCostFuelDouble);
    }*/

    public static BigDecimal getCarTypeCostFuelByCareType(String carTypeEnum){
        return carTypeCostFuelToDoubleMap.get(carTypeEnum);
    }
}
