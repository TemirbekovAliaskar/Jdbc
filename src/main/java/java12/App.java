package java12;

import java12.config.DataBaseConnection;
import java12.userDao.UserDaiImpl;
import java12.userDao.UserDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        DataBaseConnection.getConnection();

        UserDao userDao = new UserDaiImpl();

//        userDao.createUserTable();
//        userDao.addUser(new User("ALi","Askarov","Programmer"));
//        System.out.println(userDao.getUserById(1L));
//        userDao.deleteUser();
//        userDao.updateUser(1L,new User("Nurlan","Asq","DevOps"));
//        System.out.println(userDao.getUserRole("DevOps"));
    }
}
