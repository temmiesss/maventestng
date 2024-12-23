package library;

import java.time.LocalDate;
import java.util.Scanner;

public class LibrarySystem3 {
    public static void main(String[] args) {
        Librarian3 librarian = new Librarian3();
        LibraryCard3 card = new LibraryCard3(LocalDate.now().minusMonths(1)); // Билет, который уже просрочен

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Показать доступные книги");
            System.out.println("2. Взять книгу");
            System.out.println("3. Вернуть книгу");
            System.out.println("4. Перемотать время");
            System.out.println("5. Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    librarian.displayAvailableBooks();
                    break;
                case 2:
                    System.out.println("Введите название книги:");
                    String bookTitle = scanner.nextLine();
                    librarian.issueBook(bookTitle, card);
                    break;
                case 3:
                    System.out.println("Введите название книги для возврата:");
                    bookTitle = scanner.nextLine();
                    librarian.returnBook(bookTitle);
                    break;
                case 4:
                    System.out.println("На сколько дней перемотать время?");
                    int days = scanner.nextInt();
                    librarian.advanceTime(days);
                    break;
                case 5:
                    System.out.println("Выход из системы. До свидания!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}