package cars;

import arithmetic.MyException;

import java.util.*;

public class Mercedes {
    private Body body;
    private Engine engine;
    private SteeringGear  steeringGear;

    private Spoiler spoiler;
    private Transmission transmission;
    private HashMap<Position, Wheel> wheels;
    FactoryForDetail detail = new FactoryForDetail();

    private Mercedes(MercedesBuilder builder) throws cars.MyException {
        body = detail.createBody(builder.body.getColor());
        engine = detail.createEngine(builder.engine.getV());
        steeringGear = detail.createSteeringGear(builder.steeringGear.isHydro_booster());
        transmission = detail.createTransmission(builder.transmission.isAuto(), builder.transmission.getCount());
        spoiler = detail.createSpoiler(builder.spoiler.getColor());
        wheels = new HashMap<>();
        for(Map.Entry<Position, Wheel> entry : builder.wheels.entrySet()){
            wheels.put(entry.getKey(), detail.createWheel(entry.getValue().getD()));
        }
    }

    public void changeColor(String color){
        if(body != null)
            body.setColor(color);
        if(spoiler!=null)
            spoiler.setColor(color);
    }

    @Override
    public String toString() {
        String s = "";
        s += "Mercedes\n";
        int count = 0;
        if(body!=null) count++;
        if(engine!=null) count++;
        if(transmission!=null) count++;
        if(steeringGear!=null) count++;
        if(spoiler!=null) count++;

        Set<Position> key = wheels.keySet();
        if(!key.isEmpty())
        {
            count += key.size();
        }
        s += "Количество деталей = " + count + "\n";
        if(body!=null)
            s += "Цвет машины: " + body.getColor();
        if(spoiler!= null)
            s += " со спойлером";
        s += "\n";
        if(engine != null)
            s += "Двигатель объёмом: " + engine.getV().getV() + "\n";
        if(transmission != null){
            if(transmission.isAuto())
                s += "Автоматическая ";

            if(!transmission.isAuto())
                s += "Ручная ";
            s+= "коробка передач, с количеством: " + transmission.getCount() + "\n";
        }
        if(steeringGear != null){
            s+= "Гидроусилитель ";
            if(!steeringGear.isHydro_booster())
                s+="не ";
            s += "имеется\n";
        }

        if(!key.isEmpty()) {
            s += "Количество колёс: " + key.size();
        }
        return s;
    }

    public static class MercedesBuilder {
        private Body body;
        private Engine engine;
        private SteeringGear  steeringGear;
        private Transmission transmission;
        private Spoiler spoiler;
        private HashMap<Position, Wheel> wheels;
        public MercedesBuilder() {
            body = null;
            engine = null;
            steeringGear = null;
            transmission = null;
            wheels = new HashMap<>();
        }

        public MercedesBuilder setBody(Body body) {
            this.body = body;
            return this;
        }
        public MercedesBuilder setSpoiler(Spoiler spoiler){
            this.spoiler = spoiler;
            return this;
        }

        public MercedesBuilder setEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public MercedesBuilder setSteeringGear(SteeringGear steeringGear) {
            this.steeringGear = steeringGear;
            return this;
        }

        public MercedesBuilder setTransmission(Transmission transmission) {
            this.transmission = transmission;
            return this;
        }

        public MercedesBuilder addWheel(Wheel wheel, Position position){
            wheels.put(position, wheel);
            return this;
        }

        public Mercedes build() throws MyException, cars.MyException {
            if(body==null)
                throw new MyException("Отсутствует корпус");
            if(engine == null)
                throw new MyException("Отсутствует двигатель");
            if(engine.getV() != Volume.SECOND && engine.getV() != Volume.THIRD)
                throw new MyException("Двигатель не подходит");
            if(transmission==null)
                throw new MyException("Отсутствует коробка передач");
            if(!transmission.isAuto() || transmission.getCount() < 5)
                throw new MyException("Коробка передач не подходит для данной марки");
            if(wheels.size() < 4)
                throw new MyException("Меньше четырёх колёс");
            if(spoiler != null){
                if(!spoiler.getColor().equals(body.getColor()))
                    throw new MyException("Цвет спойлера не совпадает с цветом корпуса");
            }
            int sum = 0;
            for(Map.Entry<Position, Wheel> entry : wheels.entrySet()){
                sum += entry.getValue().getD().getD();
            }
            if(sum%4 != 0)
                throw new MyException("Колёса разного диаметра");
            return new Mercedes(this);
        }
    }
}
