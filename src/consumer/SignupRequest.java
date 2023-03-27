package consumer;

public class SignupRequest {
    private String username;
    private String password;
    private String firstname;
    private String surname;
    private boolean isPermitted;
    SignupRequest(String username,String password,String firstname,String surname){
        this.username=username;
        this.password=password;
        this.firstname=firstname;
        this.surname=surname;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public String toString() {
        return "Username: "+username+"\n"+"Full name: "+firstname+" "+surname;
    }
}
