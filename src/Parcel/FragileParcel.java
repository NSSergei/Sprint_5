package parcel;

import locationinfo.Trackable;

public class FragileParcel extends Parcel implements Trackable {//Хрупкая
    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay,ParcelType type) {
        super(description, weight, deliveryAddress, sendDay,type);
    }



    @Override
    public void packageItem() {
        packageItem(); // вывод "Посылка <<Весы>> упакована"
        System.out.println("Посылка <<" + description + ">> обёрнута в защитную плёнку");
        packageItem(); // ещё раз вывод "Посылка <<Весы>> упакована"
    }

    public void reportStatus(String newLocation){
        System.out.println("Хрупкая посылка <<" + description + ">> + изменила местоположение на " + newLocation);
    }

}

