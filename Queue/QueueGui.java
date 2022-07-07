/**
 * @author Khushi Bhola (0404531)
 *
 */
public class QueueGui<E> 
{
	E arr[];
	public static final int DEFAULT_SIZE=20;
	int front,rear,count;
	QueueGui()
	{
		this(DEFAULT_SIZE);
	}
	QueueGui(int size)
	{
		arr=(E[]) new Object[size];
		front=0;
		rear=0;
		count=0;
	}
	public void enqueue(E value)
	{
		if(count==arr.length)
		{
			System.out.println("Array is full");
		}
		else {
			arr[rear%(arr.length)]=value;
			rear++;
			count++;
		}
	}
	public void dequeue()
	{
		if(count==0)
		{
			System.out.println("array is empty");
			front=rear=0;
		}
		else {
			front++;
			count--;
		}

	}
	public E front()
	{
		if(count==0)
		{
			return null;
		}
		return arr[front%(arr.length)];
	}
	public void clear()
	{
		front=rear=count=0;
	}
	public boolean empty()
	{
		if(count==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int size()
	{
		return count;
	}
	public String toString()
	{
		StringBuilder str=new StringBuilder();
		if(count>0)
		{
			for(int i=front;i<rear;i++)
			{
				str.append(arr[i%(arr.length)]);
				if(i<rear-1)
				{
					str.append(", ");
				}
			}
		}
		else
		{
			str.append("This Queue is empty");
		}
		return str.toString();
	}
}
