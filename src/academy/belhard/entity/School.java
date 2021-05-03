package academy.belhard.entity;

public class School {
    private int id;
    private String title;
    private String city;

    public School(int id, String title, String city) {
        this.id = id;
        this.title = title;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                '}' + "\n";
    }
}
