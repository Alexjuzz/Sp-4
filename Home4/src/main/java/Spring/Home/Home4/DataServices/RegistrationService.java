package Spring.Home.Home4.DataServices;

import Spring.Home.Home4.Repositories.UserRepository;
import Spring.Home.Home4.User.User;
import Spring.Home.Home4.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserService userService;

    @Autowired
    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    // Кустарный метод для  проверки валидности данных
    public User registerNewUser(String name, String email, String password) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (email == null || !email.contains("@")) { // Простая проверка email
            throw new IllegalArgumentException("Некорректный адрес электронной почты");
        }
        User newUser = userService.createUser(name, email, password);
        return newUser;
    }
}
