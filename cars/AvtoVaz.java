package cars;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AvtoVaz {
    private Body body;
    private Engine engine;
    private SteeringGear  steeringGear;
    private Spoiler spoiler;
    private Transmission transmission;
    private HashMap<Position, Wheel> wheels;
    FactoryForDetail detail = new FactoryForDetail();
    private AvtoVaz(AvtoVazBuilder builder) throws MyException {
        body = detail.createBody(builder.body.getColor());
        engine = detail.createEngine(builder.engine.getV());
        steeringGear = detail.createSteeringGear(builder.steeringGear.isHydro_booster());
        transmission = detail.createTransmission(builder.transmission.isAuto(), builder.transmission.getCount());
        if(builder.spoiler != null)
            spoiler = detail.createSpoiler(builder.spoiler.getColor());
        wheels = new HashMap<>();
        for(Map.Entry<Position, Wheel> entry : builder.wheels.entrySet()){
            wheels.put(entry.getKey(), detail.createWheel(entry.getValue().getD()));
        }
    }

    public void changeColor(String color){
        body.setColor(color);
        if(spoiler!=null)
            spoiler.setColor(color);
    }

    @Override
    public String toString() {
        String s = "АвтоВАЗ\n";
        int count = 0;
        if(body!=null) count++;
        if(engine!=null) count++;
        if(transmission!=null) count++;
        if(steeringGear!=null) count++;
        if(spoiler!=null) count++;
        if(wheels != null)
        {
            Set<Position> key = wheels.keySet();
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

        if(wheels != null) {
            Set<Position> key = wheels.keySet();
            s += "Количество колёс: " + key.size();
        }
        return s;
    }

    public static class AvtoVazBuilder{
        private Body body;
        private Engine engine;
        private SteeringGear  steeringGear;
        private Transmission transmission;
        private Spoiler spoiler;
        private HashMap<Position, Wheel> wheels;

        public AvtoVazBuilder() {
            body = null;
            engine = null;
            steeringGear = null;
            transmission = null;
            wheels = new HashMap<>();
        }

        public AvtoVazBuilder setBody(Body body) {
            this.body = body;
            return this;
        }
        public AvtoVazBuilder setSpoiler(Spoiler spoiler){
            this.spoiler = spoiler;
            return this;
        }

        public AvtoVazBuilder setEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public AvtoVazBuilder setSteeringGear(SteeringGear steeringGear) {
            this.steeringGear = steeringGear;
            return this;
        }

        public AvtoVazBuilder setTransmission(Transmission transmission) {
            this.transmission = transmission;
            return this;
        }

        public AvtoVazBuilder addWheel(Wheel wheel, Position position){
            wheels.put(position, wheel);
            return this;
        }

        public AvtoVaz build() throws MyException{
            if(body==null)
                throw new MyException("Отсутствует корпус");
            if(engine == null)
                throw new MyException("Отсутствует двигатель");
            if(engine.getV() != Volume.FIRST && engine.getV() != Volume.SECOND)
                throw new MyException("Двигатель не подходит");
            if(transmission==null)
                throw new MyException("Отсутствует коробка передач");
            if(transmission.isAuto())
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
            return new AvtoVaz(this);
        }
    }
}
