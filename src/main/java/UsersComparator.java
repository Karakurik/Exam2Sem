import entities.UserGood;
import entities.User;

import java.util.Comparator;
import java.util.List;

public class UsersComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        List<UserGood> userGood = Main.userGoods;
        int cou = 0;
        for (UserGood s : userGood) {
            if (s.getIdUser() == o1.getId()) {
                cou++;
            }

            if (s.getIdUser() == o2.getId()) {
                cou--;
            }
        }
        return cou;
    }
}
