import entities.Good;
import entities.UserGood;
import entities.User;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class Tests {
    @Test
    public void compareTest() {
        try {
            User u1 = new User("1   Insaf   2002    Yadyger");
            User u2 = new User("1   Insaf   2002    Yadyger");
            Assert.assertEquals(0, new UsersComparator().compare(u1, u2));
        } catch (Exception e) {

        }
    }

    @Test
    public void taskCTest () {
        List<User> users = new ArrayList<>();
        List<UserGood> userGood = new ArrayList<>();
        List<Good> goods = new ArrayList<>();

        try {
            users.add(new User("-1\ttestChel\t2005\tYadyger"));
            userGood.add(new UserGood("-1\t-2"));
            goods.add(new Good("-2\tgoodName\tooo\tcity"));
            Assert.assertTrue(Main.taskC());

        } catch (Exception e) {

        }
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getArrayListTest () {
        new ArrayList<Integer>().get(0); //отсутствие скобок типа -1 за что? теория
    }
}
