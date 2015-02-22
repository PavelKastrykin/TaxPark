package com.pavel.automanager.builder;

import com.pavel.automanager.entity.baseclass.Car;

public class CarBuilder extends AbstractCarBuilder<Car, CarBuilder>{

    @Override
    protected Car create(){
        return new Car();
    }

}
