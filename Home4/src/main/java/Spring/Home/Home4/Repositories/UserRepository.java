package Spring.Home.Home4.Repositories;

import Spring.Home.Home4.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<Long, User> users;

    @Autowired
    public UserRepository() {
        this.users = new HashMap<>();
    }

    public void addUser(Long id, User user) {
        users.put(id,user);
    }

    public User getUserById(Long id){
        return users.get(id);
    }
    public Map<Long,User> getAllUsers(){
        return users;
    }
    public List<User> getUserByName(String name){
        List<User> currentUsers = new ArrayList<>();
        for (Map.Entry<Long,User> userEntry: users.entrySet()) {
                if(userEntry.getValue().getName().equals(name)){
                    currentUsers.add(userEntry.getValue());
                }
        }
        return currentUsers;
    }
    public boolean delUserById(Long id){
        if(users.isEmpty() || users.size() < id){
            return false;
        }
        users.remove(id);
        return true;
    }

}
