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
		String res = Integer.toBinaryString((int)n),buffer = "";
		return String.format("%"+ (int)(wordSize) + "s",res).replace(' ','0');
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
    
    public String decompress(String inputStr)
	{
		String decompressStr = "";
		
		List<String> dict = new ArrayList<String>();
		dict.add("#");
		
		for(int i=0;i<=255;i++)
			dict.add(String.valueOf((char)(i)));
		
		int inputSize = (int)Math.ceil(Math.log(dict.size())/Math.log(2));
		int j=0,index=0;
		String output1="",output2="",output="",binary="";
				
		while(j < inputStr.length())
		{
			binary = inputStr.substring(j, j + inputSize);
			index = BinaryToDecimal.binaryToDecimal(binary);
			output2 = dict.get(index);
			output = output + output2;
			j = j + inputSize;
			if(!dict.contains(output1+output2)){
				dict.add(output1+output2);
				if(dict.size()>Math.pow(2,inputSize)-1)
					inputSize = inputSize + 1;
			}
			output1 = output2;
		}
		return decompressStr;
	}

}