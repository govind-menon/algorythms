public class AlgoRhythms {
    public static void main(String[] args) {
    	long executionTime;
        String input = FileReader.readFile(args[0]);
        Huffman huffman = new Huffman();
        Wordiness wordiness = new Wordiness();
        executionTime = System.currentTimeMillis();
        String huffmanCompression = huffman.compress(input);
        executionTime = System.currentTimeMillis() - executionTime;
        System.out.println("Huffman");
        System.out.println("_________________");
        compressionPercentage(input, huffmanCompression);
        System.out.println("Execution Time: " + executionTime);

        LZW lzw = new LZW();
        executionTime = System.currentTimeMillis();
        String lzwCompression = lzw.compress(input);
        executionTime = System.currentTimeMillis() - executionTime;
        System.out.println("LZW");
        System.out.println("_________________");
        //System.out.println(lzw.decompress(lzwCompression));
        compressionPercentage(input, lzwCompression);
        System.out.println("Execution Time: " + executionTime);
        System.out.println("Wordiness Parameter: " + wordiness.calculateWordinessParameter(input));
    }

    private static void compressionPercentage(String input, String output) {
        long inputLength = input.length();

        long inputSymbolSize = (long) Math.ceil( Math.log(256) / Math.log(2));

        long inputSize = inputSymbolSize*inputLength;

        System.out.println("Unencoded length = " + inputLength + " * " + inputSymbolSize + " = " + inputSize );

        System.out.println("Encoded length = " + output.length());

        System.out.println("Percentage compression achieved = " + ((inputSize - output.length())*1.0 / inputSize) *100 );
    }

}
