package b3ls.mongospringdemo.baeldung;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.StringUtils;
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
  public void capitalise(@PathVariable("username") String username) {

    Query query = new Query();
    query.addCriteria(Criteria.where("name").is(username));

    Update update = new Update();
    update.set("name", StringUtils.capitalize(username));

    mongoTemplate.updateMulti(query, update, User.class);
  }

  @Override
  public void delete(@PathVariable("username") String username) {
    Query query = new Query();
    query.addCriteria(Criteria.where("name").is(username));

    List<User> usersToDelete = mongoTemplate.find(query, User.class);

    usersToDelete
        .stream()
        .forEach(user -> mongoTemplate.remove(user));
  }

  @Override
  public void deleteAll() {
  }

  @Override
  public List<User> getAll() {
    return mongoTemplate.findAll(User.class, "user");
  }
}
