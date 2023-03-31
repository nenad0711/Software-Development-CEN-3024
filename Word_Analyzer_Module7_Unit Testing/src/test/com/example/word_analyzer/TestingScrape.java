package com.example.word_analyzer;


import org.junit.Test;

import static org.junit.Assert.*;
import java.util.LinkedHashMap;

class TestingScrape {

    @Test
    void test() {
        MainController test  = new MainController();
        test.fileName = "C:\\Users\\nenad\\OneDrive\\Desktop\\TestingFile.txt";
        LinkedHashMap<String, Integer> expectedMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> actualMap = test.sortedWords();
        expectedMap.put("java", 6);
        expectedMap.put("software", 4);
        assertEquals(expectedMap,actualMap);
    }
}