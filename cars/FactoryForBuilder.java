package cars;

public class FactoryForBuilder extends AbstractFactory{
    public Mercedes.MercedesBuilder createMercedesBuilder(){
        return new Mercedes.MercedesBuilder();
    }

    public AvtoVaz.AvtoVazBuilder createAvtoVazBuilder(){
        return new AvtoVaz.AvtoVazBuilder();
    }
}
