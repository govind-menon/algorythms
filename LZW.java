import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) throws IOException {
		List dictionary = new ArrayList();
		String input = "";
		String output = "";
		String buffer;
		int wordSize;
		int i,j,k=1;
		
		dictionary.add("#");
		
		input = FileReader.readFile(args[0]);
		
		for(i=0;i<26;i++)
			dictionary.add(String.valueOf((char)(i+65)));

		i=0;
		
		while(i<input.length()) {
			wordSize =(int) Math.ceil( Math.log(dictionary.size()) / Math.log(2)) ;
			j = i;
			buffer = "";

			while(j<input.length()) {
		
				if(!dictionary.contains(buffer + input.charAt(j)))
					break;
				buffer = buffer + input.charAt(j);
				j =j +1;
			}

			output += toBinary(dictionary.indexOf(buffer),wordSize);
			if (j<input.length())
				dictionary.add(buffer + input.charAt(j));
			i = j;

		}
		
		int inputLength = input.length();
		
		int inputSymbolSize = (int) Math.ceil( Math.log(26) / Math.log(2));

		int inputSize = inputSymbolSize*inputLength;

		System.out.println("Unencoded length = " + inputLength + " * " + inputSymbolSize + " = " + inputSize );
		
		System.out.println("Encoded length = " + output.length());
		
		System.out.println("Percentage compression achieved = " + ((inputSize - output.length())*1.0 / inputSize) *100 );

		System.out.println(output);
			
	}
}