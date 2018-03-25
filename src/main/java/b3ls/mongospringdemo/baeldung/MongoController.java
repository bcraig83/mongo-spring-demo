package b3ls.mongospringdemo.baeldung;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface MongoController {

  @RequestMapping("/")
  String helloWorld();

  @RequestMapping(value = "/create/{username}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  void create(@PathVariable("username") String username);

  @RequestMapping(value = "/capitalise/{username}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  void capitalise(@PathVariable("username") String username);

  @RequestMapping(value = "/delete/{username}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.OK)
  void delete(@PathVariable("username") String username);

  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.OK)
  void deleteAll();

  @RequestMapping(value = "/get", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  List<User> getAll();
}
