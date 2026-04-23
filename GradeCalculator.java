/**
 * This program will ask user if they are going on a trip.
 * The program will continue until user exits program.
 * 
 * The program will ask for number of gallons of car,
 * number of miles per trip, and constant speed that can change
 * per trip.
 * 
 * Upon exiting, the program will give user the total miles,
 * average speed, total time, and if they have enough gas.
 *
 * @author Jose Gonzalez
 * @version 11/02/25
 */

import java.util.Scanner;

//the declared class GradeCalculator
public class GradeCalculator 
{
    /* need to declare number grade variable (input) and letter grade variable (for output), 
    avg, sum and a counter(for calculating to average) all set as protected for encapsulation. */
    protected int numGrade = 0;
    protected char letterGrade = '-'; // "-" is set for invalid char
    protected int avgGrade;
    protected int sumGrade;
    protected int count = 0;

    //create Scanner for user input
    Scanner scnr = new Scanner(System.in);

    /* create method to get input and calculate grade called....
    calcNumberGrade! */
    public void numberGrade()
    {
        //try catch block to catch invalid data types
        while (numGrade >= 0)
        {
            try
            {
                System.out.print("Please input grade as number (0 - 100) To quit, input number below 0: ");
                numGrade = scnr.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Not valid.");
                scnr.nextLine();
                continue;
            }
            letterGrade = '-';
            

            //grade is A
            if ((numGrade >= 90) && (numGrade <= 100))
            {
                letterGrade = 'A';
            }
            //grade is B
            else if ((numGrade >= 80) && (numGrade < 90))
            {
                letterGrade = 'B';
            }
            //grade is C
            else if ((numGrade >= 70) && (numGrade < 80))
            {
                letterGrade = 'C';
            }
            //grade is D
            else if ((numGrade >= 60) && (numGrade < 70))
            {
                letterGrade = 'D';
            }
            //grade is F
            else if ((numGrade >= 0) && (numGrade < 60))
            {
                letterGrade = 'F';
            }
            //if input is not valid, sets letterGrade to - to prevent entering if statement below
            else if (numGrade > 100)
            {
                System.out.println("Cannot be over 100. Try again.");
                letterGrade = '-';
            }
            //give feedback that program is ending
            else if (numGrade < 0)
            {
                System.out.println("Exiting...");
                letterGrade = '-';
                break;
            }

            /* if valid, calls method calcSumGrade() to add numGrade to sumGrade, increment 
            count to be used for calculating average, and print letterGrade */
            if (letterGrade != '-')
            {
                calcSumGrade(numGrade);
                count += 1;
                System.out.println("Your grade is a " + letterGrade);
            }
        }
        //close scanner
        scnr.close();
    }

    //add grades together for sum
    public void calcSumGrade(int n)
    {
        sumGrade += n;
    }

    //calculate and print the average, if no input is entered or sumGrade is less than zero, it will not output anything
    public void calcAverageGrade()
    {
        if (count > 0)
        {
            avgGrade = sumGrade / count;
            System.out.println("Your average of " + count + " grade(s) is: " + avgGrade);
        }
    }

    //main method
    public static void main(String[] args) 
    {
        //create object
        GradeCalculator obj1 = new GradeCalculator();

        //user inputs grade numbers
        obj1.numberGrade();

        //calculate the average grade, if zero, nothing happens and program continues
        obj1.calcAverageGrade();

    }
}
