package cars;

public class Transmission {
    private boolean auto;
    private int count;

    public Transmission(boolean auto, int count){
        this.auto = auto;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public boolean isAuto() {
        return auto;
    }

    @Override
    public String toString() {
        String s = "";
        if(auto)
            s += "Автоматическая ";
        if(!auto)
            s += "Ручная ";
        s += "коробка передач. Количество передач: ";
        s += count;
        return s;
    }
}
