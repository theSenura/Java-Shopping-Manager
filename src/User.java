public class User {
    //Initializing variables
    private String username;
    private String password;
    private boolean isNewUser;

    //Creating constructor
    public User(String username,String password,boolean isNewUser){
        this.username = username;
        this.password = password;
        this.isNewUser = isNewUser;
    }

    //Creating getters and setters
    public boolean getNewUser() {
        return isNewUser;
    }
    public void setNewUser(boolean newUser) {
        isNewUser = newUser;
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

    public void setPassword(String password) {
        this.password = password;
    }


}
