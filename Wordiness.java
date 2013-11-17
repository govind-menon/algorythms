import java.util.ArrayList;
import java.util.List;

public class Wordiness {

	private String toBinary(long n,long wordSize) {
		String res = Integer.toBinaryString((int)n),buffer = "";
		return String.format("%"+ (int)(wordSize) + "s",res).replace(' ','0');
	}

	public double calculateWordinessParameter(String input) {
		List dictionary = new ArrayList();
		List wordCount = new ArrayList();
		String output = "", buffer;
		long i=0,j, wordSize,k,q,total=0,usedWordsCount;

		for(k=0;k<256;k++) {
            dictionary.add(String.valueOf((char)(k)));
            wordCount.add(0);
		}

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
			if(buffer != "")
			wordCount.set(dictionary.indexOf(buffer),(int)wordCount.get(dictionary.indexOf(buffer))+1);			
			if (j<input.length()) {
				dictionary.add(buffer + input.charAt((int)j));
				wordCount.add(0);
			}
			i = j;

		}
		usedWordsCount = 0;
		//System.out.println(wordCount.size());
		for(k=0;k<wordCount.size();k++) {
			q = (int)wordCount.get((int)k);
			if (q>0) {
			total+= q*(((String)dictionary.get((int)k)).length());
			usedWordsCount++;
		}
		}
		return (total*1.0)/k;
	}
}	
