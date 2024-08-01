package lesson4;

public enum Gender {
    MALE("Male"), FEMALE("Female");

    final String title;

    Gender(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
