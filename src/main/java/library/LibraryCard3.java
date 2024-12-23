package library;

import java.time.LocalDate;

class LibraryCard3 {
    private LocalDate expirationDate;

    public LibraryCard3(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void renewCard() {
        this.expirationDate = LocalDate.now().plusYears(1);
    }
}
