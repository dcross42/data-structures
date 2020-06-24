import java.lang.StringBuilder;

//Implements BST as outlined in Cormen textbook

public class BinarySearchTree{
  private TreeNode root;

  public BinarySearchTree(){
    root = null;
  }

  public String toString(){
    StringBuilder result = new StringBuilder();
    createString(root, result);
    return result.toString();
  }

  private void createString(TreeNode node, StringBuilder result){
    if(node != null){
      createString(node.left(), result);
      result.append(node.getObject() + " ");
      createString(node.right(), result);
    }
  }

  public void insert(Integer obj){
    insert(new TreeNode(obj));
  }

  public void insert(TreeNode node){
    System.out.println("Inserting " + node.getObject());
    if(root == null){
      root = node;
    }
    else{
      TreeNode prev = null;
      TreeNode cur = root;
      while(cur != null){
        prev = cur;
        if (node.getObject().compareTo(cur.getObject()) < 0){//node < cur
          cur = cur.left();
        }
        else{
          cur = cur.right();
        }
      }//end while
      node.setParent(prev);
      if(node.getObject().compareTo(prev.getObject()) < 0){
        prev.setLeft(node);
      }
      else{
        prev.setRight(node);
      }
    }//end else

  }//end insert

  public void delete(Integer obj){
    delete(new TreeNode(obj));
  }

  public void delete(TreeNode node){
    if(node.left() == null){
      transplant(node, node.right());
    }
    else if( node.right() == null ){
      transplant(node, node.left());
    }
    else{
      TreeNode min = minimum(node.right());
      if(!min.parent().equals(node)){
        transplant(min, min.right());
        min.setRight(node.right());
        min.right().setParent(min);
      }
      transplant(node, min);
      min.setLeft(node.left());
      min.left().setParent(min);
    }
  }

  public Integer search(Integer key){//iterative implementation
    TreeNode node = root;
    while(node != null && !key.equals(node.getObject())){
      if (key.compareTo(node.getObject()) < 0){
        node = node.left();
      }
      else{
        node = node.right();
      }
    }//end while
    return node.getObject();
  }//end search

  private TreeNode minimum(TreeNode node){
    while(node.left() != null){
      node = node.left();
    }
    return node;
  }

  private TreeNode maximum(TreeNode node){
    while(node.right() != null){
      node = node.right();
    }
    return node;
  }

  private void transplant(TreeNode first, TreeNode other){
    if (first.parent() == null){
      root = other;
    }
    else if(first.equals(first.parent().left())){
      first.parent().setLeft(other);
    }
    else{
      first.parent().setRight(other);
    }
    if(other != null){
      other.setParent(first.parent());
    }
  }
}//end class
