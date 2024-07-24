package az.edu.orient.model;

import az.edu.orient.validation.ValidCountry;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
  private Long id;
  @NotNull(message = "firstName is required")
  private String firstName;
  @NotNull(message = "lastName is required")
  private String lastName;
  @ValidCountry
  private String country;
  private String email;
}
