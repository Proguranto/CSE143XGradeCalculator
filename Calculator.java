// Grant Tannert
// Calculator is a percentage calculator or gpa estimate for the CSE 143X Class
// at the University of Washington. It involves a fun interaction with some GUI
// aspects of Java. I hope you enjoy playing around with this program :)

import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        introduction();

        Scanner input = new Scanner(System.in);
        double sum = 0;
        for (int i = 1; i <= 10; i++) {
            if (i == 1) {
                System.out.print("a" + i + "(out of 10): ");
            } else if (i == 10) {
                System.out.print("a" + i + "(out of 30): ");
            } else {
                System.out.print("a" + i + "(out of 20): ");
            }
            sum += input.nextInt();
        }

        System.out.println();
        System.out.print("midterm: ");
        sum += input.nextInt();
        System.out.print("final(don't add the extra credit): ");
        sum += input.nextInt();
        System.out.println();
        System.out.print("bonus points: ");
        sum += input.nextDouble();
        System.out.println();
        double n = (sum / 230) * 100;
        System.out.printf("result (percentage): %.2f", n);
        gpa(n);
        input.close();
    }

    // plays introduction
    public static void introduction() {
        System.out.println("Welcome to CSE143X calculator, please input the following assignments:");
        System.out.println();
    }

    // prints out your estimated gpa + GUI interaction
    public static void gpa(double n) {
        if (n > 90) {
            // outputs a gui interactive program
            Mouse mouse = new Mouse("GoodJob.gif", "Wow.. ~3.5 ++");
        } else if (n > 80) {
            Mouse mouse = new Mouse("NotTooShabby.jpg", "Pretty Good ay.. ~2.5 ++");
        } else if (n > 70){
            Mouse mouse = new Mouse("Believe.jpg", "Don't Give up.. ~1.5 ++");
        } else {
            Mouse mouse = new Mouse("NotOver.gif", "There's still hope..");
        }
    }
}