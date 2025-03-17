public class Car implements Drivable{
    protected int ride_speed;
    @Override
    public int ride(int hours) {
        return hours*ride_speed;
    }



}
