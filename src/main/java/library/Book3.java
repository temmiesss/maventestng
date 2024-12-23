package library;
class Book3 {
    private String title;
    private String type; // Тип издания: "Книга", "Журнал", "Электронная книга"

    public Book3(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }
}