
package lists;

public class lists2 {

	public static Node<Integer> weakUp(Node<Integer> c1,Node<Integer> c2,Node<Integer> newC,Node<Integer> newH) {
		if (c1 != null && c2 != null) {
			if (c1.getValue() > c2.getValue()) {
				newC.setNext(c2);
				newC = c2;
				c2 = c2.getNext();
			}
			else if (c1.getValue() < c2.getValue()) {
				newC.setNext(c1);
				newC = c1;
				c1 = c1.getNext();
			}
			else {
				newC.setNext(c2);
				newC = c2;
				c2 = c2.getNext();
				newC.setNext(c1);
				newC = c1;
				c1 = c1.getNext();
			}

			return weakUp(c1,c2,newC,newH);
		}
		else if (c1==null) {
			newC.setNext(c2);
			newC = c2;
			c2 = c2.getNext();
			return newH.getNext();
		}
		else {
			newC.setNext(c1);
			newC = c1;
			c1 = c1.getNext();
			return newH.getNext();
		}
	}


	public static Node<Integer> upSidra(Node<Integer> head) {
		if (head == null) {
			return null; 
		}

		Node<Integer> newHead = new Node<>(null); 
		Node<Integer> newCurrent = newHead;

		while (head != null) {

			Node<Integer> minNode = head;
			Node<Integer> minNodePrev = null;
			Node<Integer> current = head;
			Node<Integer> prev = null;


			while (current != null) {
				if (current.getValue() < minNode.getValue()) {
					minNode = current;
					minNodePrev = prev;
				}
				prev = current;
				current = current.getNext();
			}

			if (minNodePrev != null) {
				minNodePrev.setNext(minNode.getNext());
			} else {
				head = head.getNext(); 
			}

			newCurrent.setNext(minNode);
			minNode.setNext(null); 
			newCurrent = newCurrent.getNext();
		}

		return newHead.getNext(); 
	}


	public static int sumOfDistances(int target,Node<Integer> head) {
		Node<Integer> current = head;
		int index = 0, firstIndex = -1, lastIndex = -1, size = 0;
		while (current != null) {
			if (current.getValue() == target) {
				if (firstIndex == -1) {
					firstIndex = index;
				}
				lastIndex = index;
			}
			current = current.getNext();
			index++;
		}
		size = index;

		if (firstIndex == -1) {
			return -1;
		}

		return firstIndex + (size - 1 - lastIndex);
	}



	
	public static boolean allUnique(Node<Integer> head) {
		Node<Integer> c1 = head;

		while (c1 != null) {
			Node<Integer> c2 = c1.getNext();
			while (c2 != null) {
				if (c1.getValue() == c2.getValue()) {
					return false;
				}
				c2 = c2.getNext();
			}
			c1 = c1.getNext();
		}
		return true;
	}


	public static Node<Integer> delDoubles(Node<Integer> head) {
		Node<Integer> current1 = head;

		while (current1 != null) {
			Node<Integer> current2 = current1.getNext();
			Node<Integer> previous2 = current1;

			while (current2 != null) {
				if (current2.getValue()==current1.getValue()) {
					previous2.setNext(current2.getNext()); 
				} else {
					previous2 = current2;  
				}
				current2 = current2.getNext();  
			}
			current1 = current1.getNext();   
		}

		return head;
	}
