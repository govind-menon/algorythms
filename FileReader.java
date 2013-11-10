import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {

    public static String readFile(String filename){
        String inputStr="";
        String currentLine;
        BufferedReader br=null;
        try{
            br=new BufferedReader(new java.io.FileReader(filename));
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
}
