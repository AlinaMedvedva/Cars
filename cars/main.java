package cars;

import javax.management.DescriptorAccess;

public class FactoryForDetail extends AbstractFactory{
    public Body createBody(String color){
        return new Body(color);
    }

    public Spoiler createSpoiler(String color){
        return new Spoiler(color);
    }

    public Engine createEngine(Volume v){
        return new Engine(v);
    }

    public SteeringGear createSteeringGear(boolean hydro_booster){
        return new SteeringGear(hydro_booster);
    }

    public Transmission createTransmission(boolean auto, int count) throws MyException {
        if(!auto && count < 4)
            throw new MyException("Несуществующая коробка передач");
        return new Transmission(auto, count);
    }

    public Wheel createWheel(Diameter d){
        return new Wheel(d);
    }
}
