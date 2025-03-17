public abstract class TransportVehicle {
    protected String manufacturer;
    protected String color;
    protected Integer lifting;
    protected Integer current_weight = 0;


    public abstract void move();

    public boolean can_load_or_unload_transport(int weight){
        int potential_weight = weight+this.current_weight;
        return 0 <= potential_weight && potential_weight<= lifting;
    }
    public void load_or_unload_transport(int weight){
        if(this.can_load_or_unload_transport(weight)) this.current_weight += weight;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getLifting() {
        return lifting;
    }

    public void setLifting(Integer lifting) {
        this.lifting = lifting;
    }

    public Integer getCurrent_weight() {
        return current_weight;
    }

    public void setCurrent_weight(Integer current_weight) {
        this.current_weight = current_weight;
    }
}
