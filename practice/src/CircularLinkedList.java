
public class CircularLinkedList {

	Node head, head1, head2;
	
	
	static public class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
		Node(int d, Node head)
		{
			data = d;
			next = head;
		}
	}
	
	public void push(int new_data)
	{
		Node new_node = new Node(new_data);
		new_node.next = head;
		if(head == null)
		{
			head = new_node;
			head.next = head;
		}
		else
		{
			head.next=new Node(new_data,head.next);
		}
	}
	

	public void printList()
	{
		//System.out.println("Head's value = " + head.data);
		Node n = head;
		   if (head != null)
		    {
		        do
		        {
		        	System.out.print(n.data+" ");
					n = n.next;
		        }
		        while (n != head);
		    }
		
	}
	
	public void printList(Node head)
	{
		//System.out.println("Head's value = " + head.data);
		Node n = head;
		   if (head != null)
		    {
		        do
		        {
		        	System.out.print(n.data+" ");
					n = n.next;
		        }
		        while (n != head);
		    }
		
	}
	 public void sortedInsert(Node new_data)
	{
		Node current = head;
		if(current == null)
		{
			new_data.next = new_data;
			head = new_data;
		}
		else if(current.data >= new_data.data)  // inserted at the beginning
		{
			while(current.next!=head)
			{
				current = current.next; // traverse till last node
			}
			current.next = new_data;
			new_data.next = head;
			head = new_data;
		}
		else if(current.data < new_data.data) //inserted somewhere after head
		{
			while(current.next!=head && new_data.data> current.next.data)
			{
				current = current.next;
			}
			new_data.next = current.next;
			current.next = new_data;
		}
	}
	 
	 public void splitList()
	 {
		 Node slow = head;
		 Node fast = head;
		 
		 if(head==null)
			 return;
		 
		  /* If there are odd nodes in the circular list then
         fast_ptr->next becomes head and for even nodes 
         fast_ptr->next->next becomes head */ // Hare and Tortoise algo
        while (fast.next != head
                && fast.next.next != head) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        /* If there are even elements in list then move fast_ptr */
        if (fast.next.next == head) {  //to store last element
            fast = fast.next;
        }
 
        head1 = head;
        /* Set the head pointer of second half */
        if (head.next != head) {
            head2 = slow.next;
        }
        /* Make second half circular */
        fast.next = slow.next;
 
        /* Make first half circular */
        slow.next = head;
	 }
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
//		list.push(10);
//		list.push(16);
//		list.push(18);
//		list.push(36);
//		list.push(40);
//		list.push(79);
//		System.out.println("Circular Linked List :");
//		list.printList();
		
//        int arr[] = new int[] {12, 56, 2, 11, 1, 90};
// 
//        /* start with empty linked list */
//        Node temp = null;
// 
//      
//        for (int i = 0; i < 6; i++)
//        {
//            temp = new Node(arr[i]);
//            list.sortedInsert(temp);
//        }
// 
		list.head = new Node(12);
        list.head.next = new Node(56);
        list.head.next.next = new Node(2);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(13);
        list.head.next.next.next.next.next = list.head;
 
        System.out.println("Original Circular Linked list ");
        list.printList();
        list.splitList();
        System.out.println("");
        System.out.println("First Circular List ");
        list.printList(list.head1);
        System.out.println("");
        System.out.println("Second Circular List ");
        list.printList(list.head2);
         

	}

}
