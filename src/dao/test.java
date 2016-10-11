package dao;

import exceptions.InvalidUsernameException;

/**
 * Created by marie on 11-Oct-16.
 */
public class test {


    public static void main(String[] args) {
        Manager m = new Manager();
        try {
            System.out.println(m.login("sysadmin", "mari"));
        } catch (InvalidUsernameException e) {
            e.printStackTrace();
        }
        m.addUser(new EmployeesEntity("mari", "paroli", "standart"));
    }
}
