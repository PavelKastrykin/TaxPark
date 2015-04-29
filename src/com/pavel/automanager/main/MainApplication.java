package com.pavel.automanager.main;

import com.pavel.automanager.logic.CommandTypes;
import com.pavel.automanager.logic.TaxiParkManager;
import com.pavel.automanager.entity.BuilderRequest;
import org.apache.log4j.Logger;

public class MainApplication {

    final static Logger logger = Logger.getLogger(MainApplication.class);

    public static void main(String[] args){
        TaxiParkManager manager = new TaxiParkManager();
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string1));
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string2));
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string3));
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string4));
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string5));
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string6));
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string7));
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string8));
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string9));
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string10));
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string11));
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string12));
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string13));
        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string14));
        System.out.println(manager);

        manager.execute(CommandTypes.REMOVE_CAR, new BuilderRequest(HardCode.string15));
        System.out.println(manager);

        manager.execute(CommandTypes.GET_CARS_WITH_SPEED_LIMIT, new BuilderRequest(HardCode.string16));
        System.out.println(manager.getFoundCars());

        manager.execute(CommandTypes.SORT_BY_FUEL_CONSUMPTION, new BuilderRequest(HardCode.string17));
        System.out.println(manager);

        manager.execute(CommandTypes.ADD_TAXIPARK_OR_CAR, new BuilderRequest(HardCode.string18));
        System.out.println(manager);
    }
}

