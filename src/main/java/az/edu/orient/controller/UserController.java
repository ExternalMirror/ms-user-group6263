package az.edu.orient.controller;

import az.edu.orient.exception.OrientException;
import az.edu.orient.model.UserDto;
import az.edu.orient.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final List<Validator> validators;

  @InitBinder
  private void initBinder(WebDataBinder binder) {
    if (Objects.nonNull(binder.getTarget())) {
      for (Validator requestValidator : validators) {
        if (requestValidator.supports(binder.getTarget().getClass())) {
          binder.addValidators(requestValidator);
        }
      }
    }
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserDto> getUsers() throws OrientException {
    return userService.getUsers();
  }

  @GetMapping(path = "{id}")
  public UserDto getUserById(@PathVariable Long id) throws OrientException {
    return userService.getUserById(id);
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public UserDto addUser(@Valid @RequestBody  UserDto userDto) {
    return userService.addUser(userDto);
  }

  @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserDto updateUser(@PathVariable(name = "id") Long id, @RequestBody UserDto userDto) throws OrientException {
    userDto.setId(id);
    return userService.updateUser(userDto);
  }

  @DeleteMapping(path = "{id}")
  public void deleteById(@PathVariable(name = "id") Long id) throws OrientException {
    userService.deleteUser(id);
  }
}
