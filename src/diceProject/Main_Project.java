package diceProject;

import java.util.Random;
import java.util.Scanner;

public class Main_Project {
    public static void main(String[] args) {
        dice();
    }


    public static void dice() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rounds;

        while (true) {
            System.out.print("Enter Number of Rounds (1-99): ");
            rounds = scanner.nextInt();
            if (rounds >= 1 && rounds <= 99) {
                break;
            } else {
                System.out.println("Please enter a valid number between 1 and 99.");
            }
        }

        int[] totalPoints = {0, 0, 0};

        System.out.println("+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| ROUND | DICE1 | DICE2 | DICE3 | TOTAL1| TOTAL2| TOTAL3|");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+");

        for (int i = 1; i <= rounds; i++) {
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            int dice3 = random.nextInt(6) + 1;

            if (dice1 == dice2 && dice2 == dice3) {
                totalPoints[0] += dice1;
                totalPoints[1] += dice2;
                totalPoints[2] += dice3;
            } else if (dice1 != dice2 && dice2 != dice3 && dice1 != dice3) {
                totalPoints[0] += dice1;
                totalPoints[1] += dice2;
                totalPoints[2] += dice3;
            } else {
                if (dice1 == dice2 && dice1 > 3) {
                    totalPoints[0] += 2 * dice1;
                    totalPoints[1] += 2 * dice2;
                    totalPoints[2] += dice3;
                } else if (dice1 == dice3 && dice1 > 3) {
                    totalPoints[0] += 2 * dice1;
                    totalPoints[1] += dice2;
                    totalPoints[2] += 2 * dice3;
                } else if (dice2 == dice3 && dice2 > 3) {
                    totalPoints[0] += dice1;
                    totalPoints[1] += 2 * dice2;
                    totalPoints[2] += 2 * dice3;
                }else {
                    totalPoints[0] += dice1;
                    totalPoints[1] += dice2;
                    totalPoints[2] += dice3;
                }
            }

            System.out.printf("|   %d   |   %d   |   %d   |   %d   |   %d   |   %d   |   %d   |\n",
                    i, dice1, dice2, dice3, totalPoints[0], totalPoints[1], totalPoints[2]);
            System.out.println("+-------+-------+-------+-------+-------+-------+-------+");
        }
        scanner.close();
    }


}



