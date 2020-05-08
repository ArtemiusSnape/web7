package model.entities;

import javax.persistence.*;

/**
 * Class that represents system user.
 * @autor Alexander Rai
 * @version 1.0
 */

@Entity(name = "User")
@Table(name = User.tableName)
public class User {
    public static final String tableName = "User";
    /**
     * User id
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;


    /**
     * User type
     * */
    private int user_type;

    /**
     * User name
     * */
    private String user_name;


    /**
     * User's login
     * */
    private String login;

    /**
     * User's password
     * */
    private String password;

    public User(){}
    /**
     * Creates tenant
     * */
    public User(int type, String name, String login, String password){
        this.user_type = type;
        this.user_name = name;
        this.login = login;
        this.password = password;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getUser_type() {
        return user_type;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUser_name() {
        return user_name;
    }

    @Override
    public String toString() {
        return "User: id: " + this.user_id +
                "\nname: " + this.user_name +
                "\ntype: " + this.user_type +
                "\nlogin: " + this.login +
                "\npassword: " + this.password + "\n";
    }
}
