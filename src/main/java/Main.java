package lesson1;
	import java.util.*;
	public class listlevel2 {
		public static Scanner input = new Scanner(System.in);
		public static Node<Integer> BuildNode(Node<Integer> a) 
		{
	        Node<Integer> current = a;
	        while (current != null && current.getNext() != null) 
	        {
	            Node<Integer> runner = current;
	            while (runner.getNext() != null) 
	            {
	                if (runner.getNext().getValue() == current.getValue()) 
	                {
	                    runner.setNext(runner.getNext().getNext());
	                } 
	                else 
	                {
	                    runner = runner.getNext();
	                }
	            }
	            current = current.getNext();
	        }

	        return a;
	    }
		public static Node<Integer> eraseEven(Node<Integer> a)
		{
		    if (a == null) 
		    {
		        return null;
		    }
		    Node<Integer> current = a;
		    Node<Integer> previous = null;
		    int index = 1;
		    while (current != null) 
		    {
		        if (index % 2 == 0) 
		        {
		            if (previous != null) 
		            {
		                previous.setNext(current.getNext());
		            } 
		            else 
		            {
		                a = current.getNext();
		            }
		        }
		        else 
		        {
		            previous = current;
		        }
		        current = current.getNext();
		        index++;
		    }
		    return a;
		}
		public static void main(String[] args) {	
			Node<Integer> a = new Node<Integer>(7);
			Node<Integer> b = new Node<Integer>(2);
			Node<Integer> c = new Node<Integer>(7);
			Node<Integer> d = new Node<Integer>(5);
			Node<Integer> e = new Node<Integer>(2);
			a.setNext(b);
			b.setNext(c);
			c.setNext(d);
			d.setNext(e);
			System.out.println(BuildNode(a));
			System.out.println(eraseEven(a));
		}
}
