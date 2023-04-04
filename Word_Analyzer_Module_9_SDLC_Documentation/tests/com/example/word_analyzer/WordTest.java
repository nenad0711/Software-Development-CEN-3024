package com.example.word_analyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {
    Word w = new Word("Valencia",1,50);

    @Test
    void getName() {
        assertEquals("Valencia",w.getName());
    }
    @Test
    void getFreq() {
        assertEquals(1,w.getFreq());
    }
    @Test
    void getId() {
        assertEquals(50,w.getId());
    }

}