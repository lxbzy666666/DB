package JDBC.POJO;

public class User {
    private  String UUID;
    private  String Name;
    private  Integer Password;

    @Override
    public String toString() {
        return "User{" +
                "UUID='" + UUID + '\'' +
                ", Name='" + Name + '\'' +
                ", Password=" + Password +
                '}';
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getPassword() {
        return Password;
    }

    public void setPassword(Integer password) {
        Password = password;
    }
}
