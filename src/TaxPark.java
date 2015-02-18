﻿import java.util.ArrayList;
import java.util.Collections;

//ПРивет


public class TaxPark {
    private ArrayList<Car> taxPark = new ArrayList<Car>(0);

    public void addCar(Car car){
        taxPark.add(car);
    }

    public void removeCar(Car car){
        if (taxPark.contains(car)){
            taxPark.remove(car);
        }
    }

    public int getCarCount(){
        return this.taxPark.size();
    }

    public int getTotalCostValue(){
        int amount = 0;
        for (Car x : this.taxPark){
            amount = amount + x.getPriceCost();
        }
        return amount;
    }

    public void findCars (int speed){
        if (speed <= 0){
            System.out.println("Ничего не найдено");
            System.out.println();
            return;
        }
        ArrayList<Car> foundCars = new ArrayList<Car>();
        for (Car x : this.taxPark){
            if (x.getMaxSpeed() >= speed){
                foundCars.add(x);
            }
        }
        for (Car x : foundCars){
            System.out.println(x);
        }
    }

    public void printTaxPark(){
        for (Car x : this.taxPark){
            System.out.println(x);
        }
        System.out.println("Всего машин: " + getCarCount());
        System.out.println("Общей стоимостью: " + getTotalCostValue());
    }

    public void sortByFuelConsumption(){
        Collections.sort(this.taxPark);
    }

    public static void main(String[] args){
        TaxPark taxPark1 = new TaxPark();
        taxPark1.addCar(new Car("Toyota", 150, 6.3, 12000, CarClass.C));
        taxPark1.addCar(new Car("Mercedes", 200, 11.4, 17000, CarClass.E));
        taxPark1.addCar(new Car("Honda", 180, 7.5, 11000, CarClass.D));
        taxPark1.addCar(new Car("Toyota", 150, 6.3, 12000, CarClass.C));
        taxPark1.printTaxPark();
        System.out.println();

        System.out.println(taxPark1.taxPark.get(0));
        System.out.println(taxPark1.taxPark.get(3));
        System.out.println(taxPark1.taxPark.get(0).equals(taxPark1.taxPark.get(3)));
        System.out.println();

        taxPark1.findCars(160);
        System.out.println();

        taxPark1.sortByFuelConsumption();
        taxPark1.printTaxPark();
        System.out.println();

        taxPark1.removeCar(new Car("Toyota", 150, 6.3, 12000, CarClass.C));
        taxPark1.printTaxPark();
        System.out.println();

        System.out.println(taxPark1.taxPark.get(0));
        System.out.println(taxPark1.taxPark.get(1));
        System.out.println(taxPark1.taxPark.get(0).equals(taxPark1.taxPark.get(1)));
    }

}
