import java.util.Comparator;

class FrequencyComparator implements Comparator<Node>
{
    @Override
    public int compare(Node x, Node y)
    {
        if (x.frequency < y.frequency) return -1;
        if (x.frequency > y.frequency) return 1;
        return 0;
    }
}
