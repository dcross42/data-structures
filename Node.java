public class Node<T> {
  private T obj;
  private Node<T> next; //can be left child
  private Node<T> prev; // can be right child

  public Node (){
    obj = null;
    next = null;
    prev = null;
  }//end default

  public Node (T val){
    setObject(val);
    next = null;
    prev = null;
  }//end default

  public Node (Node<T> other){
    setObject(other.obj);
    setNext(other.next);
    setPrev(other.prev);
  }//end default

  //accessors
  public Node<T> next() { return next; }
  public Node<T> prev() { return prev; }
  public T getObject() { return obj; }

  //modifiers
  public void setNext(Node<T> node) { this.next = node; }
  public void setPrev(Node<T> node) { this.prev = node; }
  public void setObject(T val) { this.obj = val; }

  
}//end class
