/*
package pl.ts.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.ts.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@Component //odłączony
public class UserDAO {

    @Autowired
    Connection connection;

    public void addUser(User user){
        this.users.add(user);
    }

    public User getUserByLogin(String login) {
        try {
            String sql = "SELECT * FROM tuser WHERE login = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, login);

            ResultSet rs = preparedStatement.executeQuery();

            if(!rs.next()) {
                return null;
            }

            return mapUser(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    List<User> result = new ArrayList<>();
    public List<User> getAllUsers(){
        try {
            String sql = "SELECT * FROM tuser";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setAge(rs.getString("age"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setRole(User.Role.valueOf(rs.getString("role")));

                result.add(user);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }
}
*/
