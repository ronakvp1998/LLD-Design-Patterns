package ParkingLotProblem.vehicle;

public class VehicleFactory {

    public static Vehicle createVehicle(String licensePlate,String type){
        if(type != null){
            switch (type.toLowerCase()){
                case "motorcycle":
                case "bike":
                    return new MotorCycle(licensePlate);
                case "truck":
                    return new Truck(licensePlate);
                case "car":
                default:
                    return new Car(licensePlate);
            }
        }
        return new Car(licensePlate);
    }

}
