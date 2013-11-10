class Node {
    String key;
    Integer frequency;
    Node leftChild;
    Node rightChild;

    public Node(String key, Integer frequency) {
        this.key = key;
        this.frequency = frequency;
        this.leftChild = null;
        this.rightChild = null;
    }
}
