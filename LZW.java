import java.io.*;
import java.util.*;
public class LZW {

	public static void main(String[] args) throws IOException {
		List dictionary = new ArrayList();
		int i,j;
		String input = "TOBEORNOTTOBEORTOBEORNOT";
		String buffer;

		for(i=0;i<26;i++)
			dictionary.add(String.valueOf((char)(i+65)));
		
		i=0;
		//System.out.println(input.length());
		while(i<input.length()) {
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
			
			System.out.print(dictionary.indexOf(buffer)+1);
			System.out.print(' ');
			System.out.println(buffer + input.charAt(j));

			dictionary.add(buffer + input.charAt(j));

			i = j;

		}
	}
}