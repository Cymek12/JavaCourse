package kalkulatorWzorzecStrategii;

public class Dzielenie implements Dzialanie{
    @Override
    public double licz(double arg1, double arg2) {
        if(arg2 == 0){
            throw new RuntimeException();
        }
        return arg1 / arg2;
    }
}
