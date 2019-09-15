/**
 * The Launcher class will scan and parse through the auth.log file passed by args[0]. This class will call upon the RegExProject1 class where
 * various IP addresses and usernames from the auth.log file are parsed and stores both of those data points
 * in a hashmap. The class will print off the default information of how many total lines, number of IP address and usernames if arg[1] is 0.
 * The IP addresses and how offten they appear will print out if arg[1] is 1, and the usernames with how often those appear if arg[1] is  2.
 * @author Chad Critchelow
 * @version 1.0
 * Programming Project One
 * CS322 - Compiler Construction
 * Spring 2019
 */

import java.io.File;//imported java classes for reading the auth.log file and error exceptions for try/catch
import java.io.IOException;
import java.util.Scanner;

public class Launcher{//Launcher class which contain the main method

        public static void main(String[] args){//start of the main method
       
                int Linetracker = 0;//variable to keep a count of the auth.log lines

                RegExProject1 findPatterns = new RegExProject1();
                try { //beginning of try/catch
                
                        Scanner scan = new Scanner(new File(args[0]));//creating new scanner object from Scanner class
                       
			 while(scan.hasNextLine()){//beginning while loop until the all lines are scanned
                                findPatterns.RegularExpMatch(scan.nextLine());//looking for the pattern at each line of the auth.log
                                Linetracker++;
                 }
                        scan.close();//closing scaner.
                 }
                catch(IOException e){//catching possible exception(s) with the file reading process
                
                                      e.printStackTrace();//trace of file parse error
                 }//ending of try/catch
       
                        if(args[1].equals("1")){//outputs the IP addresses from the auth.log file and how many there are.
                
                        findPatterns.getIPaddressHMAP().forEach((k,v)->System.out.println(k + ":  " + v));
                        System.out.println();//above outputs when arg[1] is 1.
                }
                	if(args[1].equals("2")){//outputs the usernames from the auth.log file and how many there are.
                
                        findPatterns.getUsernameHMAP().forEach((k,v)->System.out.println( k + ":  " + v));
                        System.out.println();//above outputs when arg[1] is 2.
                }
                
               		System.out.println(Linetracker + " lines in the log file were parsed.");//outputs the default data when arg[1] isn't 1 or 2.
                	System.out.println("There are " + findPatterns.getIPaddressHMAP().size() + " unique IP addresses in the log.");
               		System.out.println("There are " + findPatterns.getUsernameHMAP().size() + " unique users in the log.");

                }// closing of the Main method
 
                }// closing of the Launcher class



