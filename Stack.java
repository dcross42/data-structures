import java.lang.StringBuilder;

public class Stack<T>{
  private Node<T> top;
  private int size;

  public Stack(){
    this.top = null;
    size = 0;
  }//end default

  public int size() { return size; }

  public boolean isEmpty(){ return size == 0; }

  public void push(Node<T> node){
    node.setNext(top);
    top = node;
    size++;
  }//end node push

  public void push(T value){
    Node<T> node = new Node<T>(value);
    push(node);
  }//end value push

  public T pop(){
    if(isEmpty()){
      //throw exception
    }
    Node<T> node = top;
    top = node.next();
    size--;
    return node.getObject();
  }//end pop

  public String toString(){
    Node<T> current = top;
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
