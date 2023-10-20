package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionService {

    public List<Integer> filterEvenNumbers(List<Integer> list) {
        List<Integer> listInt = list.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        return listInt;
    }

    public List<String> toUpperCaseCollection(List<String> list) {
        List<String> newList = list.stream().map(word -> word.toUpperCase()).collect(Collectors.toList());
        return newList;
    }

    public Optional<Integer> findMax(List<Integer> list) {
        int maxNumber = list.stream().mapToInt(num -> num).max().orElseThrow(NoSuchElementException::new);
        return Optional.of(maxNumber);
    }

    public Optional<Integer> findMin(List<List<Integer>> list) {
        int minNumber = list.stream().mapToInt(
                innerList -> {
                    return innerList
                            .stream()
                            .mapToInt(num -> num)
                            .min()
                            .orElseThrow(NoSuchElementException::new);
                }
                ).min().orElseThrow(NoSuchElementException::new);
        return Optional.of(minNumber);
    }

    public Integer sum(List<Integer> list) {
        int sumResult = list.stream().reduce(0, (subtotal, element) -> subtotal + element);
        return sumResult;
    }
}
