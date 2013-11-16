package myclass.sample;

public class BinaryToDecimal {

	public static Integer binaryToDecimal(String inputStr){
		StringBuilder str=new StringBuilder(inputStr);
		StringBuilder strRev = str.reverse();
		int result=0;
		for (int i=0 ; i < strRev.length() ; i++)
		{
			if(strRev.charAt(i)=='1')
			{
				result = result + (int)Math.pow(2,i); 
			}
		}
		return result;
	}
	
}
