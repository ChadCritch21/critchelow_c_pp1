import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

	public class RegExProject1{	
	
		public static void main(String args[]) throws IOException 
		{
		
		try{

		File f = new File("C:/Users/chadc/Desktop/auth.txt");
		
	    	BufferedReader b = new BufferedReader(new FileReader(f));

		String readLine = "";	
		
		 while ((readLine = b.readLine()) != null){

		 System.out.println("Hey");
		 }
			b.close();
		}catch (IOException e){
		e.printStackTrace();
         
	         	}
        	 }		
	}
	

