package user;

public class User {
    protected String username;
    protected String password;
    protected String firstname;
    protected String surname;
    protected User(String username,String password,String firstname,String surname){
        this.username=username;
        this.password=password;
        this.firstname=firstname;
        this.surname=surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
