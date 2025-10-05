package Parcel;

public class StandardParcel extends Parcel {//Стандартная
    StandardParcel(String description, int weight, String deliveryAddress, int sendDay,ParcelType type) {
        super(description, weight, deliveryAddress, sendDay, type);
    }
    //Для стандартных и скоропортящихся посылок
    // этот метод должен просто выводить на экран текст Посылка <<XXX>> упакована
    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + getDescription() + ">> упакована");
    }
}
