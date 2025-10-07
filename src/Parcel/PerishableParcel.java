package parcel;

public class PerishableParcel extends  Parcel { //Скоропортящиеся
    private int timeToLive;
    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, ParcelType type, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay,type);
        this.timeToLive = timeToLive;
    }

    public  void setTimeToLive(int timeToLive){
        this.timeToLive = timeToLive;
    }

    public int getTimeToLive(){
        return timeToLive;
    }
    public boolean isExpired(int sendDay,int timeToLive,int currentDay){
        if(sendDay + timeToLive >= currentDay){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return  "Description{" +
                "description = " + description + '\'' +
                ", weight =" + weight +
                ", deliveryAddress = " + deliveryAddress +
                ", sendDay = " + sendDay +
                ", ParcelType type = " + type +
                ", TimeToLive = " + timeToLive  +
                "}";
    }
}
