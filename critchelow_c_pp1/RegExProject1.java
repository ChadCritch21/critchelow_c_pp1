/**
 * The class RegExProject1 will parse through the auth.log file passed by the first element in args[] (args[0]). Then, the class will execute into the 
 * RegularExpMatch class to store thexIP addresses and usernames read from the auth.log file into thier respected hash maps for either IP addresses
 * usernames. The print flag used for arg[1] will determine the actual output of the program. Seee the class description header for me details on what
 * each print flag will display.
 * @author Chad Critchelow
 * @version 1.0
 * Programming Project One
 * CS322 - Compiler Construction
 * Spring 2019
 */

import java.util.regex.*;//java imported class for using regular expressions
import java.util.HashMap;//java imported class for using hashmaps

public class RegExProject1 {//RegExProject1 class being called from Launcher class. No main method here

	private HashMap<String, Integer> IPaddressHMAP = new HashMap<>();//hashmap object to capture IP Addresses as keys and values for how many appear
	private HashMap<String, Integer> UsernameHMAP = new HashMap<>();//hashmap object to capture uernames as keys and values for how many appear

	public HashMap<String, Integer> getIPaddressHMAP() {//getting the IP address hashmap to then return the populated hashmap IPaddressHMAP
		return IPaddressHMAP;
	}

	public HashMap<String, Integer> getUsernameHMAP() {//getting the usernames hashmap to then return the populated hashmap UsernameHMAP 
		return UsernameHMAP;
	}

	public int getIPaddressHMAPSize() {//getting the size of the IPaddressHMAP as an int for the number of entries
		return IPaddressHMAP.size();
	}

	public int getUsernameHMAPSize() {//getting the size of the UsernameHMAP as an int for the number of entries
		return UsernameHMAP.size();
	}

	public void RegularExpMatch(String input) {//method for takig the auth.log file and trying to match each line with the regular expressions listed below

	    //regular expression pattern to look for valid IP address within the auth.log
	    Matcher IPaddressRegEx = Pattern.compile("([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5]\\d)").matcher(input); //pattern for IP addresses
	  
	    //regular expression pattern to look for usernames within the auth.log
	    Matcher UsernameRegEx = Pattern.compile("user\\s\\w+").matcher(input);

	    while(IPaddressRegEx.find()) {//starting while loop to look for matching IP Addresses in the auth.log
	    	String IPmatchFound = IPaddressRegEx.group();
	    	if(IPaddressHMAP.containsKey(IPmatchFound)) {//if an IP Address matches and already has a created key, add 1 to its respected value 
          		IPaddressHMAP.put(IPmatchFound, IPaddressHMAP.get(IPmatchFound) + 1);//adding 1 to the value of the key
	    	} else {
	    		IPaddressHMAP.put(IPmatchFound, 1);//if an IP Address is a new match, set its value to one and have a new key stored for that IP Address
	    	}
	        }//end of IP Address mathcing while loop


	    while(UsernameRegEx.find()) {//starting while loop to look for matching usernames in the auth.loh
	    	String UsermatchFound = UsernameRegEx.group();//capturing the matched input sequence of the regex
		String usernameSub = UsermatchFound.substring(5);//substring of the matched username if found in the auth.log

	    	if(UsernameHMAP.containsKey(usernameSub)){//if a username matches and already has a created key, add 1 to its respected value
	    		UsernameHMAP.put(usernameSub, UsernameHMAP.get(usernameSub) + 1);//adding 1 to value of the key
	    	} else {
	    		UsernameHMAP.put(usernameSub, 1);//if a username is a new match, set its value to one and have a new key stored for that IP Address
	    	}
	        }//end of username matching while loop

	}//ending RegularExpMatch

}//ending RegExProject1 



