package cars;

import java.util.*;

public class Mercedes {
    private Body body;
    private Engine engine;
    private SteeringGear  steeringGear;

    private Spoiler spoiler;
    private Transmission transmission;
    private HashMap<Position, Wheel> wheels;

    private Mercedes(MercedesBuilder builder){
        body = builder.body;
        engine = builder.engine;
        steeringGear = builder.steeringGear;
        transmission = builder.transmission;
        spoiler = builder.spoiler;
        wheels = new HashMap<>();
        for(Map.Entry<Position, Wheel> entry : builder.wheels.entrySet()){
            wheels.put(entry.getKey(), entry.getValue());
        }
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
            if(body != null)
                if(body.getColor().equals( spoiler.getColor()))
                    this.spoiler = spoiler;
            return this;
        }

        public MercedesBuilder setEngine(Engine engine) {
            if(engine.getV() == Volume.SECOND || engine.getV() == Volume.THIRD)
                this.engine = engine;
            return this;
        }

        public MercedesBuilder setSteeringGear(SteeringGear steeringGear) {
            this.steeringGear = steeringGear;
            return this;
        }

        public MercedesBuilder setTransmission(Transmission transmission) {
            if(transmission.isAuto() || transmission.getCount() >= 5)
                this.transmission = transmission;
            return this;
        }

        public MercedesBuilder addWheel(Wheel wheel){
            Set<Position> key = wheels.keySet();
            if(key.isEmpty()) {
                wheels.put(Position.FIRST, wheel);
                return this;
            }
            if(key.size() == 4)
                return this;
            boolean[] flag = {false, false, false, false};
            boolean diameter = true;
            for(Map.Entry<Position, Wheel> entry : wheels.entrySet()){
                Position p = entry.getKey();
                Wheel ent = entry.getValue();
                if(ent.getD().equals(wheel.getD()))
                {
                    diameter = false;
                    break;
                }
                flag[p.getI()] = true;
            }
            if(diameter){
                Position p = null;
                int id = 0;
                for (int i = 0; i < 4; i++) {
                    if(!flag[i])
                    {
                        id = i;
                        break;
                    }
                }
                switch(id){
                    case 0: p = Position.FIRST;break;
                    case 1: p = Position.SECOND;break;
                    case 2: p = Position.THIRD;break;
                    case 3: p = Position.FOURTH;break;
                }
                wheels.put(p, wheel);
            }
            return this;
        }

        public Mercedes build(){
            return new Mercedes(this);
        }
    }
}
