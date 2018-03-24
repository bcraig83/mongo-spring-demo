package b3ls.mongospringdemo.baeldung;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@CompoundIndexes({@CompoundIndex(name = "email_age", def = "{'email.id' : 1, 'age': 1}")})
public class User {

  @Id
  private String id;
  @Indexed(direction = IndexDirection.ASCENDING)
  private String name;
  @Indexed(direction = IndexDirection.ASCENDING)
  private Integer age;

  @Transient
  private Integer yearOfBirth;

  public User() {
  }


  @PersistenceConstructor
  public User(final String name, @Value("#root.age ?: 0") final Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(final Integer age) {
    this.age = age;
  }

  public Integer getYearOfBirth() {
    return yearOfBirth;
  }

  public void setYearOfBirth(final Integer yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }

}