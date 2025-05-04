


public class Zodiac {
    public static String calculateZodiac(int birth_month, int birth_day) {
        return switch (birth_month) {
            case 1 -> birth_day <= 20 ? "Козерог" : "Водолей";
            case 2 -> birth_day <= 18 ? "Водолей" : "Рыбы";
            case 3 -> birth_day <= 20 ? "Рыбы" : "Овен";
            case 4 -> birth_day <= 19 ? "Овен" : "Телец";
            case 5 -> birth_day <= 20 ? "Телец" : "Близнецы";
            case 6 -> birth_day <= 21 ? "Близнецы" : "Рак";
            case 7 -> birth_day <= 22 ? "Рак" : "Лев";
            case 8 -> birth_day <= 22 ? "Лев" : "Дева";
            case 9 -> birth_day <= 22 ? "Дева" : "Весы";
            case 10 -> birth_day <= 22 ? "Весы" : "Скорпион";
            case 11 -> birth_day <= 21 ? "Скорпион" : "Стрелец";
            case 12 -> birth_day <= 21 ? "Стрелец" : "Козерог";
            default -> throw new IllegalStateException("Месяц не найден: " + birth_month);
        };
    }
}
