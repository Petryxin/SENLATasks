package com.senla.tasks.task7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Safe implements SafeService {
    private Item[] items;
    private int price;

    public Safe(Item[] items, int price) {
        this.items = items;
        this.price = price;
    }

    public Safe() {
    }

    //Dynamic programming method
    @Override
    public Safe[][] getArrayOfSafeStatesWithMaxPrice(Item[] items, int maxSafeVolume, int numberOfItems) {

        //массив промежуточных состояний сейфа
        Safe[][] safe = new Safe[numberOfItems + 1][maxSafeVolume + 1];

        for (int i = 0; i < numberOfItems + 1; i++) {
            for (int j = 0; j < maxSafeVolume + 1; j++) {
                if (i == 0 || j == 0) { //нулевую строку и столбец заполняем нулями
                    safe[i][j] = new Safe(new Item[]{}, 0);
                } else if (i == 1) {
                    /*первая строка заполняется просто: первый предмет кладём или не кладём в зависимости от объема*/
                    safe[1][j] = items[0].getVolume() <= j ? new Safe(new Item[]{items[0]}, items[0].getPrice())
                            : new Safe(new Item[]{}, 0);
                } else {
                    if (items[i - 1].getVolume() > j) //если очередной предмет не влезает в сейф,
                        safe[i][j] = safe[i - 1][j];    //записываем предыдущий максимум
                    else {
                        /*рассчитаем ценность очередного предмета + максимальную ценность для (максимально возможный для сейфа объем − объем предмета)*/
                        int newPrice = items[i - 1].getPrice() + safe[i - 1][j - items[i - 1].getVolume()].getPrice();
                        if (safe[i - 1][j].getPrice() > newPrice) //если предыдущий максимум больше
                            safe[i][j] = safe[i - 1][j]; //запишем его
                        else {
                            /*иначе фиксируем новый максимум: текущий предмет + стоимость свободного пространства*/
                            safe[i][j] = new Safe(Stream.concat(Arrays.stream(new Item[]{items[i - 1]}),
                                    Arrays.stream(safe[i - 1][j - items[i - 1].getVolume()].getItems())).toArray(Item[]::new), newPrice);
                        }
                    }
                }
            }
        }
        return safe;
    }

    @Override
    public void printCombinationOfItemsOfMaxSafePrice(Safe[][] arrayOfSafeStates) {
        //get last row in array[][]
        Safe[] lastRow = arrayOfSafeStates[arrayOfSafeStates.length - 1];

        Safe safeWithMaxPrice = Arrays.stream(lastRow).max(Comparator.comparing(Safe::getPrice))
                .orElse(new Safe(null, 0));

        List<Safe> safesWithTheSameMaxPrice = Arrays.stream(lastRow)
                .filter(m -> m.getPrice() == safeWithMaxPrice.getPrice()).collect(Collectors.toList());

        safesWithTheSameMaxPrice.forEach(m -> System.out.println(m.getDescription()));
    }

    //Описание состояния сейфа
    public String getDescription() {
        return items == null ? "" : Arrays.stream(items).map(Item::getName)
                .collect(Collectors.joining("+")) + "-" + getPrice();
    }

    public Item[] getItems() {
        return items;
    }

    public int getPrice() {
        return price;
    }
}
