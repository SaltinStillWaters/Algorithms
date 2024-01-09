
public class AVL 
{
    private class Node
    {
        public Node left;
        public Node right;
        public int val;
        public int BF;

        public Node(int val)
        {
            this.left = null;
            this.right = null;
            this.val = val;
            this.BF = 0;
        }
    }
    
    private Node root;
    
    
    public void insert(int val)
    {
        this.root = this.insert(this.root, val);
    }
    
    private Node insert(Node root, int val)
    {
        if (root == null)
        {
            Node newNode = new Node(val);
            return newNode;
        }
        
        if (val < root.val)
        {
            root.left = insert(root.left, val);
        }
        else if (val > root.val)
        {
            root.right = insert(root.right, val);
        }
        
        root.BF = getBF(root);
        root = rotate(root);
        
        return root;
    }
    
    private int getBF(Node root)
    {   
        int leftDiff = getHeight(root.left);
        int rightDiff = getHeight(root.right);
        
        return rightDiff - leftDiff;
    }
    
    private int getHeight(Node root)
    {
        if (root == null)
        {
            return 0;
        }
        
        int leftDiff = getHeight(root.left);
        int rightDiff = getHeight(root.right);
        
        return Math.max(leftDiff, rightDiff) + 1;
    }
    
    private Node rotate(Node root)
    {
        Node newRoot = root;
        if (root.BF <= -2)
        {
            if (root.left.BF < 0)
            {
                newRoot = rotateLL(root);
            }
            else
            {
                newRoot = rotateLR(root);
            }
        }
        else if (root.BF >= 2)
        {
            if (root.right.BF > 0)
            {
                newRoot = rotateRR(root);
            }
            else
            {
                newRoot = rotateRL(root);
            }
        }
        
        return newRoot;
    }
    
    
    private Node rotateLL(Node root)
    {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        
        return newRoot;
    }
    
    private Node rotateLR(Node root)
    {
        Node newLeft = root.left.right;
        root.left.right = newLeft.left;
        newLeft.left = root.left;
        root.left = newLeft;
        
        return rotateLL(root);
    }
    
    private Node rotateRR(Node root)
    {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        
        return newRoot;
    }
    
    private Node rotateRL(Node root)
    {
        Node newRight = root.right.left;
        root.right.left = newRight.right;
        newRight.right = root.right;
        root.right = newRight;
        
        return rotateRR(root);
    }
    
    public void printInOrder()
    {
        printInOrder(this.root);
    }
    
    public void printPreOrder()
    {
        printPreOrder(this.root);
    }
    
    public void printPostOrder()
    {
        printPostOrder(this.root);
    }
    
    private void printPreOrder(Node root)
    {
        if (root == null)
        {
            return;
        }
        
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    
    private void printInOrder(Node root)
    {
        if (root == null)
        {
            return;
        }
        
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
    
    private void printPostOrder(Node root)
    {
        if (root == null)
        {
            return;
        }
        
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.val + " ");
    }
    
    
    public boolean isEmpty()
    {
        return this.root == null;
    }
}
