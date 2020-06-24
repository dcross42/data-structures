public class TreeNode{

  private TreeNode parent;
  private TreeNode left;
  private TreeNode right;
  private Integer obj;

  public TreeNode(){
    obj = null;
    parent = null;
    left = null;
    right = null;
  }

  public TreeNode(Integer obj){
    this.obj = obj;
    left = null;
    right = null;
    parent = null;
  }

  public TreeNode left(){ return left;}

  public TreeNode right(){ return right; }

  public TreeNode parent(){ return parent; }

  public Integer getObject() { return obj; }

  public void setLeft(TreeNode node){ this.left = node;}
  public void setRight(TreeNode node){ this.right = node;}
  public void setParent(TreeNode node){ this.parent = node;}
  public void setObject(Integer obj){this.obj = obj;}

}
