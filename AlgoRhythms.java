public class AlgoRhythms {
    public static void main(String[] args) {
        String input = FileReader.readFile(args[0]);
        Huffman huffman = new Huffman();
        String huffmanCompression = huffman.compress(input);
        System.out.println("Huffman");
        System.out.println("_________________");
        compressionPercentage(input, huffmanCompression);

        LZW lzw = new LZW();
        String lzwCompression = lzw.compress(input);
        System.out.println("LZW");
        System.out.println("_________________");
        compressionPercentage(input, lzwCompression);
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
