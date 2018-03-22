package com.ssm.promotion.core.entity;

import java.io.Serializable;

public class Cars implements Serializable {

    private int carId;//主键
    private String carName;//汽车名称

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Cars() {
    }

    public Cars(int carId, String carName) {
        this.carId = carId;
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                '}';
    }
}
