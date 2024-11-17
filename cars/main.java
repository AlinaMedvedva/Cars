package cars;

public class main {

    public static void main(String [] args){
        FactoryForDetail detail = new FactoryForDetail();
        FactoryForBuilder builders = new FactoryForBuilder();

        Body body = detail.createBody("blue");
        Spoiler spoiler = detail.createSpoiler("green");
        Engine engine = detail.createEngine(Volume.SECOND);
        SteeringGear steeringGear =  detail.createSteeringGear(true);
        try {
            Transmission transmission = detail.createTransmission(true, 5);
            Wheel wheel = detail.createWheel(Diameter.FIRST);

            Mercedes.MercedesBuilder mercedesBuilder = builders.createMercedesBuilder();
            Mercedes m = mercedesBuilder.setBody(body).setEngine(engine).setSpoiler(spoiler).setSteeringGear(steeringGear).
                    setTransmission(transmission).addWheel(wheel).build();
            System.out.println(m);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }
}
