import javax.sound.sampled.ReverbType;


public class DoubleLinkedList {

	static Node head = null;
	
	public static class Node
	{
		int data;
		Node next;
		Node prev;
		
		Node(int d)
		{
			data = d;
			next = null;
			prev = null;
		}
		
	}
	
	public void push(Node head_ref, int data) /* adding element at the front */
	{
		Node new_node = new Node(data);
		new_node.next = head_ref;
		new_node.prev = null;
		
	    if((head_ref) !=  null)
	        head_ref.prev = new_node ;
	    
		head = new_node;
	}
	
	public void insertAfter(Node prevNode_ref, int data) /* adding element at the front */
	{
		if (prevNode_ref == null)
	    {
			System.out.print("the given previous node cannot be NULL");
	        return;
	    }

		Node new_node = new Node(data);
		
		new_node.next = prevNode_ref.next;
		prevNode_ref.next = new_node;
		new_node.prev = prevNode_ref;
		
		if (new_node.next != null)
		prevNode_ref.next.prev = new_node;
		
		
	}
	public void append(Node head_ref, int data) /* adding element at the front */
	{		
		Node new_node = new Node(data);
		
		Node temp = head_ref;
		if (temp == null)
	    {
	        new_node.prev = null; 
	        temp = new_node;
	        return;
	    }
		while(temp.next!=null)
		{
			temp = temp.next;
		}
		temp.next = new_node;
		new_node.prev = temp;
		new_node.next = null;
		
	}

	public void printList(Node head_ref)
	{
		if(head_ref == null)
			System.out.println("Empty List");
		
		Node temp = head_ref;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public void delete(Node head_ref, Node del)
	{
		if(head_ref == null || del == null)
			return;
		
		if(del.data == head_ref.data) // if Node to be deleted is head node
		{		
			head = del.next;
			del.next.prev = null;
			del.next = null;
		}
		
		else if(del.next!=null) 
		{
			del.prev.next = del.next;
			del.next.prev = del.prev;
			del.next = null;
			del.prev = null;
		}
		
		else if(del.next == null) //if Node to be deleted is last node
		{
			del.prev.next = null;
			del.prev = null;
		}

	}

	public void reverse(Node head_ref)
	{
		Node temp = null, curr = head_ref;
		
		while(curr!=null)
		{
			temp = curr.prev;
			curr.prev = curr.next;
			curr.next = temp;		
			curr = curr.prev;
		}
		
		 if (temp != null) {
	            head = temp.prev;
	        }
 
	}
	
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		
		list.push(head, 2);
		list.push(head, 4);
		list.push(head, 8);
		list.push(head, 10);
		
//		head = new Node(12);
//        head.next = new Node(56);
//        head.next.prev = head;
//        head.next.next = new Node(2);
//        head.next.next.prev = head.next.prev;
//        head.next.next.next = new Node(11);
//        head.next.next.next.prev = head.next.next.prev;
//        head.next.next.next.next = new Node(13);
//        head.next.next.next.next.prev = head.next.next.next.prev;
        
		//list.insertAfter(head.next.next, 47);
		//list.append(head, 47);
        
        //list.insertBefore(head.next.next.next, 77);
		
		System.out.println("Original Double Linked List is:-> ");
		list.printList(head);
		System.out.println(" ");
		list.reverse(head);
		System.out.println("Reverse List:-> ");
		list.printList(head);
		
//		list.delete(head, head.next.next);
//		
//		System.out.println(" ");
//		System.out.println("Double Linked List After deleting head node is:-> ");
//		list.printList(head);

	}

}
