///////////////////////// TOP OF FILE COMMENT BLOCK //////////////////////////// 
//
// Title:           Converts text to other formats
// Course:          200, Spring, 2020
//
// Author:          Sam Radtke
// Email:           sdradtke@wisc.edu
// Lecturer's Name: Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////
import java.util.Scanner;
public class TextConverter {
    /**
     * 1337 - convert the string to leet-speak:
     *   Replace each L or l with a 1 (numeral one)
     *   Replace each E or e with a 3 (numeral three)
     *   Replace each T or t with a 7 (numeral seven)
     *   Replace each O or o with a 0 (numeral zero)
     *   Replace each S or s with a $ (dollar sign)
     *    
     * @param current Original string
     * @return string converted to leet-speak.
     */
    public static String action1337(String current) {
        int i;
        String result = "";
        for(i = 0; i < current.length(); i++) {
            if(current.charAt(i) == 'L' || current.charAt(i) == 'l' ) {
                result += "1";
            }
            else if(current.charAt(i) == 'E' || current.charAt(i) == 'e') {
                result += "3";
            }
            else if (current.charAt(i) == 'T' || current.charAt(i) == 't') {
                result += "7";
            }
            else if (current.charAt(i) == 'O' || current.charAt(i) == 'o') {
                result += "0";
            }
            else if (current.charAt(i) == 'S' || current.charAt(i) == 's') {
                result += "$";
            }
            else {
                result += current.charAt(i);
            }
        }
        
        return result;  //FIX ME
    }

    /**
     *  tests action1337 method with various cases to ensure it is working
     *  correctly.
     */
    public static void testAction1337() {
        boolean error = false;

        String input1 = "LEeTs";
        String expected1 = "1337$";
        String result1 = action1337(input1);
        if ( !result1.equals( expected1)) {
            error = true;
            System.out.println("1) testAction1337 with input " + input1 + ", expected: " + expected1 + " but result:" + result1);
        }
        
        String input2 = "";
        String expected2 = "";
        String result2 = action1337(input2);
        if ( !result2.equals( expected2)) {
            error = true;
            System.out.println("1) testAction1337 with input " + input2 + ", expected: " + expected2 + " but result:" + result2);
        }
        
        String input3 = "Sam Radtke";
        String expected3 = "$am Rad7k3";
        String result3 = action1337(input3);
        if ( !result3.equals( expected3)) {
            error = true;
            System.out.println("1) testAction1337 with input " + input3 + ", expected: " + expected3 + " but result:" + result3);
        }
        
        

        //FIX ME
        //add at least 2 other test cases. What edge cases can you think of?


        if ( error) {
            System.out.println( "testAction1337 failed");
        } else {
            System.out.println("testAction1337 passed");
        }
    }



    /**
     * This reverses the order of characters in the current string. 
     * @param current  Original string to be reversed.
     * @return  The string in reversed order.
     */
    public static String actionReverse(String current) {
        int i;
        String result = "";
        for(i = current.length() - 1; i >= 0; i--) {
            result += current.charAt(i);
        }
        
        return result;  //FIX ME
    }

    /**
     *  tests actionReverse method with various cases to ensure it is working
     *  correctly. 
     */
    public static void testActionReverse() {
        boolean error = false;

        String input1 = "Abc";
        String expected1 = "cbA";
        String result1 = actionReverse( input1);
        if ( !result1.equals( expected1)) {
            error = true;
            System.out.println("1) testActionReverse with input " + input1 + ", expected: " + expected1 + " but result:" + result1);
        }
        
        String input2 = "";
        String expected2 = "";
        String result2 = actionReverse(input2);
        if ( !result2.equals( expected2)) {
            error = true;
            System.out.println("2) testActionReverse with input " + input2 + ", expected: " + expected2 + " but result:" + result2);
        }
        
        String input3 = " 6 a";
        String expected3 = "a 6 ";
        String result3 = actionReverse(input3);
        if ( !result3.equals( expected3)) {
            error = true;
            System.out.println("3) testActionReverse with input " + input3 + ", expected: " + expected3 + " but result:" + result3);
        }
        


        if ( error) {
            System.out.println( "testActionReverse failed");
        } else {
            System.out.println("testActionReverse passed");
        }
    }   

    /**
     * Provides the main menu for the text converter and calls methods based
     * on menu options chosen.
     * @param args
     */
    public static void main(String[] args) {
       
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to the Text Converter.");
        System.out.println("Available Actions:");
        System.out.println("  1337) convert to 1337-speak");
        System.out.println("  rev) reverse the string");
        System.out.println("  quit) exit the program");
        System.out.println();
        System.out.print("Please enter a string: ");
        String start = scnr.nextLine();
        
        String action = "";
        while(true) {
            System.out.print("Action (1337, rev, quit): ");
            action = scnr.nextLine();
            if(action.equals("quit")) {
                System.out.println("See you next time!");
                break;
            }
            else if(action.equals("1337")) {
                start = action1337(start);
            }
            else if(action.equals("rev")) {
                start = actionReverse(start);
            }
            else {
                System.out.println("Unrecognized action.");
            }
            System.out.println(start);
        
        } 
              //  testAction1337();   //uncomment to run the tests
              // testActionReverse();  //uncomment to run the tests

               //FIX ME
        scnr.close();
    }

}
