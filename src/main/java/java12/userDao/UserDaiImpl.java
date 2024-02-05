package java12.userDao;

import java12.User;
import java12.config.DataBaseConnection;

import java.sql.*;

public class UserDaiImpl implements UserDao{

    private  final Connection connection = DataBaseConnection.getConnection();
    @Override
    public void createUserTable() {
        String query = """
                create table users (
                id serial primary key,
                user_name varchar ,
                password varchar,
                role varchar)
                """;
        try (Statement statement = connection.createStatement()){
            statement.execute(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addUser(User user) {
        String queru = """
                insert into users (user_name,password,role)
                values (?,?,?)
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(queru)){
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getRole());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User getUserById(Long userId) {
        User user = new User();
        String query = "select * from users where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getLong("id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public void deleteUser() {
        String query = "drop table users";
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(query);
            System.out.println("Deleted !");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User updateUser(Long id,User newUser) {
        User user = new User();
        String query = """
                update users set user_name = ?, password = ?, role = ?
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,newUser.getUserName());
            preparedStatement.setString(2,newUser.getPassword());
            preparedStatement.setString(3,newUser.getRole());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public User changeRoleUserNameAndPassword(Long id ,User newUser) {
        User user = new User();
        String query = "update users set password = ?, role = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,newUser.getPassword());
            preparedStatement.setString(2,newUser.getRole());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }return user;
    }

    @Override
    public User getUserRole(String role) {
        User user = new User();
        String query = "select * from users where role = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,role);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getLong("id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return user;
    }
}
