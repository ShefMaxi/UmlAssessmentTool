class BinaryTree<T extends Comparable<T>>
{
    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(T value)
    {
        this.value = value;
        left = null;
        right = null;
    }

    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void add(T item)
    {
        int delta = item.compareTo(value);
        if (delta < 0)
        {
            if (left != null)
                left.add(item);
            else
                left = new BinaryTree<T>(item);
        }
        else
        {
            if (right != null)
                right.add(item);
            else
                right = new BinaryTree<T>(item);
        }
    }

    public String toString()
    {
        return "BinaryTree(value=" + value + ", left=" + left + ", right=" + right + ")";
    }

    public boolean isMember(T item)
    {
        int delta = item.compareTo(value);
        if (delta == 0)
            return true;
        else if (delta < 0)
        {
            if (left != null)
                return left.isMember(item);
            else
                return false;
        }
        else
        {
            if (right != null)
                return right.isMember(item);
            else
                return false;
        }
    }
};

class BinaryTreeDriver
{
    public static void main(String[] args)
    {
        BinaryTree<String> t = null;
        for (String a: args)
        {
            if (t == null)
                t = new BinaryTree<String>(a);
            else
                t.add(a);
        }

        System.out.println(t);
        System.out.println("contains yak: " + t.isMember("yak"));
        System.out.println("contains fly: " + t.isMember("fly"));
    }
}
