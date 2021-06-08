package entities;

public class User {
    private int id;
    private String name;
    private int yearBirth;
    private String city;

    public User(String s) throws Exception{
        String[] arr = s.split("\t");
        this.id = Integer.parseInt(arr[0]);
        this.name = arr[1];
        this.yearBirth = Integer.parseInt(arr[2]);
        this.city = arr[3];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (yearBirth != user.yearBirth) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return city != null ? city.equals(user.city) : user.city == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + yearBirth;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
