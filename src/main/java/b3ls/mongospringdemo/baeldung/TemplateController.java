package b3ls.mongospringdemo.baeldung;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/template")
public class TemplateController implements MongoController{

  @Override
  public String helloWorld() {
    return "Hello from the template controller!";
  }

  @Override
  public void create(String username) {

  }

  @Override
  public void capitalise(String username) {

  }

  @Override
  public void delete(String username) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public List<User> getAll() {
    return null;
  }
}
