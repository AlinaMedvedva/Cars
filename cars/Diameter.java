package cars;

public enum Diameter {

    FIRST(17),
    SECOND(19),
    THIRD(22);

    private int d;
    Diameter(int d){
        this.d = d;
    }

    public int getD() {
        return d;
    }
}
