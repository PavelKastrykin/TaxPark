
public class PassengerCar extends Car{
    private final int passengerSeatsQuantity;

    private PassengerCar (PassengerCarBuilder builder){
        super(builder);
        this.passengerSeatsQuantity = builder.passengerSeatsQuantity;
    }

    public static class PassengerCarBuilder extends CarBuilder{

        private int passengerSeatsQuantity = 0;
        
        public PassengerCarBuilder(String brand) {
            super(brand);
        }

        public PassengerCarBuilder passengerSeatsQuantity(int value){
            passengerSeatsQuantity = value;
            return this;
        }

        public PassengerCar build(){
            return new PassengerCar(this);
        }

    }

    public int getPassengerSeatsQty(){
        return this.passengerSeatsQuantity;
    }

    @Override
    public String toString(){
        return super.toString() + ", количество мест: " + passengerSeatsQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PassengerCar that = (PassengerCar) o;

        if (passengerSeatsQuantity != that.passengerSeatsQuantity) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + passengerSeatsQuantity;
        return result;
    }
}
