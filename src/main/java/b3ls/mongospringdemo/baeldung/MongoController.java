package b3ls.mongospringdemo.baeldung;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController {

  @RequestMapping("/")
  public String helloWorld() {
    return "Hello World!";
  }
}
