import entities.Good;
import entities.UserGood;
import entities.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    BufferedReader br;
    static List<String> list = null;
    static List<User> users = null;
    static List<Good> goods = null;
    static List<UserGood> userGoods = null;
    public static void main(String[] args) {
        try {
            list = Files.readAllLines(Paths.get("src/main/java/files/users.txt"));
            users = new ArrayList<>();
            for (String s: list) users.add(new User(s));

            list = Files.readAllLines(Paths.get("src/main/java/files/goods.txt"));
            goods = new ArrayList<>();
            for (String s: list) goods.add(new Good(s));

            list = Files.readAllLines(Paths.get("src/main/java/files/saved.txt"));
            userGoods = new ArrayList<>();
            for (String s: list) userGoods.add(new UserGood(s));

            String cityX = "Yadyger"; //hardcode
            printCountOfSavedTaskA(cityX);

            System.out.print("TaskБ: ");
            taskB();
            System.out.println("Task B" + (taskC()?"Yes":"NO"));

            users.sort(new UsersComparator());
            System.out.println(users);



        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void printCountOfSavedTaskA(String cityX) {
        users.stream().filter(x -> x.getCity().equals(cityX))
                .forEach(user -> {
                    System.out.print(user.getName() + " ");
                    System.out.println(userGoods.stream().filter(x -> x.getIdUser() == user.getId()).count());
                });
    }

    private static void taskB() {
        int count = 0;
        for (User u : users) {
            boolean flag = false;
            String city = u.getCity();
            for (Good g : goods) {
                if (g.getCity().equals(city)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean taskC() {
        for (User u : users) {
            int userId = u.getId();
            if (u.getYearBirth() > 2003) {
                int count = 0;
                Set<String> set = new TreeSet<>();
                for (UserGood s : userGoods) {
                    if (userId == s.getIdUser()) {
                        int goodId = s.getIdGood();
                        for (Good g : goods) {
                            if (g.getId() == goodId) {
                                set.add(g.getProduser());
                                break;
                            }
                        }
                    }
                    if (set.size() > 1) {
                        return false;
                    }
                }
                if (set.size() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /*public static void readAll(List<?> l) {
        for (String s: list) l.add(new (s));
    }*/ //не получилось ввод сделать без повтора кода

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public static List<String> getList() {
        return list;
    }

    public static void setList(List<String> list) {
        Main.list = list;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        Main.users = users;
    }

    public static List<Good> getGoods() {
        return goods;
    }

    public static void setGoods(List<Good> goods) {
        Main.goods = goods;
    }

    public static List<UserGood> getSaved() {
        return userGoods;
    }

    public static void setSaved(List<UserGood> userGood) {
        Main.userGoods = userGood;
    }
}
