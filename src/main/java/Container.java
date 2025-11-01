
public class Container<T> {
	private static class Node<T> {
		private T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
	
	private Node<T> head;
    private int size;
    
    public Container() {
        this.head = null;
        this.size = 0;
    }
    
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
    
    public int GetSize() {
    	return size;
    }
    
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
}
