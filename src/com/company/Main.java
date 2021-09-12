package com.company;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    private static Map<CarType, List<Car>> foo = new HashMap<>();

    public static void main(String[] args) {

        String[] data = new String[]{"C100_1-100", "C200_123-120-1200", "C300_196-120-30", "C400_143-80-20",
                "C100_2-50", "C200_21-40-1000", "C300_296-200-45", "C400_222-10-20",
                "C100_3-10", "C200_123-170-1100", "C300_343-150-29", "C400_333-100-28",
                "C100_1-300", "C200_14-100-750", "C300_196-32-15"};

        List<Car> carList = init(data);
        //fill hashmap
        carList.forEach(car -> {
            CarType carType = CarType.castIntToEnum(car.getCarType());
            foo.computeIfAbsent(carType, q -> new ArrayList<>()).add(car);
        });
        foo.forEach((carType, cars) -> System.out.println(cars.toString()));

        //sort foo
        /*foo.forEach((w, carList1) -> {
            carList1.sort((c, v) -> c.getCarMileage().subtract(v.getCarMileage()).intValue());
        });
        System.out.println(foo);
        */

        Map<CarType, BigDecimal> expensiveByCarType = new HashMap<>();

        foo.forEach((q, w) -> {
            w.forEach(car -> {
                expensiveByCarType.compute(q, (h, p) -> {
                    String carType = CarType.castIntToEnum(h.getCarType()).toString();
                    BigDecimal expensiveByMileage = (car.getCarMileage()
                            .multiply(CarRangeFuelBy100km.getCarRangeFuelOn100kmByCarType(carType)
                                    .multiply(CarTypeCostFuel.getCarTypeCostFuelByCareType(carType))))
                            .divide(new BigDecimal("100"));
                    if (p == null) {
                        return new BigDecimal(expensiveByMileage.toString());
                    } else {
                        return p.add(expensiveByMileage);
                    }
                });
            });
        });


        System.out.println("Expensive by each type: \n " + expensiveByCarType);

        BigDecimal allExpensive;
        allExpensive = expensiveByCarType.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Expensive by all: " + allExpensive);

        CarType carTypeMaxExpensive = expensiveByCarType.entrySet().stream().max((ent, ent1) -> ent.getValue().subtract(ent1.getValue()).intValue()).get().getKey();
        System.out.println("Maximal expensive in type: " + carTypeMaxExpensive.getCarType());
        CarType carTypeMinExpensive = expensiveByCarType.entrySet().stream().min((ent, ent1) -> ent.getValue().subtract(ent1.getValue()).intValue()).get().getKey();
        System.out.println("Minimal expensive in type: " + carTypeMinExpensive.getCarType());

        System.out.println(getTypeInfo(CarType.LIGHTCAR));
        System.out.println(getTypeInfoSortByMileage(CarType.LIGHTCAR, true));
        System.out.println(getTypeInfoSortByMileage(CarType.LIGHTCAR, false));
        System.out.println(getTypeInfoSortByAdditionalParameter(CarType.LIGHTCAR, true));
        System.out.println(getTypeInfoSortByAdditionalParameter(CarType.LIGHTCAR, false));
    }

    static List<Car> init(String[] data) {
        List<Car> carList = new ArrayList<>();
        for (String datum : data) {
            String[] carParameter = datum.split("[_\\-]");
            int integer = Integer.parseInt(carParameter[0].substring(1));
            String carNumber = carParameter[1];
            BigDecimal carMileage = new BigDecimal(carParameter[2]);
            String carAdditionalParameter = "";
            if (carParameter.length > 3) {
                carAdditionalParameter = carParameter[3];
            }
            carList.add(new CarBuilder()
                    .setCarType(CarType.castIntToEnum(integer).getCarType())
                    .setCarNumber(carNumber)
                    .setCarMileage(carMileage)
                    .setCarAdditionalParam(carAdditionalParameter)
                    .buildCar());
        }
        return carList;
    }

    static List<Car> getTypeInfo(CarType carType){
        List<Car> carList = new ArrayList<>();
        carList = new ArrayList<>(foo.get(carType));
        return carList;
    }
    static List<Car> getTypeInfoSortByMileage(CarType carType, boolean reversed){
        List<Car> carList = new ArrayList<>(foo.get(carType));
        if (reversed) {
            carList.sort(Comparator.comparing(Car::getCarMileage));
        } else {
            carList.sort(Comparator.comparing(Car::getCarMileage).reversed());
        }
        return carList;
    }
//TODO check param on NUll
    static List<Car> getTypeInfoSortByAdditionalParameter(CarType carType, boolean reversed){
        List<Car> carList = new ArrayList<>(foo.get(carType));
        if (reversed) {
            carList.sort(Comparator.comparing(Car::getCarAdditionalParam));
        } else {
            carList.sort(Comparator.comparing(Car::getCarAdditionalParam).reversed());
        }
        return carList;
    }

}
