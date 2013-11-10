import java.io.*;
import java.lang.Math.*;
import java.util.*;

public class LZW {

	public static String toBinary(int n,int wordSize) {
		int i;
		String res = "";
		for(i=0;i<wordSize;i++)
		{
			res = res + String.valueOf(n % 2);
			n = n/2;

		}
		return new StringBuilder(res).reverse().toString();
	}
	
	public static String readFile(String filename){
		String inputStr="";
		String currentLine;
		BufferedReader br=null;
		try{
			br=new BufferedReader(new FileReader(filename));
			while((currentLine=br.readLine())!=null){
				inputStr=inputStr+currentLine;
			}
		} catch (IOException e) {
			System.out.println("Error in file reading!");
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Error closing!");
			}
		}
		return inputStr;
	}

	public static void main(String[] args) throws IOException {
		List dictionary = new ArrayList();
		String input = "";
		String output = "";
		String buffer;
		int wordSize;
		int i,j;
		
		input = readFile(args[0]);
		
		for(i=0;i<26;i++)
			dictionary.add(String.valueOf((char)(i+65)));
		
		i=0;
		//System.out.println(input.length());
		while(i<input.length()) {
			wordSize =(int) Math.ceil( Math.log(dictionary.size()) / Math.log(2)) ;
			j = i;
			buffer = "";

			while(j<input.length()) {
				//System.out.println("hey"+j);
				if(!dictionary.contains(buffer + input.charAt(j)))
					break;
				buffer = buffer + input.charAt(j);
				j =j +1;
			}

			if(j>=input.length())
				break;
			
			//System.out.print(dictionary.indexOf(buffer)+1);
			//System.out.print(' ');
			//System.out.println(buffer + input.charAt(j));
			output += toBinary(dictionary.indexOf(buffer),wordSize);
			//System.out.println(toBinary(dictionary.indexOf(buffer) +1,wordSize));
			dictionary.add(buffer + input.charAt(j));

			i = j;

		}
		System.out.println(output);
	}
}