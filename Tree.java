import java.util.HashMap;
import java.util.Map;

class Tree {
    Node head;
    Map<String, String> compressedTable;

    public Tree() {
        this.head = null;
        this.compressedTable = new HashMap<String, String>();
    }

    public Node insert(Node node1, Node node2) {
        Node newNode = new Node(node1.key + node2.key, node1.frequency + node2.frequency);
        newNode.leftChild = node1;
        newNode.rightChild = node2;
        if (head == null || node1.key.equals(head.key) || node2.key.equals(head.key))
            head = newNode;
        return newNode;
    }


    public void createCompressedTable(Node node, String compressedString) {
        if (node.leftChild == null && node.rightChild == null)
            compressedTable.put(node.key, compressedString);
        if (node.leftChild != null)
            createCompressedTable(node.leftChild, compressedString + "0");
        if (node.rightChild != null)
            createCompressedTable(node.rightChild, compressedString + "1");
    }

}
