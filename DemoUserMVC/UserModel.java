package DemoUserMVC;
import java.util.List;
import java.util.ArrayList;
public class UserModel {
    private List<User> users = new ArrayList<User>();

    public void addUser(User user){
        users.add(user);
    }

    public User getUserByUsername(String username){
        for(User user : users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
    public void DeleteUser(User user){
        users.remove(user);
    }
}
