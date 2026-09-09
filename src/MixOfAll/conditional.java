package MixOfAll;

import java.util.Scanner;

public class conditional {
    public static void main(String[] Args) {
        /*boolean isSunny = true;
        boolean isRaining = false;
        if(isSunny&&isRaining) {
            System.out.println("Maze karo");
        }else {
            System.out.println("ghar me baitho");

        }
    }
} */    // use of switch and break case reduce use of else if block 
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        String dayname;
        switch (day) {
            case 1:
                dayname = "Monday";
                break;
            case 2:
                dayname = "tuseday";
                break;
            case 3:
                dayname = "wednesday";
                break;
            case 4:
                dayname = "Thursday";
                break;
            case 5:
                dayname = "Friday";
                break;
            case 6:
                dayname = "Saturday";
                break;
            case 7:
                dayname = "Sunday";
                break;
            default:
                dayname = "Invalid day";
        }
        System.out.println(dayname);

    }
}