import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
    public static void main(String[] args) {
        String input = "ssassadassa";
        Map<Character, Integer> frequencyTable = new HashMap<Character, Integer>();

        for (Character i : input.toCharArray()) {
            Integer value = frequencyTable.get(i);
            if (value == null) frequencyTable.put(i, 1);
            else frequencyTable.put(i, value + 1);
        }


        PriorityQueue<Node> queue = new PriorityQueue<Node>(255, new FrequencyComparator());
        for (Character key : frequencyTable.keySet())
            queue.add(new Node(Character.toString(key), frequencyTable.get(key)));

        Tree huffmanTree = new Tree();
        while (queue.size() > 1) {
            Node newNode = huffmanTree.insert(queue.remove(), queue.remove());
            queue.add(newNode);
        }

        huffmanTree.createCompressedTable(huffmanTree.head, "");
        System.out.println(huffmanTree.compressedTable.toString());
    }
}
