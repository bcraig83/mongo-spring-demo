package b3ls.mongospringdemo.baeldung;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/template")
public class TemplateController implements MongoController {

  private MongoTemplate mongoTemplate;

  @Autowired
  public TemplateController(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public String helloWorld() {
    return "Hello from the template controller!";
  }

  @Override
  public void create(@PathVariable("username") String username) {
    User user = new User();
    user.setName(username);
    mongoTemplate.save(user);
  }

  @Override
  public void capitalise(String username) {
    // TODO
  }

  @Override
  public void delete(String username) {

  }

  @Override
  public void deleteAll() {
  }

  @Override
  public List<User> getAll() {
    return mongoTemplate.findAll(User.class, "user");
  }
}
