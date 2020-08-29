package com.bilgeadam.java.tutorials.program_flow.decision_operators;

public class LoopControl {

    public static void main(String[] args) {
        int varTwo = 0;

        ContinueScenario(varTwo);

        BreakScenario(varTwo);
    }

    // Break scenario
    private static void BreakScenario(int varTwo) {
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);

            if (i >= 4) {
                continue;
            }

            for (int j = 0; j < i; j++) {
                System.out.println("j = " + j);
                if (j > 1) {
                    break;
                }
            }

            varTwo +=i;
            System.out.println("varTwo = " + varTwo);
        }
    }

    // Continue example
    private static void ContinueScenario(int varTwo) {
        while (varTwo < 8){
            System.out.println("varTwo = " + varTwo);

            varTwo++;
            if (varTwo == 1){
                varTwo += 2;
                continue;
            }
        }
    }
}
