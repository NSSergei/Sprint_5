package Parcel;

public class FragileParcel extends Parcel implements Trackable {//Хрупкая
    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay,ParcelType type) {
        super(description, weight, deliveryAddress, sendDay,type);
    }


    public void saveParcel() {
        System.out.println("Посылка <<" + getDescription() + ">> упакована в защитную плёнку");
    }

    @Override
    public void packageItem() {
        saveParcel(); // вывод "Посылка <<Весы>> упакована"
        System.out.println("Посылка <<" + getDescription() + ">> обёрнута в защитную плёнку");
        saveParcel(); // ещё раз вывод "Посылка <<Весы>> упакована"
    }

    public void reportStatus(String newLocation){
        System.out.println("Хрупкая посылка <<" + getDescription() + ">> + изменила местоположение на " + newLocation);
    }

}

