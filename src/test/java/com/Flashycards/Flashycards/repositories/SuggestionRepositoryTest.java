package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.Suggestion;
import com.Flashycards.Flashycards.models.enums.Categories;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SuggestionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SuggestionRepository suggestionRepository;

    @Before
    public void setUp(){
        entityManager.persist(new Suggestion(Categories.Java, "Testing Repo1", 10, 120));
        entityManager.persist(new Suggestion(Categories.Java, "Testing Repo2", 12, 120));
        entityManager.persist(new Suggestion(Categories.Java, "Testing Repo3", 10, 120));
        entityManager.persist(new Suggestion(Categories.SQL, "Testing Repo3", 10, 120));

    }

    /**
     * Testing Suggestion entity Repository method with Entity Manager
     */

    @Test
    public void testFindAllByCategories(){
        List<Suggestion> suggestionList = suggestionRepository.findAllByCategory(Categories.Java);

        assertEquals(3, suggestionList.size());
    }

    @Test
    public void testFindAllByCategories2(){
        List<Suggestion> suggestionList = suggestionRepository.findAllByCategory(Categories.SQL);

        assertEquals(1, suggestionList.size());
    }
}
