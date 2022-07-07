public class Node<E> {
	E data;
	Node<E> next;
	Node<E> previous;
	Node()
	{
	  this(null);	
	}
	Node(E data)
	{
		this(data,null);
	}
	Node (E data, Node<E> next)
	{
		this(data,next,null);
	}
	Node(E data, Node<E> next, Node<E> previous)
	{
		this.data=data;
		this.next=next;
		this.previous=previous;
	}

	// accessors and mutators for data
	public E getData()
	{
		return data;
	}
	public void setData(E data)
	{
		this.data=data;
	}
	
	// accessors and mutators for next 
	public Node<E> getNext()
	{
		return next;
	}
	public void setNext(Node<E> next)
	{
		this.next=next;
	}
	
	// accessors and mutators for previous
	public Node<E> getPrevious()
	{
		return previous;
	}
	public void setPrevious(Node<E> previous)
	{
		this.previous=previous;
	}	
}