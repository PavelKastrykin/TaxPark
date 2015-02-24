package com.pavel.automanager.entity;

import java.util.ArrayList;
import java.util.List;

public class TaxiPark {

    private String taxiParkName;
    private List<Car> carContainer = new ArrayList<Car>();

    public TaxiPark(String taxiParkName){
        this.taxiParkName = taxiParkName;
    }

    public String getTaxiParkName() {
        return taxiParkName;
    }

    public void setTaxiParkName(String taxiParkName) {
        this.taxiParkName = taxiParkName;
    }

    public List<Car> getCarContainer() {
        return carContainer;
    }

    public void setCarContainer(List<Car> carContainer) {
        this.carContainer = carContainer;
    }

    private int getTotalCostValue(){
        int totalCost = 0;
        for (Car x : carContainer){
            totalCost = totalCost + x.getPriceCost();
        }
        return  totalCost;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Car x : this.carContainer){
            sb.append(x.toString());
            sb.append("\n");
        }
        sb.append("Total cars: ");
        sb.append(carContainer.size());
        sb.append("\n");
        sb.append("Total park cost: ");
        sb.append(getTotalCostValue());
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaxiPark)) return false;

        TaxiPark taxiPark = (TaxiPark) o;

        if (!carContainer.equals(taxiPark.carContainer)) return false;
        if (!taxiParkName.equals(taxiPark.taxiParkName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taxiParkName.hashCode();
        result = 31 * result + carContainer.hashCode();
        return result;
    }
}
