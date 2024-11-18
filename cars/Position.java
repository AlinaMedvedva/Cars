package cars;

public enum Position {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4);

    int i;
    Position(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
