public class AlgoRhythms {
    public static void main(String[] args) {
        String input = FileReader.readFile(args[0]);
        Huffman huffman = new Huffman();
        LZW lzw = new LZW();
        String huffmanCompression = huffman.compress(input);
        String lzwCompression = lzw.compress(input);
       // System.out.println("The compressed String after applying huffman is: " + huffmanCompression);
    }
}
