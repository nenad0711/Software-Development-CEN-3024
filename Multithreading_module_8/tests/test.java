
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class test {
    int[] sumInt = {10, 5, 4, 3, 2, 1};
    int start = 0;
    int middle = sumInt.length/2;
    int end = sumInt.length;
    @Test
    void singleThread() {
        int totalCount = 0;
        for(int x = 0; x < end; x++) {
            totalCount += sumInt[x];
        }

        assertEquals(25, totalCount);
    }



    @Test
    void firstT() {
        int totalCount1 = 0;

        for(int x = start; x < middle; x++) {
            totalCount1 += sumInt[x];
        }

        assertEquals(19, totalCount1);
    }

    @Test
    void secondT() {
        int totalCount2 = 0;

        for(int x = middle; x < end; x++) {
            totalCount2 += sumInt[x];
        }

        assertEquals(6, totalCount2);


    }
}