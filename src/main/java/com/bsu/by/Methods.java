package com.bsu.by;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Methods {
    private final List<Horse> horses;

    public Methods(List<Horse> horses) {
        this.horses = horses;
    }

    public int victoriesOfTheClub(String club) {
        return horses
                .stream()
                .filter(p -> p.getClub().equalsIgnoreCase(club))
                .reduce(0, (x, y) -> x + y.getVictories(),
                        Integer::sum);
    }

    public void searchName(String NAME) {
        horses
                .stream().parallel()
                .filter(p -> p.getName().equals(NAME)).findAny()
                .ifPresent(System.out::println);
    }

    public void horseWin() {
        horses
                .stream()
                .collect(Collectors.toMap(Horse::getName, Horse::getVictories))
                .entrySet().forEach(System.out::println);
    }

    public void TopWins(int y) {
        horses
                .stream()
                .filter(c -> c.getVictories() > y)
                .map(c -> "Name: " + c.getName() + " - " + c.getVictories() + " wins")
                .forEach(System.out::println);
    }
}
