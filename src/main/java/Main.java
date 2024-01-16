import completed.LinkedList;


public class Main 
{
    public static void main(String[] args)
    {
       completed.LinkedList list = new LinkedList();
       list.add(0);
       list.add(1);
       
       completed.LinkedList list2 = new LinkedList();
       list2.add(0);
       list2.add(3);
       list.mergeUnsorted(list2);
       list.printAll();
       
       list2.printAll();
    }
}