package com.luizhf42.githubusersearch;

import java.util.Scanner;

public class InputHandler {
    static Scanner scanner = new Scanner(System.in);
    public static String getUsername() {
        System.out.print("Enter the username of the searched user: ");
        String username = scanner.next();
        if (username.matches("^[a-z\\d](?:[a-z\\d]|-(?=[a-z\\d])){0,38}$")) {
            return username;
        }

        throw new IllegalArgumentException("Invalid GitHub username!");
    }
}
