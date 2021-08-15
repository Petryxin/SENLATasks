package com.senla.tasks.task7;

public class Item {
    private final String name; //название предмета
    private final int volume; //объем
    private final int price; //ценность

    public Item(String name, int volume, int price) {
        this.name = name;
        this.volume = volume;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", price=" + price +
                '}';
    }
}


