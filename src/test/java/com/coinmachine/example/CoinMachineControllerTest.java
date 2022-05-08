package com.coinmachine.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.coinmachine.example.service.CoinMachineService;
import org.junit.Test;


public class CoinMachineControllerTest {

    @Test
    public void testService() {
        //given
        String input = "213";
        String finalResult = "";

        //when
        finalResult = CoinMachineService.getResult(input);

        //then
        assertEquals("1 £2, 1 10p, 1 2p, 1 1p", finalResult);
    }
}
