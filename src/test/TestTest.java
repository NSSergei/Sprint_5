package test;

import container.ParcelBox;
import org.junit.jupiter.api.Test;
import parcel.FragileParcel;
import parcel.ParcelType;
import parcel.PerishableParcel;
import parcel.StandardParcel;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestTest {
    static StandardParcel standard = new StandardParcel("Мёд", 2, "Дом 5", 5, ParcelType.STANDARD);
    static PerishableParcel perishable1 = new PerishableParcel("Рыба", 10, "Магазин", 9, ParcelType.PERISHABLE, 5);
    static PerishableParcel perishable2 = new PerishableParcel("Мясо", 5, "Магазин", 10, ParcelType.PERISHABLE, 5);
    static PerishableParcel perishable3 = new PerishableParcel("Цветы", 50, "Магазин", 12, ParcelType.PERISHABLE, 5);
    static FragileParcel fragile = new FragileParcel("Хрусталь", 1, "Дом 1", 12, ParcelType.FRAGILE);
    @Test
    public void testCalculateDeliveryCost() {
        assertEquals(4, standard.calculateDeliveryCost()); // 2 кг * 2 (base cost)
        assertEquals(30, perishable1.calculateDeliveryCost()); // 10 кг * 3 (base cost)
        assertEquals(4, fragile.calculateDeliveryCost()); // 1 кг * 4 (base cost)
    }

    @Test
    public  void testIsExpired(){
        int currentDay = 15;
        assertFalse(perishable1.isExpired(perishable1.getSendDay(), perishable1.getTimeToLive(),currentDay));
        assertTrue(perishable2.isExpired(perishable2.getSendDay(), perishable2.getTimeToLive(),currentDay));
        assertTrue(perishable3.isExpired(perishable3.getSendDay(), perishable3.getTimeToLive(), currentDay));


    }
    @Test
    public void addParcelIfWithinMaxWeight() {
        ParcelBox<StandardParcel> box = new ParcelBox(10);
        StandardParcel parcel1 = new StandardParcel("Мёд", 2, "Дом 5", 5, ParcelType.STANDARD);
        StandardParcel parcel2 = new StandardParcel("Чай", 8, "Дом 6", 6, ParcelType.STANDARD);
        StandardParcel parcel3 = new StandardParcel("Сахар", 3, "Дом 7", 7, ParcelType.STANDARD);

        assertTrue(box.addParcel(parcel1)); // Добавляем посылку весом 2 кг
        assertTrue(box.addParcel(parcel2)); // Добавляем посылку весом 8 кг
        assertFalse(box.addParcel(parcel3)); // Пытаемся добавить посылку весом 3 кг, но вес превышает допустимый
    }

}
