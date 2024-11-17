package cars;

public class SteeringGear {
    private boolean hydro_booster;

    public SteeringGear(boolean hydro_booster){
        this.hydro_booster = hydro_booster;
    }

    public boolean isHydro_booster() {
        return hydro_booster;
    }

    @Override
    public String toString() {
        if(hydro_booster)
            return "Гидроусилитель имеется";
        return "Гидроусилитель не имеется";
    }
}
