import java.io.*;
import java.util.*;
import java.text.*;

public class Runner {
	public static void main(String[] args) {
		int i;
		String input,output;
		long executionTime;
		double wordinessParameter;

		Wordiness wordiness = new Wordiness();

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		Date date = new Date();;
		String suffix = dateFormat.format(date).toString()+".csv";
		
		Huffman huffman = new Huffman();
		LZW lzw = new LZW();
		File dir = new File(args[0]);
		File[] files = dir.listFiles();
		
		for(i=0;i<files.length;i++) {
			
			System.out.println(files[i].getAbsolutePath());
			input = FileReader.readFile(files[i].getAbsolutePath());
			wordinessParameter = wordiness.calculateWordinessParameter(input);

			executionTime = System.currentTimeMillis();
			output = huffman.compress(input);
			executionTime = System.currentTimeMillis() - executionTime;
			compressionPercentage(input,output,"huffman-" + suffix,executionTime,wordinessParameter);

			executionTime = System.currentTimeMillis();
			output = lzw.compress(input);
			executionTime = System.currentTimeMillis() - executionTime;
			compressionPercentage(input,output,"lzw-" + suffix,executionTime,wordinessParameter);
			
		}
		
	}

	private static void compressionPercentage(String input, String output,String fileName,long executionTime,double wordinessParameter) {
		long inputLength = input.length();

		long inputSymbolSize = (long) Math.ceil( Math.log(256) / Math.log(2));

		long inputSize = inputSymbolSize*inputLength;

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
			out.print(inputSize + "," );
			out.print(output.length()+",");
			out.print(executionTime+","); 
			out.print(wordinessParameter+","); 
			out.println(((inputSize - output.length())*1.0 / inputSize) *100 );

			System.out.print(inputSize + "," );
			System.out.print(output.length()+",");
			System.out.print(executionTime+","); 
			System.out.print(wordinessParameter+","); 
			System.out.println(((inputSize - output.length())*1.0 / inputSize) *100 );
				
			out.close();
		} catch (IOException e) {
		}

		
	}
}