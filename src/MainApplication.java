import com.pavel.automanager.logic.Commands;
import com.pavel.automanager.logic.Manager;
import com.pavel.automanager.logic.Request;
import org.apache.log4j.Logger;

public class MainApplication {

    final static Logger logger = Logger.getLogger(MainApplication.class);

    public static void main(String[] args){
        Manager manager = new Manager();
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string1));
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string2));
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string3));
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string4));
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string5));
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string6));
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string7));
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string8));
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string9));
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string10));
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string11));
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string12));
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string13));
        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string14));
        System.out.println(manager);

        manager.execute(Commands.REMOVE_CAR, new Request(HardCode.string15));
        System.out.println(manager);

        manager.execute(Commands.GET_CARS_WITH_SPEED_LIMIT, new Request(HardCode.string16));
        System.out.println(manager.getFoundCars());

        manager.execute(Commands.SORT_BY_FUEL_CONSUMPTION, new Request(HardCode.string17));
        System.out.println(manager);

        manager.execute(Commands.ADD_TAXIPARK_OR_CAR, new Request(HardCode.string18));
        System.out.println(manager);
    }
}

