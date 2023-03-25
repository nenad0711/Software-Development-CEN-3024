package application.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;

import application.MainController;

class TestingScrape {

	@Test
	void test() {
		MainController test  = new MainController();
		test.fileName = "C:\\Users\\nenad\\OneDrive\\Desktop\\TestingFile.txt";
		LinkedHashMap<String, Integer> expectedMap = new LinkedHashMap<>();
		LinkedHashMap<String, Integer> actualMap = test.sortedWords();
        expectedMap.put("java", 5);
        expectedMap.put("software ", 4);
        assertEquals(expectedMap,actualMap);
	}
}
