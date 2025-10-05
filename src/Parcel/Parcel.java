package Parcel;

public abstract class Parcel {
    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;
    private ParcelType type;

    Parcel(String description,int weight,String deliveryAddress,int sendDay,ParcelType type){
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight(){
        return  weight;
    }

    public String getDeliveryAddress(){
        return deliveryAddress;
    }

    public int getSendDay(){
        return sendDay;
    }

    public ParcelType getType(){
        return  type;
    }

    public void packageItem(){
        System.out.println("Посылка <<" + description + ">> упакована");
    }

    public void deliver(){
        System.out.println("Посылка <<" + description +">> доставлена по адресу " + deliveryAddress);
    }
    public  int calculateDeliveryCost(){
        return (weight * type.getBaseCost());
    }

    public String toString() {
        return  "Description{" +
                "description = " + description + '\'' +
                ", weight =" + weight +
                ", deliveryAddress = " + deliveryAddress +
                ", sendDay = " + sendDay +
                ", ParcelType type = " + type +
                "}";
    }
}
