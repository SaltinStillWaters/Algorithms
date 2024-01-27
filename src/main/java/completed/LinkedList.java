package completed;


public class LinkedList 
{
    private class Node
    {
        public Node next;
        public int val;

        public Node(int val)
        {
            this.next = null;
            this.val = val;
        }
    }
    
    private Node head;

    /**
     * Creates an empty LinkedList with 'head' set to 'null
     */
    public LinkedList()
    {
        this.head = null;
    }
    
    /**
     * Creates an initialized LinkedList from the values of an existing LinkedList
     * @param list list to be copied over
     */
    public LinkedList(LinkedList list)
    {
        LinkedList copiedList = new LinkedList();
        
        for (Node iter = list.head; iter != null; iter = iter.next)
        {
            copiedList.add(iter.val);
        }
        
        this.head = copiedList.head;
    }
    
    /**
     * Adds a new Node to the end of the list
     * @param val value to add
     */
    public void add(int val)
    {
        if (this.isEmpty())
        {
            this.head = new Node(val);
            return;
        }
        
        Node iter = head;
        while (iter.next != null)
        {
            iter = iter.next;
        }
        
        Node temp = new Node(val);
        iter.next = temp;
    }
    
    /**
     * Removes the first occurrence of the Node with the supplied value. 
     * @param toRemove value of the Node to be removed
     */
    public void remove(int toRemove)
    {
        if (this.isEmpty())
        {
            return;
        }
        
        if (head.val == toRemove)
        {
            head = head.next;
            return;
        }
        
        Node prev = head;
        for (Node iter = head.next; iter != null; iter = iter.next, prev = prev.next)
        {
            if (iter.val == toRemove)
            {
                prev.next = iter.next;
                return;
            }
        }
    }
    
    /**
     * Checks whether a Node with a given value exists.
     * @param toSearch value to search for.
     * @return returns true if Node is found, otherwise false.
     */
    public boolean contains(int toSearch)
    {
        if (this.isEmpty())
        {
            return false;
        }
        
        for (Node iter = head; iter != null; iter = iter.next)
        {
            if (iter.val == toSearch)
            {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Merges 2 lists by attaching the argument list's head to the tail of the calling list.
     * @param list list to merge with
     */
    public void mergeUnsorted(LinkedList list)
    {
        if (this.isEmpty())
        {
            return;
        }
        
        Node iter = this.head;
        while (iter.next != null)
        {
            iter = iter.next;
        }
        
        iter.next = list.head;
    }
    
    /**
     * Merges 2 LinkedLists that will first be sorted.
     * The result will be returned to the calling list.
     * @param list list to merge with. Will not be modified.
     */
    public void mergeSorted(LinkedList list)
    {
        LinkedList temp = new LinkedList(list);
        this.head = mergeSorted(this.head, temp.head);
    }
    
    private Node mergeSorted(Node head1, Node head2)
    {
        if (head1 == null)
        {
            return head2;
        }
        
        if (head2 == null)
        {
            return head1;
        }
        
        
        if (head1.val <= head2.val)
        {
            head1.next = mergeSorted(head1.next, head2);
            return head1;
        }
        else
        {
            head2.next = mergeSorted(head1, head2.next);
            return head2;
        }
    }
    
    public void reverse()
    {
        reverse(this.head);
    }
    
    private Node reverse(Node head)
    {
        if (head == null || head.next == null)
        {
            this.head = head;
            return head;
        }
        
        reverse(head.next).next = head;
        head.next = null;
        
        return head;
    }
    
   
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public void printAll()
    {
        if (this.isEmpty())
        {
            return;
        }
        
        for (Node iter = head; iter != null; iter = iter.next)
        {
            System.out.print(iter.val + " ");
        }
        System.out.println();
    }
    
}
