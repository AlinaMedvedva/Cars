package cars;

public class Body {
    private String color;

    public Body(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Цвет корпуса: " + color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
