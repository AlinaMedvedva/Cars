package cars;

public enum Volume {
    FIRST (1.6),
    SECOND(2.4),
    THIRD(3.2);

    double v;
    Volume(double v){
        this.v = v;
    }

    public double getV() {
        return v;
    }
}

