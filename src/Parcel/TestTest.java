package Parcel;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestTest {
    static StandardParcel standard = new StandardParcel("Мёд", 2, "Дом 5", 5, ParcelType.STANDART);
    static PerishableParcel perishable = new PerishableParcel("Рыба", 10, "Магазин", 9, ParcelType.PERISHABLE, 5);
    static FragileParcel fragile = new FragileParcel("Хрусталь", 1, "Дом 1", 12, ParcelType.FRAGILE);
    @Test
    public void testCalculateDeliveryCost() {
        assertEquals(4, standard.calculateDeliveryCost()); // 2 кг * 2 (base cost)
        assertEquals(30, perishable.calculateDeliveryCost()); // 10 кг * 3 (base cost)
        assertEquals(4, fragile.calculateDeliveryCost()); // 1 кг * 4 (base cost)
    }

    @Test
    public  void testIsExpired(){
        int currentDay = 15;
        assertFalse(perishable.isExpired(perishable.getSendDay(), perishable.getTimeToLive(),currentDay));
    }
    @Test
    public void addParcelIfWithinMaxWeight() {
        ParcelBox<StandardParcel> box = new ParcelBox(10);
        StandardParcel parcel1 = new StandardParcel("Мёд", 2, "Дом 5", 5, ParcelType.STANDART);
        StandardParcel parcel2 = new StandardParcel("Чай", 8, "Дом 6", 6, ParcelType.STANDART);
        StandardParcel parcel3 = new StandardParcel("Сахар", 3, "Дом 7", 7, ParcelType.STANDART);

        assertTrue(box.addParcel(parcel1)); // Добавляем посылку весом 2 кг
        assertTrue(box.addParcel(parcel2)); // Добавляем посылку весом 8 кг
        assertFalse(box.addParcel(parcel3)); // Пытаемся добавить посылку весом 3 кг, но вес превышает допустимый
    }

}
