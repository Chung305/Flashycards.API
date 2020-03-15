package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.Flashcards;
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

@DataJpaTest
@RunWith(SpringRunner.class)
public class FlashcardRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FlashcardRepository flashcardRepository;

    @Before
    public void setUp(){
        Flashcards flashcards = new Flashcards();
        flashcards.setCategory(Categories.Java);
        flashcards.setQuestion("Are you working?");
        flashcards.setAnswer("I hope so");

        entityManager.persist(flashcards);
    }

    @Test
    public void find_All_By_Category_Test(){
        List<Flashcards> flashcardsList = flashcardRepository.findAllByCategory(Categories.Java);

        assertEquals(1, flashcardsList.size());
    }

}
