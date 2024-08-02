package az.edu.orient.service;

import az.edu.orient.entity.UserEntity;
import az.edu.orient.exception.OrientException;
import az.edu.orient.model.UserDto;
import az.edu.orient.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    void getUsersGivenUsersIsEmptyExpectThrowsOrientException() throws OrientException {
        //setup
        Mockito.when(userRepository.findAll()).thenReturn(new ArrayList<>());
        //when
        OrientException ex = assertThrows(OrientException.class, () -> userService.getUsers());
        //expect
        assertEquals(ex.getMessage(), "There is not any user yet!");
        assertEquals(ex.getHttpStatus(), HttpStatus.NOT_FOUND);
    }

    @Test
    void getUsersGivenUsersIsNotEmptyExpectReturnUserDtoList() throws OrientException {
        // setup
        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity(1L, "Rashid", "Mammadli", "AZE" ,""));
        Mockito.when(userRepository.findAll()).thenReturn(users);
        // when
        List<UserDto> userDtos = userService.getUsers();
        // expect
        assertEquals(userDtos.size(), users.size());
        assertEquals(userDtos.get(0).getFirstName(), users.get(0).getFirstName());
    }
}