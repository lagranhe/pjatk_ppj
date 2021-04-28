import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class S23989Set04 {

    public static void main(String[] args) {
        S23989Set04 s = new S23989Set04();
        s.task01();
        s.task02();
        s.task03();
        s.task04();
        s.task05();
        s.task06();
        s.task07();
        s.task08();
        s.task09();
        s.task10();
    }

    public void task01(){
        System.out.println(24);
    }

    public void task02(){
        double a = 1;
        double x = 0;
        if (a >= 0) x = 1.701;
        if (a < 0) x = 2D*3.14f;
        System.out.println(x);
    }

    public void task03(){
        int zmInt = 4 ;
        double zmDouble = -1.0;
        if ( zmInt > 0 ) {
            if ( zmDouble > 0 )
                System . out . println ( " Here I am!" ) ;
        } else {
            System . out . println ( "No , I am here !" ) ;
        }
        System . out . println ( "No , actually , I am here !" ) ;
    }

    public void task04(){
        boolean doesSignificantWork = true;
        boolean makesBreakthrough = true;
        boolean nobelPrizeCandidate = true;

//        if ( doesSignificantWork ) {
//            if ( makesBreakthrough )
//                nobelPrizeCandidate = true ;
//            else
//                nobelPrizeCandidate = false ;
//        }
//        else if ( ! doesSignificantWork )
//            nobelPrizeCandidate = false ;
        nobelPrizeCandidate = (doesSignificantWork) ? ((makesBreakthrough) ? true : false) : false;
    }

    public void task05(){
        int a = 1;
        int b = 2;
//        ( ! ( a < b ) && ! ( a > b ) ) equals ->  a == b;
        if (a == b);
    }

    public void task06(){
        int a = 1;
        int b = 2;
        int c = 3;
        System.out.println((a == b && b == c) ? "są takie same" : "nie są takie same");
    }

    public void task07(){
        Scanner sc = new Scanner(System.in);
        String M = sc.nextLine();
        String D = sc.nextLine();
        int day = parseInt(D);
        switch (M) {
            case ("1"):
                System.out.println("Zima");
                break;
            case ("2"):
                System.out.println("Zima");
                break;
            case ("3"):
                if (day < 21) {
                    System.out.println("Zima");
                } else {
                    System.out.printf("Wiosna");
                }
                break;
            case ("4"):
                System.out.println("Wiosna");
                break;
            case ("5"):
                System.out.println("Wiosna");
                break;
            case ("6"):
                if (day < 21) {
                    System.out.println("Wiosna");
                } else {
                    System.out.println("Lato");
                }
                break;
            case ("7"):
                System.out.println("Lato");
                break;
            case ("8"):
                System.out.println("Lato");
                break;
            case ("9"):
                if (day < 23) {
                    System.out.println("Lato");
                } else {
                    System.out.println("Jesień");
                }
                break;
            case ("10"):
                System.out.println("Jesień");
                break;
            case ("11"):
                System.out.println("Jesień");
                break;
            case ("12"):
                if (day < 22) {
                    System.out.println("Jesień");
                } else {
                    System.out.println("Zima");
                }
                break;
        }
    }

    public void task08(){
        int a = 10;
        System.out.println(a >= 0);
        System.out.println(a <= 1);
        System.out.println(a >= 0 && a <= 1);
    }

    public void task09(){
        int wrt = -4;
        System.out.println(((wrt > -15 && wrt <= -10) || (wrt > -5 && wrt < 0) || (wrt > 5 && wrt < 10)) &&
                ((wrt <= -13) || (wrt > -8 && wrt <= -3)) &&
                (wrt >= -4));
    }

    public void task10(){
        int wrt = 10;
        boolean a = (wrt > -15 && wrt < -10) ? true : false;
        boolean b = (wrt < -13) ? true : false;
        boolean c = ((a && b) || (!a && !b))  ? false : true;
        System.out.println(c);
    }
}
