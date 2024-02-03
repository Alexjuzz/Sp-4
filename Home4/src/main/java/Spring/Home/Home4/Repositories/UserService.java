package Spring.Home.Home4.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     *
     * @param name имя пользователя
     * @param email емаил пользвотеля
     * @param password пароль
     * @return null - елси пользвателья уже добавлен ранее. User если пользовател создан.
     */


    public User createUser(String name, String email, String password){
        User user = new User(name,email,password);
        if(checkUser(user)){
            userRepository.addUser(user.getId(),user);
         return user;
        }
        return  null;
    }
    private boolean checkUser(User user){
        if(userRepository.getAllUsers().containsValue(user)){
            return false;
        }
        return true;
    }

}
