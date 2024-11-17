package cars;

public class main {

    public static void main(String [] args){
        FactoryForDetail detail = new FactoryForDetail();
        FactoryForBuilder builders = new FactoryForBuilder();

        Body body = detail.createBody("blue");
        Spoiler spoiler = detail.createSpoiler("blue");
        Engine engine = detail.createEngine(Volume.SECOND);
        SteeringGear steeringGear =  detail.createSteeringGear(true);
        try {
            Transmission transmission = detail.createTransmission(true, 5);
            Wheel wheel = detail.createWheel(Diameter.FIRST);

            Mercedes.MercedesBuilder mercedesBuilder = builders.createMercedesBuilder();
            mercedesBuilder = mercedesBuilder.setBody(body).setSpoiler(spoiler).setEngine(engine).setTransmission(transmission).setSteeringGear(steeringGear);
            mercedesBuilder = mercedesBuilder.addWheel(wheel, Position.FIRST).addWheel(wheel, Position.SECOND).addWheel(wheel, Position.THIRD).addWheel(wheel, Position.FOURTH);
            Mercedes m1 = mercedesBuilder.build();
            Mercedes m2 = mercedesBuilder.build();
            m2.changeColor("red");
            System.out.println(m1);
            System.out.println();
            System.out.println(m2);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (arithmetic.MyException e) {
            System.out.println(e.getMessage());
        }

    }
}
