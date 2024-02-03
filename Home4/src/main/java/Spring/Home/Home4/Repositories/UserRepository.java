package Spring.Home.Home4.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserRepository {
    private Map<Long, User> users;

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
}
