package com.luizhf42.githubusersearch;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);
            handleUserChoice(choice);
        }
    }

    private static void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1 - Search for a user profile");
        System.out.println("0 - Exit");
        System.out.print("Enter the option's number to choose: ");
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }

        return scanner.nextInt();
    }

    private static void handleUserChoice(int choice) throws URISyntaxException, IOException, InterruptedException {
        switch (choice) {
            case 0 -> {
                System.out.println("Exiting the system. Goodbye!");
                System.exit(0);
            }
            case 1 -> searchUser();
            default -> System.out.println("Choose one of the values of the menu!");
        }
    }

    private static void searchUser() throws URISyntaxException, IOException, InterruptedException {
        Fetcher fetcher = new Fetcher("https://api.github.com/users/");
        fetcher.getUser(InputHandler.getUsername());
    }
}