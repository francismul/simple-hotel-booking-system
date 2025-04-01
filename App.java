/*
 * Prompt
 * Write a program to manage hotel bookings using a 2D array to store (room number,
 * guest name, booking status). Implement a method to display available rooms and
 * another method to check in guests
 * 
 */

import java.util.Scanner;

class Hotel {
    private String[][] rooms = {
            { "101", "", "Available" },
            { "102", "", "Available" },
            { "103", "", "Available" },
            { "104", "", "Available" },
            { "105", "", "Available" },
            { "106", "", "Available" },
            { "107", "", "Available" },
            { "108", "", "Available" },
            { "109", "", "Available" },
            { "110", "", "Available" },
            { "111", "", "Available" },
    };

    public void displayAvailableRooms() {
        System.out.println("\nAvailable Rooms");
        for (String[] room : rooms) {
            if (room[2].equalsIgnoreCase("Available")) {
                System.out.println("Room no: " + room[0] + " Availability: " + room[1]);
            }
        }
        System.out.println("\n");
    }

    public void checkInGuest(String guestName, String roomNo) {
        boolean booked = false;
        boolean available = false;
        for (String[] room : rooms) {
            if (room[0].equalsIgnoreCase(roomNo)) {
                if (room[2].equalsIgnoreCase("Available")) {
                    room[1] = guestName;
                    room[2] = "Occupied";
                    System.out.println("\nRoom no: " + room[0] + " has been booked by: " + room[1] + "\n");
                    booked = true;
                    available = true;
                } else {
                    System.out.println("\nThe room is already booked\n");
                    booked = false;
                    available = true;
                }
            }
        }
        if (!booked && !available) {
            System.out.println("\nRoom with room no: " + roomNo + "does not exist\n");
        }
    }
}

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Lamba Hotel");

        Hotel hotel = new Hotel();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Display Available Rooms");
                System.out.println("2. Book Room");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice;

                if (!scanner.hasNextInt()) {
                    System.out.println("\nEnter a valid number\n");
                    scanner.nextLine();
                    continue;
                }

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> hotel.displayAvailableRooms();
                    case 2 -> {
                        System.out.print("Room No: ");
                        String roomNo;

                        if (!scanner.hasNext()) {
                            System.out.println("Enter a valid text");
                            continue;
                        }
                        roomNo = scanner.next();
                        scanner.nextLine();

                        System.out.print("Guest Name: ");
                        String guestName;
                        if (!scanner.hasNextLine()) {
                            System.out.println("Enter a valid text");
                            continue;
                        }
                        guestName = scanner.nextLine();

                        hotel.checkInGuest(guestName, roomNo);
                    }
                    case 3 -> {
                        System.out.println("\nSee you later, guffer!\n");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice");
                }

            }
        }
    }
}