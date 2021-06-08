package entities;

public class UserGood {
    private int idUser;
    private int idGood;

    public UserGood(String s) {
        String[] arr = s.split("\t");
        this.idUser = Integer.parseInt(arr[0]);
        this.idGood = Integer.parseInt(arr[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGood userGood = (UserGood) o;

        if (idUser != userGood.idUser) return false;
        return idGood == userGood.idGood;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + idGood;
        return result;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdGood() {
        return idGood;
    }

    public void setIdGood(int idGood) {
        this.idGood = idGood;
    }
}
