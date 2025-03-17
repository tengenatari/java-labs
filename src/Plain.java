public class Plain extends TransportVehicle implements Flyable, Drivable{
    protected int ride_speed;
    protected int fly_speed;
    protected String current_method = "ride";

    @Override
    public int ride(int hours) {
        return hours * this.ride_speed;
    }
    @Override
    public int fly(int hours){
        return hours * this.fly_speed;
    }
    @Override
    public void move(int hours) {
        switch (this.current_method){
            case "ride": this.ride(hours); break;
            case "fly": this.fly(hours); break;
            default: break;
        }
    }
    public void change_method(){
        if (this.current_method.equals("fly")) {
            this.current_method = "ride";
        } else {
            this.current_method = "fly";
        }
    }
}
