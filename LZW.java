import java.util.ArrayList;
import java.util.List;

public class LZW {

    private List dictionary;

    public LZW(){
        this.dictionary = new ArrayList();
        this.dictionary.add("#");

        for(int i=0;i<256;i++)
            this.dictionary.add(String.valueOf((char)(i)));
    }

    private String toBinary(long n,long wordSize) {
		long i;
		String res = "";
		for(i=0;i<wordSize;i++)
		{
			res = res + String.valueOf(n % 2);
			n = n/2;

		}
		return new StringBuilder(res).reverse().toString();
	}

    public String compress(String input) {
		String output = "", buffer;
		long i=0,j, wordSize;

		while(i<input.length()) {
			wordSize =(long) Math.ceil( Math.log(dictionary.size()) / Math.log(2)) ;
			j = i;
			buffer = "";

			while(j<input.length()) {
		
				if(!dictionary.contains(buffer + input.charAt((int)j)))
					break;
				buffer = buffer + input.charAt((int)j);
				j =j +1;
			}

			output += toBinary(dictionary.indexOf(buffer),wordSize);
			if (j<input.length())
				dictionary.add(buffer + input.charAt((int)j));
			i = j;

		}
		return output;
			
	}

}