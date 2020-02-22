package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.Score;
import com.Flashycards.Flashycards.models.User;
import com.Flashycards.Flashycards.models.enums.Categories;
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

@RunWith(SpringRunner.class)
@DataJpaTest
public class ScoreRepositoryTest {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private TestEntityManager entityManager;

    private User user1;
    private User user2;
    @Before
    public void setUp(){
        user1 = new User(
                "arguello.chung@gmail.com",
                "chungarguello",
                "Chung11161989.",
                true,
                Roles.MEMBER.toString(),
                LocalDate.now()
        );
        user2 = new User(
                "arguello.chung.dev@gmail.com",
                "chungAFu",
                "Chung11161989.",
                true,
                Roles.MEMBER.toString(),
                LocalDate.now()
        );

        entityManager.persist(user1);
        entityManager.persist(user2);

        entityManager.persist(new Score(Categories.Java, 100.00, user1));
        entityManager.persist(new Score(Categories.SQL, 100.00, user1));
        entityManager.persist(new Score(Categories.Java, 100.00, user2));
        entityManager.persist(new Score(Categories.SQL, 100.00, user2));

    }

    @Test
    public void find_all_by_User_test(){
        List<Score> user1Scores = scoreRepository.findAllByUsers(user1);
        List<Score> user2Scores = scoreRepository.findAllByUsers(user2);

        assertEquals(2, user1Scores.size());

        assertEquals(2, user2Scores.size());

    }

    @Test
    public void find_all_by_categories_test(){
        List<Score> javaScoresList = scoreRepository.findAllByCategories(Categories.Java);

        assertEquals(user1, javaScoresList.get(0).getUsers());
        assertEquals(user2, javaScoresList.get(1).getUsers());
        assertEquals(2, javaScoresList.size());
    }


}
