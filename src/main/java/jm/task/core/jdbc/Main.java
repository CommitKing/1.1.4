package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Eugene", "Salnikov", (byte) 20);
        userService.saveUser("Kristina", "Salnikova", (byte) 19);
        userService.saveUser("Vitaliy", "Cal`", (byte) 36);
        userService.saveUser("Sasha", "kamen`", (byte) 56);

        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        userService.cleanUsersTable();

        userService.dropUsersTable();

        UserDaoJDBCImpl.closeConnection();
    }
}
