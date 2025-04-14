import java.util.Scanner;

public class PersonalAssistant {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Hello, I am your personal assistant. How can I help you today?");
            String input = scanner.nextLine().toLowerCase();
            while (!input.equals("exit")) {
                if (input.contains("hello") || input.contains("hi")) {
                    System.out.println("Hi there!");
                } else if (input.contains("what is your name")) {
                    System.out.println("My name is Mota Bhai.");
                } else if (input.contains("what time is it")) {
                    System.out.println("The time is " + java.time.LocalTime.now());
                } else if (input.contains("set a reminder")) {
                    System.out.println("What should I remind you about?");
                    String reminder = scanner.nextLine();
                    System.out.println("When should I remind you? (Please enter a time in HH:mm format)");
                    String time = scanner.nextLine();
                    System.out.println("I will remind you to " + reminder + " at " + time + ".");
                } else {
                    System.out.println("I'm sorry, I don't understand. Could you please rephrase your request?");
                }
                input = scanner.nextLine().toLowerCase();
            }
        }
        System.out.println("Goodbye! Have a nice day.");
    }
}
