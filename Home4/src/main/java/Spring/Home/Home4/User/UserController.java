package Spring.Home.Home4.User;

import Spring.Home.Home4.DataServices.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final RegistrationService registrationService;
    private final UserService userService;

    @Autowired
    public UserController(RegistrationService registrationService, UserService userService) {
        this.registrationService = registrationService;
        this.userService = userService;
    }


    @PostMapping(value = "/reg")
    public ResponseEntity<User> createUser(@RequestParam String name,
                                           @RequestParam String email,
                                           @RequestParam String password) {
        return new ResponseEntity<>(registrationService.registerNewUser(name, email, password), HttpStatus.OK);

    }

    @GetMapping(value = "/byname/{name}")
    public String getUsersByName(Model model, @PathVariable("name") String name) {
        List<User> currUsers = userService.getUsersByName(name);
        if (currUsers.isEmpty()) return "badNotification";

        model.addAttribute("users", currUsers);
        return "users";
    }


    @GetMapping(value = "/byid/{id}")
    public String getUserById(Model model, @PathVariable("id") Long id) {
        User currUser = userService.getById(id);
        if (currUser == null) return "badNotification";
        model.addAttribute("user", currUser);
        return "user";
    }

    @GetMapping(value = "/del/{id}")
    public String delUserById(Model model, @PathVariable("id") Long id) {
        User currUser = userService.getById(id);
        if(userService.delById(id)){
            model.addAttribute("delUser", currUser);
            return "successDel";
        }
        return "badNotification";
    }


}
