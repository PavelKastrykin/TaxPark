import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaxPark{
    private List<Car> taxPark = new ArrayList<Car>();

    public void addCar(Car... car){
        for (Car x : car) {
            taxPark.add(x);
        }
    }

    public void removeCar(Car car){
        if (taxPark.contains(car)){
            taxPark.remove(car);
        }
    }
    public List<Car> getCars(){
        return taxPark;
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Car x : this.taxPark){
            sb.append(x.toString());
            sb.append("\n");
        }
        sb.append("Всего машин: ");
        sb.append(getCarCount());
        sb.append("\n");
        sb.append("Общей стоимостью: ");
        sb.append(getTotalCostValue());
        sb.append("\n");
        return sb.toString();
    }

    public void sortByFuelConsumption(){
        Collections.sort(this.taxPark);
    }
}