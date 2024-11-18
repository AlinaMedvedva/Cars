package cars;

public class FactoryForBuilder extends AbstractFactory{
    public Cars.MercedesBuilder createMercedesBuilder(){
        return new Cars.MercedesBuilder();
    }

    public Cars.AvtoVazBuilder createAvtoVazBuilder(){
        return new Cars.AvtoVazBuilder();
    }
}
