package com.Flashycards.Flashycards.service;

import com.Flashycards.Flashycards.repositories.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlashcardService {

    @Autowired
    private FlashcardRepository flashcardRepository;
}
