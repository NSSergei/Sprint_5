package main;

import parcel.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();

    static ArrayList<StandardParcel> standardBox = new ArrayList<>();
    static ArrayList<PerishableParcel> perishableBox = new ArrayList<>();
    static ArrayList<FragileParcel> fragileBox = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    showBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Тип коробки вы которую мы хотим проверить");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels""

        ParcelType parcelType = null;

        System.out.println("""
                Введите тип посылки:
                1 - Обычная
                2 - Хрупкая
                3 - Скоропортящаяся
                0 - Завершить"""
        );

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                parcelType = ParcelType.STANDARD;
                break;
            case 2:
                parcelType = ParcelType.FRAGILE;
                break;
            case 3:
                parcelType = ParcelType.PERISHABLE;
                break;
            case 0:
                return;
            default:
                System.out.println("Нет такого типа посылок");

        }


        System.out.println("Введите название посылки");
        String description = scanner.nextLine();

        System.out.println(("Введите вес посылки"));
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес доставки");
        String deliveryAddress = scanner.nextLine();

        System.out.println("""
            Введите дату доставки
            В данном месяце 31 день
            """);
        int sendDay = Integer.parseInt(scanner.nextLine());

        while (0 > sendDay || sendDay > 31){
            System.out.println("В данном месяце 31 день вы ввели: " + sendDay +
                    " Введите корретный день");

            sendDay = Integer.parseInt(scanner.nextLine());
        }

        int timeToLive = 0;
        Parcel parcel;
        if (parcelType == ParcelType.PERISHABLE) {
            System.out.println("Укажите срок хранения скоропотящейся посылки");
            timeToLive = Integer.parseInt(scanner.nextLine());
            parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, parcelType, timeToLive);
        } else if (parcelType == ParcelType.FRAGILE){
            parcel = new FragileParcel(description, weight, deliveryAddress, sendDay, parcelType);
        } else {
            parcel = new StandardParcel(description, weight, deliveryAddress, sendDay, parcelType);
        }

        if (parcelType == ParcelType.STANDARD) {
            standardBox.add(new StandardParcel(description, weight, deliveryAddress, sendDay, parcelType));
        } else if (parcelType == ParcelType.PERISHABLE) {
            perishableBox.add(new PerishableParcel(description, weight, deliveryAddress, sendDay, parcelType, timeToLive));
        } else if (parcelType == ParcelType.FRAGILE) {
            fragileBox.add(new FragileParcel(description, weight, deliveryAddress, sendDay, parcelType));
        }
        allParcels.add(parcel);
    }


    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels){
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double price = 0;
        for (Parcel parcel : allParcels){
            price += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость посылок = " + price);
    }

    private  static  void showBox() {
        System.out.println("""
        Какой тип коробки вы хотите просмотреть?
        1 - Обычная
        2 - Хрупкая
        3 - Скоропортящаяся""");

        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            showContents(standardBox);
        }
        else if (choice == 2){
            showContents(fragileBox);
        }
        else if (choice == 3){
            showContents(perishableBox);
        }

    }


    private static void showContents(ArrayList<? extends Parcel> box){
        for (Parcel el :box){
            System.out.println(el);
        }
    }
}
