package com.coinmachine.example.controller;

import com.coinmachine.example.service.CoinMachineService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinMachineController {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("Enter the input : ");
        String input = bufferedReader.readLine();
        System.out.println("Final Result is : "+CoinMachineService.getResult(input));
    }
}
