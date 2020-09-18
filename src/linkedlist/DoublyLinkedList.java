package linkedlist;

/*code to implement Doubly Linked List where the head 
reference has pointer to head and tail nodes*/
public class DoublyLinkedList  {
	// inner Node class to define node property of the list.
	class NewElement{
		int data;
		NewElement next;
		NewElement back;
	}
	//inner Pair class to have head and tail reference.
	class HeadReference{
		NewElement head;
		NewElement tail;
		HeadReference(NewElement head,NewElement tail) {
			this.head=head;
			this.tail=tail;
		}
	}
	//set head and tail reference to null initially.
	HeadReference pair=new HeadReference(null,null);
	int size=0;
	//check if the list has any nodes 
	public boolean isEmpty(){
		//return pair.head == null;
		return size==0;
	}
	// method to return head pointer and tail reference
	public HeadReference headreference(){
		return pair;
	}
	//print element at a given position
	public void printelement(int index) {
		NewElement temp=pair.head;
		if(index<0 || index>size-1) {
			System.out.println("Not a valid index");
			return;
		}

		for(int i=0;i<index && temp.next!=null;i++) {
			temp=temp.next;
		}
		System.out.println("Node at index "+ index +" has value "+temp.data);
	}
	//insertion at the start of the list
	public void insertAtStart(int val){
		//create a new node.
		NewElement node = new NewElement();
		node.data=val;

		if(isEmpty()){
			pair.tail = node;
		}else{
			pair.head.back = node;
		}
		node.next = pair.head;
		pair.head = node;
		size++;
	}
	//insertion at the end of the list
	public void insertAtEnd(int val){
		NewElement node = new NewElement();
		node.data=val;
		if(isEmpty()){
			pair.head = node;
		}

		else{
			pair.tail.next = node;
			node.back = pair.tail;
		}
		pair.tail = node;
		size++;
	}

	//insertion at any given index in the list .
	public void insertAtIndex(int val, int index){
		if(index < 0 || index > size){
			System.out.println("Index out of bounds,can't add new node at index " +index);
			return;
		}
		NewElement node = new NewElement();
		node.data=val;
		NewElement current = pair.head;

		if(index == 0){
			insertAtStart(val);
		}

		else if(index == size){
			insertAtEnd(val);
		}
		else{
			//traverse to the index where we want to add the node
			for(int i = 0; i < index && current.next != null; i++){
				current = current.next;
			}
			node.next = current;
			current.back.next = node;
			node.back = current.back;
			current.back = node;
			size++;    
		}

	}
	public NewElement deleteFirst() {
		//if the list is empty
		if(pair.head==null) {
			System.out.println("List is empty,no nodes to be deleted.");
			try {
				return pair.head;
			}
			catch(Exception e) {
				System.out.println("List is empty,no nodes to be deleted.");

			}
		}

		NewElement deletedfirst =pair.head;
		//only one node in the list and that is to be deleted
		if(pair.head.next == null){
			pair.tail = null;
		}
		else{
			// previous of next node of head node becomes null
			pair.head.next.back = null;
		}
		pair.head = pair.head.next;
		size--;

		return deletedfirst;
	}
	
	public NewElement deleteLast() {
		//if the list is empty
		if(pair.tail==null) {
			System.out.println("List has no nodes to be deleted.");
			try {
				return pair.tail;
			}
			catch(Exception e) {
				System.out.println("List has no nodes to be deleted.");
			}

		}

		NewElement deletedlast = pair.tail;
		//only  node in the list and that is to be deleted
		if(pair.head.next == null){
			pair.head = null;
		}
		else{
			// next of previous node of tail node becomes null
			pair.tail.back.next = null;
		}
		pair.tail = pair.tail.back;
		size--;
		return deletedlast;
	}
	public NewElement deleteElementAtIndex(int index) {
		if(index < 0 || index > size-1){
			System.out.println("Not a valid index for node deletion,try another index");
			try {
				return null;
			}
			catch(Exception e) {
				System.out.println("Not a valid index for node deletion,try another index");
			}

		}
		NewElement deletedindex = pair.head;
		
		if(index == 0){
			//delete head node
			return deleteFirst();
		}
		
		else if(index == size-1){
			// delete tail node
			return deleteLast();
		}
		else{
			for(int i= 0; i < index && deletedindex.next != null; i++){
				deletedindex = deletedindex.next;
			}
			deletedindex.back.next = deletedindex.next;
			deletedindex.next.back = deletedindex.back;
			size--;
		}
		return deletedindex;
	}
	//print the nodes in the list
	public void printList() {
		NewElement temp=pair.head;
		System.out.println("the linked list:");
		while(temp.next!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
		System.out.println(temp.data);

	}
	public static void main (String[] args)  {
		DoublyLinkedList dll = new DoublyLinkedList(); 
		dll.deleteLast();
		dll.insertAtStart(5);        
		dll.insertAtStart(54);
		dll.insertAtEnd(35);
		dll.insertAtEnd(59);
		dll.insertAtIndex(4, 3);
		dll.printList();
		dll.printelement(4);
		NewElement node = dll.deleteElementAtIndex(6);
		HeadReference p=dll.headreference();
		System.out.println(  "head node has value= "+p.head.data + " and tail node has value= "+ p.tail.data);
		System.out.println("size of list is " + dll.size);


	}
}
