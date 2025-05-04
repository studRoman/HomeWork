

public class User {

    private int id;
    private String name;
    private String surname;
    private int birth_year;
    private int birth_month;
    private int birth_day;
    private String zodiacType;

    public User(int id, String name, String surname, int birth_year, int birth_month, int birth_day, String zodiacType)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth_year = birth_year;
        this.birth_month = birth_month;
        this.birth_day = birth_day;
        this.zodiacType = Zodiac.calculateZodiac(birth_month, birth_day);
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getBirth_year() {
        return birth_year;
    }
    public int getBirth_month() {
        return birth_month;
    }
    public int getBirth_day() {
        return birth_day;
    }
    public String getZodiacType() {
        return zodiacType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth_year=" + birth_year +
                ", birth_month=" + birth_month +
                ", birth_day=" + birth_day +
                ", zodiacType='" + zodiacType + '\'' +
                '}';
    }
}
