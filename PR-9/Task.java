import java.util.Scanner;

public class Task {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String text = inputString();

        System.out.println("Оберіть дію:");
        System.out.println("1 - Перевернути всю строку");
        System.out.println("2 - Перевернути кожне слово окремо");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Результат:");
            System.out.println(reverseString(text));
        } else if (choice == 2) {
            System.out.println("Результат:");
            System.out.println(reverseWords(text));
        } else {
            System.out.println("Невірний вибір");
        }
    }

    public static String inputString() {
        while (true) {
            System.out.print("Введіть строку: ");
            String input = scanner.nextLine();
            String[] words = input.trim().split("\\s+");

            if (words.length < 2) {
                System.out.println("Потрібно мінімум 2 слова!");
                continue;
            }

            boolean correct = true;
            for (String word : words) {
                if (word.length() < 3) {
                    correct = false;
                    break;
                }
            }

            if (!correct) {
                System.out.println("Кожне слово повинно містити мінімум 3 символи!");
                continue;
            }

            return input;
        }
    }

    public static String reverseString(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    public static String reverseWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse())
                  .append(" ");
        }

        return result.toString().trim();
    }
}
