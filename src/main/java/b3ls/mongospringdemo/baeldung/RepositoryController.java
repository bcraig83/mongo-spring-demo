package b3ls.mongospringdemo.baeldung;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repo")
public class RepositoryController implements MongoController {

  private UserRepository userRepository;

  @Autowired
  public RepositoryController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public String helloWorld() {
    return "Hello World!";
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  public void create(@PathVariable("username") String username) {
    User user = new User();
    user.setName(username);
    userRepository.insert(user);
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  public void capitalise(@PathVariable("username") String username) {
    User user = userRepository
        .findByName(username);

    user.setName(StringUtils.capitalize(username));
    userRepository.save(user);
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("username") String username) {
    User user = userRepository
        .findByName(username);

    userRepository.delete(user);
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  public void deleteAll() {
    userRepository.deleteAll();
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  public List<User> getAll() {
    return userRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
  }
}
