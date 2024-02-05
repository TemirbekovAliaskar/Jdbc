package java12.userDao;

import java12.User;

public interface UserDao {

    void createUserTable();

    void addUser(User user);

    User getUserById(Long userId);

    void deleteUser();

    User updateUser(Long id, User newUser);

    User changeRoleUserNameAndPassword(Long id, User newUser);

    User getUserRole(String role);
}

