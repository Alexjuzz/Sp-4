package Spring.Home.Home4.User;

import Spring.Home.Home4.Repositories.UserRepository;
import Spring.Home.Home4.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param name     имя пользователя
     * @param email    емаил пользвотеля
     * @param password пароль
     * @return null - елси пользвателья уже добавлен ранее. User если пользовател создан.
     */


    public User createUser(String name, String email, String password) {
        if (checkUser(name, email)) {
            User user = new User(name, email, password);
            userRepository.addUser(user.getId(), user);
            return user;
        }
        return null;
    }

    /**
     * @param name  используется для постка подходящих кондидатов
     * @param email второй кретерий для сравнения
     * @return возращаем если true если пользователя с данным именем и емайлом не было в списке.
     * false - если пользователь был найден
     */
    private boolean checkUser(String name, String email) {
        List<User> findUsers = userRepository.getUserByName(name); // метод вернет список людей по данному имени
        if (!findUsers.isEmpty()) { // если пусто то возращаем true
            return findUsers.stream().noneMatch(user -> user.getEmail().equals(email)); // если пользователь есть в списке то вернем false.
        }
        return true;
    }

    public List<User> getUsersByName(String name) {
        return userRepository.getUserByName(name);
    }

    public User getById(Long id) {
        return userRepository.getUserById(id);
    }

    public boolean delById(Long id){
        return userRepository.delUserById(id);
    }
}
