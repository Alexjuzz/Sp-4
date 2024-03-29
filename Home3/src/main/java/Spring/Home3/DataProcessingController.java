package Spring.Home3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/api")
public class DataProcessingController {
    private final DataProcessingService dataProcessingService;

    @Autowired
    public DataProcessingController(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hello() {
        String response = this.dataProcessingService.getGreeting();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseEntity<List<User>> sortUsers(@RequestBody List<User> users) {
        return new ResponseEntity<>(dataProcessingService.sortUsersByAge(users), HttpStatus.OK);
    }

    @RequestMapping(value = "/filter/{age}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> filterByAge(@PathVariable("age") Integer age, @RequestBody List<User> users) {
        return new ResponseEntity<>(dataProcessingService.filterUsersByAge(users, age), HttpStatus.OK);
    }

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public ResponseEntity<Double> calc(@RequestBody List<User> users) {
        return new ResponseEntity<>(dataProcessingService.calculateAverageAge(users), HttpStatus.OK);
    }
}
