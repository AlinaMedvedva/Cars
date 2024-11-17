package cars;

public class Spoiler {
    private String color;

    public Spoiler(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Цвет спойлера: " + color;
    }
}
