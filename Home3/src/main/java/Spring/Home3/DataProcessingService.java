package Spring.Home3;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class DataProcessingService {
    public String getGreeting(){
        return "Hello";
    }

    public List<User> sortUsersByAge(List<User> users){
        return users.stream().sorted(Comparator.comparing(user -> user.getAge())).toList();
    }
    public List<User> filterUsersByAge(List<User> users, int age){
        return users.stream().filter(user -> user.getAge() > age).toList();
    }
    public double calculateAverageAge(List<User> users){
        return users.stream().mapToInt(user -> user.getAge()).average().orElse(0);
    }
}
