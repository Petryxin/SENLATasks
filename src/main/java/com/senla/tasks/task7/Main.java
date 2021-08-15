package com.senla.tasks.task7;

public class Main {
    public static void main(String[] args) {
//массив предметов
        Item[] items = {new Item("макароны", 3, 1),
                new Item("бритва", 6, 7),
                new Item("нож", 4, 6),
                new Item("батон", 5, 4),
                new Item("бритва", 6, 7),
                new Item("бутылка", 8, 7),
                new Item("ложка", 9, 5)};
        Safe safe = new Safe();
        Safe[][] arrayOfSafeStatesWithMaxPrice = safe.getArrayOfSafeStatesWithMaxPrice(items, 13, items.length);
        safe.printCombinationOfItemsOfMaxSafePrice(arrayOfSafeStatesWithMaxPrice);
    }
}
