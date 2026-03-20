package mar17;

import java.util.Scanner;

public class User {
    final private String username;
    final private String password;
    final private String email;
    final private String phoneNumber;
    private boolean isRead;
    private final String id;
    private static int count;

    {
        count++;
        id = "usr-"+count+"-"+(count+1);
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        phoneNumber = null;
    }
    public User(String username, String password, String email, String phoneNum) {
        this.username = username;
        this.password = password;
        this.email = email;
        phoneNumber = phoneNum;
    }

    boolean login(String email){
        if(this.email.equalsIgnoreCase(email)){
            return true;
        }
        return false;
    }
    boolean login(String email, String password){
        if(this.email.equalsIgnoreCase(email) && this.password.equals(password)){
            return true;
        }
        return false;
    }
    boolean login(String email, String password, String username){
        if(this.email.equalsIgnoreCase(email) && this.password.equals(password) && this.username.equalsIgnoreCase(username)){
            return true;
        }
        return false;
    }

    public String getUserData(){
        return "USERNAME:" + this.username + " | PASSWORD:" + this.password + " | EMAIL:" + this.email;
    }

    public String getUserEmail(){
        return this.email;
    }

    public String getUserName(){
        return username;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getUserId(){
        return id;
    }

//    public static User getLoginPrompt(User[] arrUser){
//        if(arrUser.length == 0){return null;}
//
//        for(int i = 0)
//
//        return arrUser[0];
//    }
}
