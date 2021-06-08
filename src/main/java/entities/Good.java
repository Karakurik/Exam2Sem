package entities;

public class Good {
    private int id;
    private String name;
    private String produser;
    private String city;

    public Good(String s) {
        String[] arr = s.split("\t");
        this.id = Integer.parseInt(arr[0]);
        this.name = arr[1];
        this.produser = arr[2];
        this.city = arr[3];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (id != good.id) return false;
        if (name != null ? !name.equals(good.name) : good.name != null) return false;
        if (produser != null ? !produser.equals(good.produser) : good.produser != null) return false;
        return city != null ? city.equals(good.city) : good.city == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (produser != null ? produser.hashCode() : 0);
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

    public String getProduser() {
        return produser;
    }

    public void setProduser(String produser) {
        this.produser = produser;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
