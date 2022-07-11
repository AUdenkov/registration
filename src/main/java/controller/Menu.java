package controller;

import sorces.Manager;

import java.util.Scanner;

public class Menu {
    private static Scanner scannerIn;

    public Menu() {
        scannerIn = new Scanner(System.in);
        Manager manager = new Manager();
        Manager.menuOneResult();
    }

    public static String menuOne() {
        System.out.println("1) Войти");
        System.out.println("2) Регистрация");
        System.out.println("3) Выйти");
        return scannerIn.next();
    }


    public static String[] menuIn() {
        System.out.println("Введите ник");
        String nick = scannerIn.next();
        System.out.println("Введите пороль");
        String password = scannerIn.next();
        String[] nickAndPassword = {nick, password};
        return nickAndPassword;
    }


    public static String[] registration() {
        System.out.println("Введите имя");
        String firstName = scannerIn.next();
        System.out.println("Введите Фамилию");
        String lastName = scannerIn.next();
        System.out.println("Введите Под каким ником будите заходить");
        String nick = scannerIn.next();
        System.out.println("Введите количество лет");
        String age = scannerIn.next();
        System.out.println("Введите пороль");
        String password = scannerIn.next();
        String[] dateProfile = {firstName, lastName, nick, age, password};
        return dateProfile;
    }

    public static String menuAdmin() {
        System.out.println("1) Получить список");
        System.out.println("2) удалить пользователя");
        System.out.println("3) изменить права пользователя");
        System.out.println("4) выйти");
        return scannerIn.next();
    }

    public static String menuUser() {
        System.out.println("1) удалить пользователя");
        System.out.println("2) выйти");
        return scannerIn.next();
    }


    public static String answerTypeProfile(String nick) {
        System.out.println("Какой вы уровень доступа хотите дать пользователю " + nick);
        System.out.println("1) ADMIN");
        System.out.println("2) USER");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();

    }


}
