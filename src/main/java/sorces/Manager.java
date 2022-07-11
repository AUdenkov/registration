package sorces;

import controller.Menu;
import error.MyException;
import model.Profile;
import model.TypeProfil;
import result.ResultAdmin;
import result.ResultUser;

import java.util.Scanner;

public class Manager {
    private static Profile profile;
    private static Scanner scannerIn;

    public Manager() {
        scannerIn = new Scanner(System.in);

    }

    public static boolean menuAdminResult() {
        String menuAdminResult = Menu.menuAdmin();
        if (checkInt(menuAdminResult)) {
            switch (Integer.parseInt(menuAdminResult)) {
                case 1 -> {
                    Connect.getSpisok().stream().forEach(System.out::println);
                }
                case 2 -> {
                    System.out.println("Введите ник");
                    String nick = scannerIn.next();
                    Profile profile = Connect.searchProfile(nick);
                    if (profile != null) {
                        if (profile.getTypeProfil().equals(TypeProfil.ADMIN) && Connect.countAdmin() == 1) {
                            System.out.println("нельзя удалять последнего админа");
                        } else {
                            Connect.deleteProfile(nick);
                            if (profile.getNick().equals(nick)) {
                                System.out.println("Вы удалили себя");
                                return false;
                            }
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Введите ник");
                    String nick = scannerIn.next();
                    Profile profile = Connect.searchProfile(nick);
                    if (profile != null) {
                        if (profile.getTypeProfil().equals(TypeProfil.ADMIN) && Connect.countAdmin() == 1) {
                            System.out.println("нельзя менять уровень доступа у последнего админа");
                        } else {
                            Connect.editTypeProfile(nick, answerTypeProfileResult(nick));
                            if (profile.getNick().equals(nick)) {
                                System.out.println(profile.getNick());
                                System.out.println(nick);
                                return false;
                            }
                        }
                    }
                }
                case 4 -> {
                    profile = null;
                    return false;
                }
                default -> {
                    new MyException("не вверный ввод");
                    menuAdminResult();
                }
            }
        }
        return true;
    }

    public static boolean menuUserResult() {
        String menuUserResult = Menu.menuUser();
        if (checkInt(menuUserResult)) {
            switch (Integer.parseInt(menuUserResult)) {
                case 1 -> {
                    Connect.deleteProfile(profile.getNick());
                    System.out.println("Вы удалили себя");
                    profile = null;
                    return false;
                }
                case 2 -> {
                    profile = null;
                    return false;
                }
                default -> {
                    new MyException("не вверный ввод");
                    menuUserResult();
                }
            }
        }
        return true;
    }

    public static void menuOneResult() {
        String resultMenuOne = Menu.menuOne();
        if (checkInt(resultMenuOne)) {
            switch (Integer.parseInt(resultMenuOne)) {
                case 1 -> {
                    if (!isEmpty()) {
                        menuInResult();
                    } else {
                        System.out.println("У вас нету пользователей");
                        menuOneResult();
                    }
                }
                case 2 -> {
                    if (Connect.checkUser() != 0)
                        registrationResult(TypeProfil.USER);
                    else {
                        System.out.println("Вы создаёте 1 админа");
                        registrationResult(TypeProfil.ADMIN);
                    }
                }
                case 3 -> System.exit(0);
                default -> {
                    new MyException("не вверный ввод");
                    menuOneResult();
                }
            }
        } else menuOneResult();
    }

    public static boolean isEmpty() {
        return Connect.isEmpty();
    }

    public static void menuInResult() {
        String[] nickAndPassword = Menu.menuIn();
        if (checkString(nickAndPassword)) {
            Profile profile1 = Connect.searchProfile(nickAndPassword[0], String.valueOf(HashPassword.hashPassword(nickAndPassword[1])));
            if (profile1 != null) {
                profile = profile1;
                if (profile.getTypeProfil() == TypeProfil.ADMIN) {
                    ResultAdmin resultAdmin = new ResultAdmin(profile);
                } else {
                    ResultUser resultUser = new ResultUser(profile);
                }
            }
        } menuOneResult();
    }

    private static TypeProfil answerTypeProfileResult(String nick) {
        TypeProfil typeProfil = null;
        String answerTypeProfile = Menu.answerTypeProfile(nick);
        if (checkInt(answerTypeProfile)) {
            switch (Integer.parseInt(answerTypeProfile)) {
                case 1 -> typeProfil = TypeProfil.ADMIN;
                case 2 -> typeProfil = TypeProfil.USER;
                default -> {
                    new MyException("не вверный ввод");
                    answerTypeProfileResult(nick);
                }
            }
        }
        return typeProfil;
    }

    public static void registrationResult(TypeProfil typeProfil) {
        String[] dannieProfile = Menu.registration();
        String[] checkString = {dannieProfile[0], dannieProfile[1], dannieProfile[2], dannieProfile[4]};
        if (checkString(checkString) && checkAge(dannieProfile[3])) {
            Profile profile = new Profile(dannieProfile[0], dannieProfile[1], dannieProfile[2], Integer.parseInt(dannieProfile[3]), typeProfil, String.valueOf(HashPassword.hashPassword(dannieProfile[4])));
            Connect.addProfileInDataBase(profile);
        }
        menuOneResult();
    }


    private static boolean checkString(String[] string) {
        for (String checkString : string) {
            if (checkString.length() < 2) {
                try {
                    throw new MyException("No correct");
                } catch (MyException e) {
                    System.err.println(e.getMessage());
                }
                return false;
            }
        }
        return true;
    }

    private static boolean checkAge(String string) {
        try {
            int age = Integer.parseInt(string);
            if (age < 1 || age > 100) {
                try {
                    throw new MyException("No correct age");
                } catch (MyException e) {
                    System.err.println(e.getMessage());
                }
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Введите число в возрасте");
        }
        return true;
    }

    private static boolean checkInt(String s) {
        int number = 0;
        try {
            number = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            new MyException("Не вверный ввод");
        }
        return false;
    }
}


