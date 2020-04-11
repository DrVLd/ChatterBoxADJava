package dbconnect;

import core.User;

public class Main {

    public static void main(String[] args) {


        User user = DBConnector.login("anar", "parol");
        System.out.println(user);
    }
}
