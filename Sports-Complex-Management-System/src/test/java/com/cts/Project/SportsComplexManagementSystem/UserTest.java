package com.cts.Project.SportsComplexManagementSystem;


import com.cts.Project.SportsComplexManagementSystem.Model.User;
import com.cts.Project.SportsComplexManagementSystem.Repository.UserRepository;
import com.cts.Project.SportsComplexManagementSystem.Service.UserService;
import com.cts.Project.SportsComplexManagementSystem.UserDefinedExceptions.NotExistInDatabase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UserTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void getUsersTest() {
        User user = new User();
        List<User> userList = Collections.singletonList(user);

        when(userRepository.findAll()).thenReturn(userList);

        List<User> result = userService.getUsers();

        assertEquals(userList, result);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void getUsersTest_NoUsers() {
        when(userRepository.findAll()).thenReturn(Collections.emptyList());

        Exception exception = assertThrows(NotExistInDatabase.class, () -> {
            userService.getUsers();
        });

        String expectedMessage = "No users found in Database";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(userRepository, times(1)).findAll();
    }
}