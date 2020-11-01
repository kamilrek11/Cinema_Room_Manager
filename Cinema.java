package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        int option;
        char[][] cinema = new char[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = 'S';
            }
        }
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            option = scanner.nextInt();
            if(option == 1) {
                showSeats(cinema, rows, seats);
            }
            if (option == 2) {
                buyTicket(cinema, rows, seats);
            }
            if (option == 3) {
                statistics(cinema, rows, seats);
            }
        } while(option != 0);


    }
    public static void showSeats(char[][] cinema, int rows, int seats) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < seats; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats; j++) {
                System.out.print(" " + cinema[i][j]);
            }
            System.out.println();
        }
    }
    public static void buyTicket(char[][] cinema, int rows, int seats) {
        Scanner scanner = new Scanner(System.in);
        boolean isGood = false;
        int row;
        int seat;
        do {
            System.out.println("Enter a row number:");
            row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seat = scanner.nextInt();
            if (row > rows || seat > seats) {
                System.out.println("Wrong input!");
            } else if (cinema[row - 1][seat - 1] == 'B'){
                System.out.println("That ticket has already been purchased");
            } else {
                isGood = true;
                cinema[row - 1][seat - 1] = 'B';
            }
        } while (!isGood);

        System.out.println("Ticket price: ");
        if (rows * seats <= 60) {
            System.out.println("$10");
        } else if (row > rows / 2) {
            System.out.println("$8");
        }
        else {
            System.out.println("$10");
        }
    }
    public static void statistics(char[][] cinema, int rows, int seats) {
        int ticket = 0;
        int full = rows * seats;
        int price;

        int current = 0;
        int total = 0;
        double percent = (double) ticket / full * 0.01;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                if (rows * seats <= 60) {
                    price = 10;
                } else if (i < Math.floor((double) rows / 2)) {
                    price = 10;
                } else {
                    price = 8;
                }
                if (cinema[i][j] == 'B') {
                    ticket += 1;
                    current += price;
                }
                total += price;

            }
        }
        System.out.println("Number of purchased tickets: " + ticket);
        String part = String.format("%.2f", percent);
        System.out.println("Percentage: " + part + "%");
        System.out.println("Current income: $" + current);
        System.out.println("Total income: $" + total);
    }
}