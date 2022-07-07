import javax.swing.JOptionPane;

public class DoublyLLGui<E> 
{
	Node<E> head;
	Node<E> tail;
	int size;
	DoublyLLGui()
	{
		this(null);
	}
	DoublyLLGui(Node<E> head)
	{
		this(head,null);
	}
	DoublyLLGui(Node<E> head, Node<E> tail)
	{
		this(head,tail,0);
	}
	DoublyLLGui(Node<E> head, Node<E> tail, int size)
	{
		this.head=head;
		this.tail=tail;
		this.size=size;
	}
	//accessors and mutators for head
	public Node<E> getHead()
	{
		return head;
	}
	public void setHead(Node<E> head)
	{
		this.head=head;
	}
	// accessors and mutators for tail
	public Node<E> getTail()
	{
		return tail;
	}
	public void setTail(Node<E> tail)
	{
		this.tail=tail;
	}
	// accessors and mutators for size
	public int getSize()
	{
		return size;
	}
	public void setSize(int size)
	{
		this.size=size;
	}	
	public void addBack(E data)
	{
		if(head==null)
		{
			addFront(data);
		}
		else
		{
			Node<E> node=new Node<E>();
			node.setData(data);
			setSize(getSize()+1);
			Node<E> n=head;
			while(n.next!=null)
			{
				n=n.next;
			}
			node.setPrevious(n);
			n.next=node;
			node.setNext(null);
			setTail(node);
		}
	}
	public void addFront(E data)
	{

		Node<E> node=new Node<E>();
		node.setData(data);
		setSize(getSize()+1);
		if(head==null)
		{
			setHead(node);
			setTail(node);
		}
		else
		{
			head.setPrevious(node);
			node.setNext(head);
			node.setPrevious(null);
			setHead(node);
		}
	}
	public void addAfter(E data, int position)
	{
			if(position<=1)
			{
				addFront(data);
			}
			else if (position>(getSize())) 
			{
				JOptionPane.showMessageDialog(null, "The size of the list is "+getSize()+" thus the element will be added at last position");
				addBack(data);
			}
			else
			{
				Node<E> node=new Node<E>();
				node.setData(data);
				setSize(getSize()+1);
				Node<E> n=head;
				for(int i=0;i<position-2;i++)
				{
					n=n.next;
				}
				Node<E> temp=n.next;
				node.setPrevious(n);
				n.next=node;
				node.setNext(temp);
				temp.previous=node;
			}
		}

	public void removeFirst()
	{
		if(size<=1)
		{
			setHead(null);
			setTail(null);
			setSize(0);
		}
		else
		{
			Node<E> n=head;
			n=n.next;
			n.setPrevious(null);
			setHead(n);
			setSize(getSize()-1);
		}
	}
	public void removeLast()
	{
		if(size<=1)
		{
			setHead(null);
			setTail(null);
			setSize(0);
		}
		else
		{
			Node<E> n=tail.previous;
			n.setNext(null);
			setTail(n);
			setSize(getSize()-1);
		}
	}
	public void removeAt(int position)
	{
		try
		{
			if(position<=1)
			{
				removeFirst();
			}
			else if(position==getSize())
			{
				removeLast();
			}
			else
			{
				setSize(getSize()-1);
				Node<E> n=head;
				for(int i=0;i<position-2;i++)
				{
					n=n.next;
				}
				Node<E> temp=n.next;
				temp=temp.next;
				temp.previous=n;
				n.next=temp;
				setTail(temp);
			}
		}catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "There is no value at that position");
		}
	}
	public String display()
	{
		Node<E> n=head;
		String tempDisplayForward="";
		while(n!=null)
		{
			tempDisplayForward=tempDisplayForward+n.getData()+", ";
			n=n.next;
		}
		return tempDisplayForward;
	}
	public String displayBackWord()
	{
		Node<E> n=tail;
		String tempDisplayBackword="";
		while(n!=null)
		{
			tempDisplayBackword=tempDisplayBackword+n.getData()+", ";
			n=n.previous;
		}
		return tempDisplayBackword;
	}
}
