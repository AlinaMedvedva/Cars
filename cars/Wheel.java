package cars;

public class Wheel {
    private Diameter d;


    public Wheel(Diameter d) {
        this.d = d;
    }

    public Diameter getD() {
        return d;
    }

    @Override
    public String toString() {
        return "Колесо диаметром " + d.getD();
    }
}
