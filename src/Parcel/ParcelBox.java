package Parcel;

import java.util.ArrayList;
import  java.util.List;

public class ParcelBox<T extends Parcel> {
    private int maxWeight;
    private List<T> parcels;
    private int currentWeight;


    ParcelBox(int maxWeight){
        this.maxWeight = maxWeight;
        this.parcels = new ArrayList();
        this.currentWeight = 0;
    }
    public boolean  addParcel(T parcel){
        int weight = 0;
        for (T m : parcels){
            weight += m.getWeight();
        }
        if (weight + parcel.getWeight() <= maxWeight) {
            parcels.add(parcel);
            weight += parcel.getWeight();
            return true;
        } else {
            System.out.println("В коробку больше не поместится");
            return false;
        }
    }

    public void getAllParcels(){
        for(T parcel : parcels){
            System.out.println(parcel);
        }
    }
}
