package completed;


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
    
    
    private Node insert(Node root, Node toInsert)
    {
        if (root == null || toInsert == null)
        {
            return toInsert;
        }
        
        root.left = insert(root.left, toInsert);
        
        root.BF = getBF(root);
        while (root.BF > 1 || root.BF < -1)
        {
            root = rotate(root);
            root.BF = getBF(root);
        }
        
        return root.left;
    }
    
    /**
     * inserts a Node to the AVL tree
     * @param val val to initialize the Node with
     */
    //abstraction for the user
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
        
        /*
            traverse the AVL tree until a null node is found.
            Once a null node is found, connect it to the node of 
            the previous recursive call
        */
        if (val < root.val)
        {
            root.left = insert(root.left, val);
        }
        else if (val > root.val)
        {
            root.right = insert(root.right, val);
        }
        
        //once the new node has been connected, set the BF of root
        root.BF = getBF(root);
        
        //rotate the root accordingly
        root = rotate(root);
        
        //return the rotated root
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
    
    public void delete(int val)
    {
        this.root = this.delete(root, val);
    }
    
    private Node delete(Node head, int val)
    {
        if (head == null)
        {
            return head;
        }
        
        if (val > head.val)
        {
            head.right = delete(head.right, val);
        }
        else if (val < head.val)
        {
            head.left = delete(head.left, val);
        }
        else
        {
            if (head.right == head.left)    //leaf node
            {
                return null;
            }
            
            head.right.left = insert(head.right, head.left);
            return head.right;
        }
        
        head.BF = getBF(head);
        while (head.BF > 1 || head.BF < -1)
        {
            head = rotate(head);
            head.BF = getBF(head);
        }
        
        return head;
    }
    
    public void printInOrder()
    {
        printInOrder(this.root);
        System.out.println("");
    }
    
    public void printPreOrder()
    {
        printPreOrder(this.root);
        System.out.println("");
    }
    
    public void printPostOrder()
    {
        printPostOrder(this.root);
        System.out.println("");
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
