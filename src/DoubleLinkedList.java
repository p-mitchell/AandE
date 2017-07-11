
public class DoubleLinkedList // responsible for maintaining the chain of nodes
{
	public Node head;	// reference to the first node in the chain
	public int size;	// the number of nodes in the chain
	
	// constructor for the DLL. initialised as empty
	public DoubleLinkedList()
	{
		this.head = null;
		this.size = 0;
	} // end constructor
	
	
	// method to add node to chain
		public void add(Object data)		// add a Node to the list
		{
			if (this.head == null)			// if the list is currently empty. store node at head position
			{
				Node n = new Node(data, null, null);	// as this is the only node, set the next to null and the previous as null
				this.head = n;							// first node. set this as the head
			}
			else 							// if not adding to the first position. add to the end
			{
				Node tail = getNode(size);				// set tail as the last node
				Node n = new Node(data, null, null);	// add in the new node
				tail.setNext(n);						// change the next node in tail from null to 'n'
				n.setPrevious(tail); 					// set the 'previous node' for the new null to the previous last one
			}
			size++;
		} // end of add

		
		public void remove(int pos)			// remove a node from the list
		{
			Node current = getNode(pos);			// the node we want to remove
			if (pos == 1) 							// if removing the head
			{
				this.head = current.getNext();
				this.head.setPrevious(null);
			} // end if
			else if (pos == size) 
			{
				// if the node we're removing is the last node 
				Node previous = getNode(pos -1);
				
				previous.setNext(null);
			} // end else if
			else
			{
				Node previous = getNode(pos -1);		// find the node before the one to remove
				Node next = getNode(pos + 1);			// find the node after the one to remove
				
				previous.setNext(current.getNext());		// set the 'next node' of the previous, to the 'next node' of the current
				next.setPrevious(current.getPrevious());	// set the 'previous node' of the next node to 'previous' of the current
			} // end else
			size--;
		} // end remove									// essentially = skip the 'current' node
		
		
		public void removeLast(int pos)
		{
			Node current = getNode(pos);
			current.setNext(null);
			current.setPrevious(null);
		}
		
		
		public Node getNode(int pos) 		// get node at a particular position
		{
			Node temp = null;
			for (int i = 1; i <= pos; i++) 
			{
				if (i == 1)
				{										// if someone is looking for the node at position 1 = return head
					temp = this.head; 					// TODO ERROR CHECK FOR IF THE LIST IS EMPTY
				} else 
				{										// loop through all the nodes in the list
					temp = temp.next;					// set the 'temp' node as the last node
				}
			} // end for
			return temp;					// return the node that matches the 'pos' parameter
		} // end getNode
		
		
		 public int getPosition(Node data)	// find the position of a particular nodes
		 { 
			 Node temp = data;		// create a node for the parameter
			 Node n = this.head;	// changing variable starting at the head
			 int position = 1;		// integer value for incrementing the position as you move through the DLL
			 
			 for (int i = 1; i < size; i++)				// for loop through all the nodes in the list
			 {
				if (n.getData() != temp.getData())		// if the parameter data doesn't match the n data
				{										
					n = n.getNext();		// move to the next node
					position++;				// increment the position counter
				}
			 }									// so when the data DOES match,
			 //System.out.println(position);
			 return position;					// return the position counter
		 }
		
		
		public String toString()			// get the information from the list
		{
			String temp = "";
			Node n = this.head;

			while (n != null) {				// while its not the last node
				String details = "Patient: " + ((Patient)n.getData()).firstname + " " + ((Patient)n.getData()).lastname + ". Diagnosis: " + ((Patient)n.getData()).diagnosis;
				temp = temp + details + "\n";		// add to the temp string. the node - cast as patient type. get the firstname
				
				n = n.getNext();			// move on to the next node
			}
			return temp;
		} // end toString
		
		
		public Node queue()					// find the patient with the highest priority. used by doctor
		{
			Node temp = this.head;				// the starting point for the list
			Node next = null;					// the blank node for the highest priority patient
			int priority = 1;					// initialise the priority as the minimum possibility
			
			for (int i = 0; i < size; i++) 		// loop through each of the nodes in the list
			{
				int current = ((Patient)temp.getData()).priority;	// set the current priority as the first persons priority
				if ( current > priority)		// if their priority is greater than the initialised
				{
					priority = current;			// update the priority
					next = temp;				// update the most important patient
				} // end if
				temp = temp.getNext();			// move to the next node
				
			} // end for
			//System.out.println(((Patient)next.getData()).firstname);
			return next;
		}


		public Node updatePriority()		// find the next node which hasn't update their priority. used by nurse
		{
			Node temp = this.head;			// variables for iterating through the list
			Node next = null;				// and return variable
			
			for (int i = 0; i < size; i++) 
			{													// loop through the list until find a node
				if (((Patient)temp.getData()).priority == 0)	// which has a priority of 0
				{
					next = temp;
					break;						// once you find the first one, break out of the loop
				}
				else
				{
					next = null;
				}
				temp = temp.getNext();
			}
			//System.out.println(((Patient)next.getData()).firstname);
			return next;					// return that node
		}
		
}

