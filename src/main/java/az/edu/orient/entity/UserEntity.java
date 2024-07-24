package az.edu.orient.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private String country;
  private String email;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserEntity that = (UserEntity) o;
    return id.equals(that.id) && firstName.equals(that.firstName) && lastName.equals(that.lastName);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + firstName.hashCode();
    result = 31 * result + lastName.hashCode();
    return result;
  }
}
