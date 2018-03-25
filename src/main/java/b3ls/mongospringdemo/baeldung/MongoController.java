package b3ls.mongospringdemo.baeldung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController {

  private UserRepository userRepository;

  @Autowired
  public MongoController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping("/")
  public String helloWorld() {
    return "Hello World!";
  }

  @RequestMapping(value = "/create/{username}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public void create(@PathVariable("username") String username) {
    User user = new User();
    user.setName(username);
    userRepository.insert(user);
  }

  @RequestMapping(value = "/capitalise/{username}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public void capitalise(@PathVariable("username") String username) {
    User user = userRepository
        .findByName(username);

    user.setName(StringUtils.capitalize(username));
    userRepository.save(user);
  }

  @RequestMapping(value = "/delete/{username}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("username") String username) {
    User user = userRepository
        .findByName(username);

    userRepository.delete(user);
  }

  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.OK)
  public void deleteAll() {
    userRepository.deleteAll();
  }
}
