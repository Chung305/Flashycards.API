package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.User;
import com.Flashycards.Flashycards.models.enums.Roles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp(){
        testEntityManager.persist(new User("arguello.chung@gmail.com", "chungarguello", "password", true, Roles.ADMIN.toString(), LocalDate.now()));
        testEntityManager.persist(new User("testing1@gmail.com", "tester1", "password", true, Roles.MEMBER.toString(), LocalDate.now()));
        testEntityManager.persist(new User("testing2@gmail.com", "tester2", "password", true, Roles.MEMBER.toString(), LocalDate.now()));
        testEntityManager.persist(new User("testing4@gmail.com", "tester3", "password", true, Roles.MEMBER.toString(), LocalDate.now()));
    }

    @Test
    public void findByUsernameTest(){
        String username = "chungarguello";
        User user = userRepository.findByUsername(username);

        assertEquals(username, user.getUsername());
    }

    @Test
    public void findByUsernameOrEmailTest(){
        String username = "chungarguello";
        String email = "arguello.chung@gmail.com";

        User user1 = userRepository.findByUsernameOrEmail(username, email);

        assertEquals(user1.getUsername(), username);
        assertEquals(user1.getEmail(), email);
    }

    @Test
    public void findAllByRolesTest(){
        String member = Roles.MEMBER.toString();
        String admin = Roles.ADMIN.toString();

        List<User> members = userRepository.findAllByRoles(member);
        List<User> admins = userRepository.findAllByRoles(admin);

        for(User each : members)
            assertEquals(each.getRoles(), member);

        for(User each : admins)
            assertEquals(each.getRoles(), admin);

        assertEquals(3, members.size());
        assertEquals(1, admins.size());
    }
}
