
public class Truck extends Car{
    public final int loadCapacity;

    private Truck (TruckBuilder builder){
        super(builder);
        this.loadCapacity = builder.loadCapacity;
    }

    public static class TruckBuilder extends CarBuilder{
        private int loadCapacity;

        public TruckBuilder(String brand){
            super(brand);
        }

        public TruckBuilder loadCapacity(int value){
            loadCapacity = value;
            return this;
        }

        public Truck build(){
            return new Truck(this);
        }
    }

    public int getCapacity(){
        return this.loadCapacity;
    }

    @Override
    public String toString(){
        return super.toString() + ", грузоподъемность: " + loadCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Truck truck = (Truck) o;

        if (loadCapacity != truck.loadCapacity) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + loadCapacity;
        return result;
    }
}
