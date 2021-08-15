package com.senla.tasks.task7;

public interface SafeService {
    Safe[][] getArrayOfSafeStatesWithMaxPrice(Item[] items, int maxSafeVolume, int numberOfItems);
    void printCombinationOfItemsOfMaxSafePrice(Safe[][] arrayOfSafeStates);
}
