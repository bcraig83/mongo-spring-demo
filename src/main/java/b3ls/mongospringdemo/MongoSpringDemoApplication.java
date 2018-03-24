package b3ls.mongospringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoSpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoSpringDemoApplication.class, args);
	}


//	private UserRepository userRepository;
//
//	public void insertNewUser() {
//		User user = new User();
//		user.setName("Jon");
//		userRepository.insert(user);
//	}
}
