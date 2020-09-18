package linkedlist;

/*public class linkedlist {
Node head;
public void insert(int data) {
	Node node=new Node();
	node.data=data;
	if(head==null)
		node=head;
	else
	{
		Node n=head;
		while(n.next!=null) {
			n=n.next;
		}
		n.next=node;
	}		
}
public void show() 
{
	Node node=head;
	while(node.next!=null)
	{
		System.out.println(node.data);
		node=node.next;
	}
	System.out.println(node.data);
}
public static void main(String[] args) {
	linkedlist list=new linkedlist();
	list.insert(34);
	list.insert(33);
	list.insert(31);
	list.insert(32);
	list.show();
}
}*/
public class linkedlist 
{
	Node head;
	
	public void insert(int data)
	{
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(head==null)
		{
			head = node;
		}
		else
		{
			Node n = head;
			while(n.next!=null)
			{
				n = n.next;
			}
			n.next =  node;
		}
		
	}
	public void show()
	{
		Node node = head;
		
		while(node.next!=null)
		{
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}
	public void insertStart(int data) {
		Node node=new Node();
		node.data=data;
		node.next=head;
		head=node;
	}
	public void insertAt(int index,int data) {
		Node node=new Node();
		node.data=data;
		if(index==0)
			insertStart(data); 
		Node n=head;
		for(int i=0;i<index-1;i++) {
			n=n.next;
		}
		node.next=n.next;
		n.next=node;
	}
	public void delete(int index) {
		if(index==0)
			head=head.next;
		else {
		Node n=head;
		for(int i=0;i<index-1;i++) {
			n=n.next;
		}
		n.next=n.next.next;
	}
	}
	public static void main(String[] args) {
		linkedlist list=new linkedlist();
		list.insert(34);
		list.insert(33);
		list.insert(31);
		list.insert(32);
		list.insertStart(56);
		list.insertAt(2,39);
		list.delete(1);
		list.delete(2);
		list.show();
	}
}