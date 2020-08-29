package com.bilgeadam.java.tutorials.program_flow.decision_operators;

public class SwitchDecision {

    public static void main(String[] args) {

        IfElseScenarioWithoutSwitch();

        SwitchScenarioTwo();
    }

    // This example case is better without Switch case.
    private static void IfElseScenarioWithoutSwitch() {
        int x = (int) (Math.random()*100);

        System.out.println("x = " + x);

        if (x < 25)
            System.out.println("Unlikely");
        else if (x < 50)
            System.out.println("Maybe");
        else if (x < 75)
            System.out.println("Possible");
        else
            System.out.println("Guaranteed");
    }

    // This scenario works better with switch case.
    private static void SwitchScenarioTwo() {
        int month = (int) (Math.random() * 11) + 1;
        System.out.println("month = " + month);
        String monthVal;
        switch (month){
            case 1:
                monthVal = "Ocak";
                //break;    //Without break, switch will continue to parse remaining code.
            case 2:
                monthVal = "Subat";
                System.out.println("monthVal = " + monthVal);
                //break;
            case 3:
                monthVal = "Mart";
                //break;
            case 4:
                monthVal = "Nisan";
                break;
            case 5:
                monthVal = "Mayıs";
                System.out.println("monthVal = " + monthVal);
                //break;
            case 6:
                monthVal = "Haziran";
                //break;
            case 7:
                monthVal = "Temmuz";
                break;
            case 8:
                monthVal = "Agustos";
                //break;
            case 9:
                monthVal = "Eylül";
                System.out.println("monthVal = " + monthVal);
                //break;
            case 10:
            case 11:
            case 12:
                monthVal = "Bilinmiyor";
                break;
            default:
                monthVal = "HATALI";
                break;
        }
        System.out.println("monthVal = " + monthVal);
    }


}
