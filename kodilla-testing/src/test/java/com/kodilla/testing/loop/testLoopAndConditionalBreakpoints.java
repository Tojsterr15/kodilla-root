package com.kodilla.testing.loop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testLoopAndConditionalBreakpoints {

    @Test
    public void testLoop(){
        //Given
        long sum = 0;

        //when
        for (int n = 0 ; n<1000 ; n++){
            sum += n;
            System.out.println("[" + n + "] Sum equals: " + sum);
        }
        assertEquals(499500 , sum);
    }
}
