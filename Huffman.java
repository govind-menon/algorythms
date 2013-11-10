import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
    private Map<Character, Integer> frequencyTable;
    private PriorityQueue<Node> queue;
    private Tree huffmanTree;

    public Huffman(){
        this.frequencyTable = new HashMap<Character, Integer>();
        this.queue = new PriorityQueue<Node>(255, new FrequencyComparator());
        this.huffmanTree = new Tree();
    }

    public String compress(String input) {
        createFrequencyTable(input);
        initializePriorityQueue();
        createHuffmanTree();
        return compressInput(input);
    }

    private String compressInput(String input) {
        String compressedString = "";
        for(Character key:input.toCharArray()){
            compressedString += huffmanTree.compressedTable.get(Character.toString(key));
        }
        return compressedString;
    }

    private void createHuffmanTree() {
        while (queue.size() > 1) {
            Node newNode = huffmanTree.insert(queue.remove(), queue.remove());
            queue.add(newNode);
        }
        huffmanTree.createCompressedTable(huffmanTree.head, "");
    }

    private void initializePriorityQueue() {
        for (Character key : frequencyTable.keySet())
            queue.add(new Node(Character.toString(key), frequencyTable.get(key)));
    }

    private void createFrequencyTable(String input) {
        for (Character i : input.toCharArray()) {
            Integer value = frequencyTable.get(i);
            if (value == null) frequencyTable.put(i, 1);
            else frequencyTable.put(i, value + 1);
        }
    }
}
