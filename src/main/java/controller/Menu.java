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
        System.out.println("1) �����");
        System.out.println("2) �����������");
        System.out.println("3) �����");
        return scannerIn.next();
    }


    public static String[] menuIn() {
        System.out.println("������� ���");
        String nick = scannerIn.next();
        System.out.println("������� ������");
        String password = scannerIn.next();
        String[] nickAndPassword = {nick, password};
        return nickAndPassword;
    }


    public static String[] registration() {
        System.out.println("������� ���");
        String firstName = scannerIn.next();
        System.out.println("������� �������");
        String lastName = scannerIn.next();
        System.out.println("������� ��� ����� ����� ������ ��������");
        String nick = scannerIn.next();
        System.out.println("������� ���������� ���");
        String age = scannerIn.next();
        System.out.println("������� ������");
        String password = scannerIn.next();
        String[] dateProfile = {firstName, lastName, nick, age, password};
        return dateProfile;
    }

    public static String menuAdmin() {
        System.out.println("1) �������� ������");
        System.out.println("2) ������� ������������");
        System.out.println("3) �������� ����� ������������");
        System.out.println("4) �����");
        return scannerIn.next();
    }

    public static String menuUser() {
        System.out.println("1) ������� ������������");
        System.out.println("2) �����");
        return scannerIn.next();
    }


    public static String answerTypeProfile(String nick) {
        System.out.println("����� �� ������� ������� ������ ���� ������������ " + nick);
        System.out.println("1) ADMIN");
        System.out.println("2) USER");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();

    }


}
