package com.pavel.automanager.logic;

import com.pavel.automanager.entity.Car;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class TaxPark realises logic of car managing in an abstract taxi park.
 * Contains list to store added cars.
 *
 * To manage cars, methods of adding, removing, sorting and finding are provided
 * Initialized with a default constructor
 */
public class TaxPark {

    /**
     * Name os the taxi park
     */
    private String taxParkName;
    /** List of cars that taxi park contains*/
    private List<Car> carContainer = new ArrayList<Car>();
    /**
     * Method to add single car or array of cars
     * @param car
     *        A Car or array of them to be added
     */

    final static Logger logger = Logger.getLogger(TaxPark.class);

    public TaxPark(String name){
        this.taxParkName = name;
    }
    public void addCar(Car... car){
        for (Car x : car) {
            carContainer.add(x);
        }
    }

    public String getTaxParkName() {
        return taxParkName;
    }

    public void setTaxParkName(String taxParkName) {
        this.taxParkName = taxParkName;
    }

    /**
     * Method to remove car
     * @param car
     *        A car to be removed
     */
    public void removeCar(Car car){
        if (carContainer.contains(car)){
            carContainer.remove(car);
        }
        else{
            logger.info("Item not found");
        }
    }

    /**
     * Returns current contention of car in the taxi park
     * @return  an ArrayList of Car
     */
    public List<Car> getCars(){
        return carContainer;
    }

    public int getCarCount(){
        return this.carContainer.size();
    }

    /**
     * Calculates total cost value of a taxi park
     * @return total cost
     */
    public int getTotalCostValue(){
        int amount = 0;
        for (Car x : this.carContainer){
            amount = amount + x.getPriceCost();
        }
        return amount;
    }

    /**
     * Returns List of cars that suit given speed parameter
     * @param speed
     *        speed value
     */
    public List<Car> findCars (int speed){
        List<Car> foundCars = new ArrayList<Car>();
        for (Car x : carContainer){
            if (x.getMaxSpeed() >= speed){
                foundCars.add(x);
            }
        }
        if (foundCars.size() == 0){
            logger.info("Cars are not found");
        }
        return foundCars;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Car x : this.carContainer){
            sb.append(x.toString());
            sb.append("\n");
        }
        sb.append("Total cars: ");
        sb.append(getCarCount());
        sb.append("\n");
        sb.append("Total park cost: ");
        sb.append(getTotalCostValue());
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Method that makes ascending sort of cars in the taxi park according to their fuel consumption
     */
    public void sortByFuelConsumption() throws Exception{
        if (carContainer.size() == 0){
            throw new Exception("TaxPark is empty");
        }
        Collections.sort(this.carContainer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaxPark)) return false;

        TaxPark taxParkLogic = (TaxPark) o;

        if (!carContainer.equals(taxParkLogic.carContainer)) return false;
        if (!taxParkName.equals(taxParkLogic.taxParkName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taxParkName.hashCode();
        result = 31 * result + carContainer.hashCode();
        return result;
    }
}