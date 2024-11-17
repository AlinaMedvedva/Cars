package cars;

public class Engine {
    private Volume v;

    public Engine(Volume v){
        this.v = v;
    }

    public Volume getV() {
        return v;
    }

    @Override
    public String toString() {
        return "Двигатель объёмом " + v.getV() + " л";
    }
}
