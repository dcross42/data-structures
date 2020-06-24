public class Main{
  public static void main(String[] args){
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    System.out.println(stack);
    System.out.println(stack.pop());
    System.out.println(stack);
    System.out.println("DONE STACK.");


    LinkedList<Integer> list = new LinkedList<Integer>();
    list.addFront(3);
    list.addTail(10);
    list.addTail(4);
    list.addTail(64);
    System.out.println(list);
    list.removeAtIndex(1);
    System.out.println(list);
    System.out.println("DONE LIST.");


    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(4);
    bst.insert(5);
    bst.insert(3);
    bst.insert(2);
    bst.insert(1);
    bst.insert(6);
    bst.insert(7);
    System.out.println(bst);
    System.out.println("DONE BST.");
  }//end
}
