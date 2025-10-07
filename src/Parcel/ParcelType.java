package parcel;

public enum ParcelType {
    STANDARD(2),
    PERISHABLE(3),
    FRAGILE(4);

    private final int baseCost;

    ParcelType(int baseCost) {
        this.baseCost = baseCost;
    }

    public int getBaseCost(){
        return baseCost;
    }

}
