import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.Year;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.DateTimeException;

public class Main {
    public static void main(String[] args) {

        String name;
        String surname;
        int birth_year;
        int birth_month;
        int birth_day;
        String zodiacType;

        Scanner input = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();


        while (true) {
            while (true) {
                try {
                    System.out.println("Введите Имя ");
                    name = input.nextLine().toUpperCase();
                    if (name.isEmpty()) {
                        throw new IllegalStateException();
                    } else break;
                }
                catch (IllegalStateException e) {
                    System.out.println("Поле не должно быть пустым");
                }
            }

            while (true) {
                try {
                    System.out.println("Введите Фамилию ");
                    surname = input.nextLine().toUpperCase();
                    if (surname.isEmpty()) {
                        throw new IllegalStateException();
                    } else break;
                }
                catch (IllegalStateException e) {
                    System.out.println("Поле не должно быть пустым");
                }
            }

            while (true) {
                try {
                    System.out.println("Введите Год рождения ");
                    birth_year = input.nextInt();
                    if (birth_year > Year.now().getValue() || birth_year < Year.of(1900).getValue()) {
                        throw new InputMismatchException();
                    } else {
                        break;
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Ошибка. Доступный диапазон: 1900 - " + Year.now().getValue());
                    input.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.println("Введите Месяц рождения ");
                    birth_month = input.nextInt();
                    if (birth_month != YearMonth.of(birth_year, birth_month).getMonthValue()) {
                        throw new InputMismatchException();
                    } else {
                        break;}
                }
                catch (InputMismatchException e) {
                    System.out.println("Ошибка. Должно быть число");
                    input.nextLine();
                }
                catch (DateTimeException e) {
                    System.out.println("Такого месяца нет. Валидное значение от 1 до 12");
                    input.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.println("Введите День рождения ");
                    birth_day = input.nextInt();
                    if (birth_day != MonthDay.of(birth_month, birth_day).getDayOfMonth()) {
                        throw new InputMismatchException();
                    } else {
                        break;
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Ошибка. Должно быть число");
                    input.nextLine();
                }
                catch (DateTimeException e) {
                    System.out.println("Такого дня нет. Валидное значение от 1 до 31");
                    input.nextLine();
                }
            }

            zodiacType = Zodiac.calculateZodiac(birth_month, birth_day);
            users.add(new User(users.size() + 1, name, surname, birth_year, birth_month, birth_day, zodiacType));

            System.out.println("Добавить еще одного человека? (да/нет)");
            String answer = input.next();
            input.nextLine();

            while (true) {
                if (!answer.equalsIgnoreCase("да") && !answer.equalsIgnoreCase("нет")) {
                    System.out.println("Уточните ответ (да/нет)");
                    answer = input.nextLine();
                }
                else break;
            }
            if (answer.equalsIgnoreCase("нет")) {
                break;
            }
        }

        int count1 = 0;
        int count2 = 0;
        for (User user : users) {
            count1++;
            if (user.getZodiacType().equalsIgnoreCase("Стрелец")) {
                System.out.println(user);
                count2++;
            }
        }
        if (count2 == 0) {
            System.out.println("Стрельцов в данном списке нет.");
        }
        System.out.println("Всего пользователей в списке: " + count1);
        System.out.println("Стрельцов в списке: " + count2);

    }
}