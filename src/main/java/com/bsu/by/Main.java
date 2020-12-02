package com.bsu.by;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        try (Scanner scannerHorses = new Scanner(new File("horses.txt"))) {
            while (scannerHorses.hasNextLine()) {
                String line = scannerHorses.nextLine();
                String[] horse = line.split(",");
                horses.add(new Horse(horse));
            }
            int key;
            Methods methods = new Methods(horses);
            Scanner scanner = new Scanner(System.in);
            boolean go = true;
            while (go) {
                menu();
                key = scanner.nextInt();
                scanner.nextLine();
                switch (key) {
                    case 1:
                        methods.horseWin();
                        break;
                    case 2:
                        System.out.println("Enter the minimum number of wins");
                        int wins = scanner.nextInt();
                        scanner.nextLine();
                        methods.TopWins(wins);
                        break;
                    case 3:
                        System.out.println("Enter the horse's name");
                        String name = scanner.nextLine();
                        methods.searchName(name);
                        break;
                    case 4:
                        System.out.println("Enter the name of the club");
                        String category = scanner.nextLine();
                        System.out.println("Club: " + category + ". Wins: " + methods.victoriesOfTheClub(category));
                        break;
                    case 0:
                        go = false;
                        break;
                }
            }
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void menu() {
        System.out.println("Selected category");
        System.out.println("1.All the horses and their victories");
        System.out.println("2.Horses by number of wins greater than a given number");
        System.out.println("3.Find a horse by name");
        System.out.println("4.Club and the number of their wins");
        System.out.println("0. Exit");
    }
}

