package b3ls.mongospringdemo.baeldung;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "b3ls.mongospringdemo")
public class MongoConfig extends AbstractMongoConfiguration {

  @Override
  public MongoClient mongoClient() {
    return new MongoClient("127.0.0.1", 27017);
  }

  @Override
  protected String getDatabaseName() {
    return "test";
  }
}
