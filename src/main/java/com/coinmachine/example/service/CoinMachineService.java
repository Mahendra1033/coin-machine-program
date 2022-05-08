package com.coinmachine.example.service;

import com.coinmachine.example.exception.InvalidCurrencyException;
import com.coinmachine.example.repository.CoinMachineRepository;

public class CoinMachineService {

    public static String getResult(String input) {
        int coins[] = CoinMachineRepository.getCurrencies();
        String given = input;
        System.out.println("Given Total : " + given);
        int count = 0;
        String result = "";
        String forResult = "";
        String finalResult = "";
        String regex = "[+-]?([0-9]*[.])?[0-9]+";

        if (input.contains("£") || input.matches(regex)) {
            int value = 0;
            if (input.contains("£")) {
                String arrays[] = input.split("£");
                if (arrays.length == 2) {
                    value = Integer.parseInt(Integer.parseInt(arrays[1]) + "00");
                } else {
                    value = Integer.parseInt(Integer.parseInt(arrays[0]) + "00");
                }
            } else if (input.contains(".")) {
                value = Integer.parseInt(input.replace(".", ""));
            } else {
                value = Integer.parseInt(input);
            }

            for (int i = 0; i < coins.length; i++) {
                count = value / coins[i];
                if (count != 0) {
                    if (coins[i] == 200) {
                        result = result + count + " " + "£2" + ", ";
                    } else if (coins[i] == 100) {
                        result = result + count + " " + "£1" + ", ";
                    } else {
                        result = result + count + " " + coins[i] + "p" + ", ";
                    }
                }
                value = value % coins[i];
            }
           finalResult = result.substring(0,result.length()-2);
        } else {
            throw new InvalidCurrencyException("The Entered Currency was not valid !!! Please check it once and try again ... ");
        }

        return finalResult;
    }

}
