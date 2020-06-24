import java.lang.StringBuilder;
//Implement Doubly LinkedList
public class LinkedList<T>{
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public LinkedList(){
    head = null;
    tail = null;
    size = 0;
  }//end default

  public int size() { return size; }
  public boolean isEmpty(){ return size == 0; }
  public boolean validIndex(int index){
    return index > 0 && index < size;
  }

  public void addTail(Node<T> node){
    if(isEmpty()){
      addFirstNode(node);
    }
    else{
      tail.setNext(node);
      node.setPrev(tail);
      tail = node;
      size++;
    }
  }

  public void addFront(Node<T> node){
    if(isEmpty()){
      addFirstNode(node);
    }
    else{
      head.setPrev(node);
      node.setNext(head);
      head = node;
      size++;
    }
  }

  public void addAtIndex(int index, Node<T> node){
    if(!validIndex(index)){
      //throw out of bounds
    }
    else if(isEmpty()){
      addFirstNode(node);
    }
    else if(index == 0){
      addFront(node);
    }
    else if(index == size - 1){
      addTail(node);
    }
    else{
      Node<T> cur = goToNode(index);
      add(cur.prev(), cur, node);
    }
  }

  public void addTail(T obj){
    addTail(new Node<T>(obj));
  }
  public void addFront(T obj){
    addFront(new Node<T>(obj));
  }
  public void addAtIndex(int index, T obj){
    addAtIndex(index, new Node<T>(obj));
  }

  public T get(int index){
    if(!validIndex(index)){
      //throw index out of bounds
    }
    return goToNode(index).getObject();
  }

  public T removeFront(){
    Node<T> node = head;
    head = head.next();
    head.setPrev(null);
    return node.getObject();
  }

  public T removeBack(){
    Node<T> node = tail;
    tail = tail.prev();
    tail.setNext(null);
    return node.getObject();
  }

  public T removeAtIndex(int index){
    if(!validIndex(index)){
      //throw out of bounds exception
    }
    else if(index == 0){
      return removeFront();
    }else if(index == size - 1){
      return removeBack();
    }
    Node<T> node = goToNode(index);
    return remove(node);
  }

  private Node<T> goToNode(int index){
    Node<T> cur;
    if(index > size / 2){//search from back
      cur = tail;
      for(int i = size - 1; i > index; i--){
        cur = cur.prev();
      }//end for
    }
    else{//search from front
      cur = head;
      for(int i = 0; i < index; i++){
        cur = cur.next();
      }//end for
    }
    return cur;
  }

  private T remove(Node<T> node){
    Node<T> prev = node.prev();
    Node<T> next = node.next();
    prev.setNext(next);
    next.setPrev(prev);
    size--;
    return node.getObject();
  }

  private void add(Node<T> prev, Node<T> next, Node<T> node){
    prev.setNext(node);
    node.setPrev(prev);
    next.setPrev(node);
    node.setNext(node);
    size++;
  }

  private void addFirstNode(Node<T> node){
    head = node;
    tail = node;
    size++;
  }

  public String toString(){
    Node<T> current = head;
    StringBuilder result = new StringBuilder();
    while(current != null){
      result.append(current.getObject());
      current = current.next();
      if(current != null){
        result.append(" -> ");
      }
    }//end while
    return result.toString();
  }//end toString
}//end class
