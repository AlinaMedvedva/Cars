package cars;

public abstract class AbstractFactory {
    public Cars.MercedesBuilder createMercedesBuilder() {
        return null;
    }

    public Cars.AvtoVazBuilder createAvtoVazBuilder() {
        return null;
    }
    public Body createBody(String color){
        return null;
    }
    public Spoiler createSpoiler(String color){
        return null;
    }
    public Engine createEngine(Volume v){
        return null;
    }
    public SteeringGear createSteeringGear(boolean hydro_booster){
        return null;
    }
    public Transmission createTransmission(boolean auto, int count) throws MyException{
        return null;
    }
    public Wheel createWheel(Diameter d){
        return null;
    }
}

