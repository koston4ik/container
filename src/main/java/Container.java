/**
 * A container that stores arbitrary objects using a linked list.
 *
 * @param <T> the type of elements stored in this container
 */
public class Container<T> {
	/**
     * A private static inner class representing a node in the linked list.
     *
     * @param <T> the type of data stored in this node
     */
	private static class Node<T> {
		/** The data stored in this node. */
		private T data;
		/** Reference to the next node in the list. */
        private Node<T> next;
        
        /**
         * Constructs a new node with the given data.
         *
         * @param data the data to store in this node
         */
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
	
	/** The head node of the linked list. */
	private Node<T> head;
	/** The current number of elements in the container. */
    private int size;
    
    /**
     * Constructs an empty container.
     */
    public Container() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Returns the element at the specified index.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is negative or >= size
     */
    public T GetItem(int index) {
    	if(index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    	}
    	
    	Node<T> current = head;
    	for(int i = 0; i < index; ++i) {
    		current = current.next;
    	}
    	return current.data;
    }
    
    /**
     * Returns the number of elements in this container.
     *
     * @return the number of elements
     */
    public int GetSize() {
    	return size;
    }
    
    /**
     * Adds the specified element to the end of this container.
     *
     * @param item the element to add (may be null)
     */
    public void Add(T item) {
    	Node<T> newNode = new Node<>(item);
    	
    	if(head == null) {
    		head = newNode;
    	}
    	else {
    		Node<T> current = head;
    		while (current.next != null) {
    			current = current.next;
    		}
    		current.next = newNode;
    	}
    	size++;
    }
    
    /**
     * Removes the element at the specified index and returns it.
     *
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException if the index is negative or >= size
     */
    public void Remove(int index) {
    	if(index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    	}
    	
    	if(index == 0) {
    		head = head.next;
    	}
    	else {
    		Node<T> current = head;
    		for(int i = 0; i < index - 1; i++) {
    			current = current.next;
    		}
    		current.next = current.next.next;
    	}
    	size--;
    }
}
