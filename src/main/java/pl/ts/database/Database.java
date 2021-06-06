package pl.ts.database;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import pl.ts.model.User;

import java.util.ArrayList;
import java.util.List;

@Component //- musimy odpiąć komponent z bazy danych bo jej już nie używamy
public class Database {
    List<User> users = new ArrayList<>();

  public Database() {
        users.add(new User("admin", DigestUtils.md5Hex("admin"),1, "Tomek", "Sochacki", "34", "512036775", User.Role.ADMIN));
        users.add(new User("user", DigestUtils.md5Hex("user"),2, "Romek", "Rochacki", "35", "513036775", User.Role.USER));
        users.add(new User("user", DigestUtils.md5Hex("user"),3, "Domek", "Dochacki", "36", "514036775", User.Role.USER));
    }

    public List<User> getAllUsers() {
        return this.users;
    }

    public List<User> getFilteredUsers(String pattern){
      List<User> filteredUsers = new ArrayList<>();
      for (User user: this.users){
          if (user.getName().toLowerCase().contains(pattern.toLowerCase()) ||
                  user.getSurname().toLowerCase().contains(pattern.toLowerCase())){
              filteredUsers.add(user);
          }
      }
      return filteredUsers;
    }

    public void addUser(User user){
      user.setPassword(DigestUtils.md5Hex(user.getPassword()));
      this.users.add(user);
    }

    public User authenticate(String login, String password){

      for (User user: this.users){
          if (user.getLogin().equals(login) && user.getPassword().equals(DigestUtils.md5Hex(password))){
              return user;
          }
      }
      return null;
    }

    public User findUserByPhoneNumber(String phoneNumber){
        for (User user: this.users){
            if (user.getPhoneNumber().equals(phoneNumber)){
                return user;
            }
        }
        return null;
    }
}
