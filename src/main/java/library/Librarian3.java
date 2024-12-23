package library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

class Librarian3 {
    private Map<String, Book3> libraryBooks = new HashMap<>();
    private Map<String, LocalDate> issuedBooks = new HashMap<>();
    private static final Map<String, Integer> LATE_FEES = Map.of(
            "Книга", 50,
            "Журнал", 30,
            "Электронная книга", 15
    );
    private LocalDate currentDate;

    public Librarian3() {
        this.currentDate = LocalDate.now();
        // Добавляем книги в библиотеку
        libraryBooks.put("Гарри Поттер", new Book3("Гарри Поттер", "Книга"));
        libraryBooks.put("Наука сегодня", new Book3("Наука сегодня", "Журнал"));
        libraryBooks.put("Программирование для начинающих", new Book3("Программирование для начинающих", "Электронная книга"));
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void advanceTime(int days) {
        this.currentDate = this.currentDate.plusDays(days);
        System.out.println("Время перемотано на " + days + " дней. Текущая дата: " + this.currentDate);
    }

    public void issueBook(String bookTitle, LibraryCard3 card) {
        if (!libraryBooks.containsKey(bookTitle)) {
            System.out.println("Извините, такой книги нет в библиотеке.");
            return;
        }

        if (card.getExpirationDate().isBefore(currentDate)) {
            System.out.println("Ваш читательский билет просрочен. Обновляем билет...");
            card.renewCard();
            System.out.println("Билет обновлён. Срок действия до: " + card.getExpirationDate());
        }

        issuedBooks.put(bookTitle, currentDate);
        System.out.println("Книга \"" + bookTitle + "\" успешно выдана.");
    }

    public void returnBook(String bookTitle) {
        if (!issuedBooks.containsKey(bookTitle)) {
            System.out.println("Эта книга не числится как выданная.");
            return;
        }

        LocalDate issueDate = issuedBooks.get(bookTitle);
        long overdueDays = ChronoUnit.DAYS.between(issueDate, currentDate) - 14; // Предполагаем, что срок возврата 14 дней

        if (overdueDays > 0) {
            String bookType = libraryBooks.get(bookTitle).getType();
            int finePerDay = LATE_FEES.get(bookType);
            int totalFine = (int) overdueDays * finePerDay;
            System.out.println("Книга просрочена на " + overdueDays + " дней. Штраф: " + totalFine + " рублей.");
        } else {
            System.out.println("Книга возвращена вовремя. Спасибо!");
        }

        issuedBooks.remove(bookTitle);
    }

    public void displayAvailableBooks() {
        System.out.println("Доступные книги в библиотеке:");
        for (String title : libraryBooks.keySet()) {
            System.out.println("- " + title);
        }
    }
}