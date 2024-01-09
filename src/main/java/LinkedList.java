
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

    public LinkedList()
    {
        this.head = null;
    }
    
    public LinkedList(Node head)
    {
        this.head = head;
    }
    
    
    public void merge(LinkedList list2)
    {
        this.head = merging(this.head, list2.head);
    }
    
    private Node merging(Node head1, Node head2)
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
            head1.next = merging(head1.next, head2);
            return head1;
        }
        else
        {
            head2.next = merging(head1, head2.next);
            return head2;
        }
        
    }
    
    public void reversal()
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
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
}
