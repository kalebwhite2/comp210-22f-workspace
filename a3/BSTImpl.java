
package a3;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BSTImpl implements BST {

    private Node root;
    private int size;

    public BSTImpl() { root=null; size=0; }

    public BSTImpl(int val) { this.root=new NodeImpl(val); size=1; }

    // The implementations given to you are intended to help you 
    // see how the linked cells work, and how to program with them.
    //
    // These methods are patterns to illustrate for you how to set up
    // the method implementations as recursion.
    //
    // You should follow this pattern for implementing the other recursive methods
    // by adding your own private recursive helper methods.

    @Override
    // interface method ==================================================
    public int height() {       
      // It is not recursive itself, but it calls a recursive
      // private "helper" method and passes it access to the tree cells.
      return height_recursive(this.root);
    }
    // private recursive helper
    private int height_recursive(Node c) {
      // private inner "helper" method with different signature
      // this helper method uses recursion to traverse
      // and process the recursive structure of the tree of cells
      if (c==null) return -1;
      int lht = height_recursive(c.getLeft());
      int rht = height_recursive(c.getRight());
      return Math.max(lht,rht) + 1;
    }
    
    @Override
    // interface method ==================================================
    public boolean contains(int val) { 
      if(this.root==null) return false; 
      return contains_r(val,root); 
    }
    // private recursive helper
    private boolean contains_r(int val, Node c) {
      if(c == null) return false;
      if(c.getValue()==val) return true;
      return contains_r(val, c.getLeft()) || contains_r(val, c.getRight());
    }

    @Override
    // interface method, used by autograder, do not change
    public Node getRoot() { return this.root; }
    
    @Override
    // interface method ==================================================
    public int size() { return this.size; }

    
    @Override
    // interface method ===================================================
    public void remove(int value) { remove_r(value,this.root); }
    // private recursive helper
    private Node remove_r(int k, Node c) {
      if (c==null) return null; // item not found, nothing to do
      // now we know we have a real node to examine
      //int cflag = k.compareTo(c.getValue());
      int vc=c.getValue();
      if (k<vc) { // k is smaller than node
        c.setLeft(remove_r(k,c.getLeft()));
        return c;
      }
      else if (k>vc) { // k is larger than node
        c.setRight(remove_r(k,c.getRight()));
        return c;
      }
      else { // k==vc   // found it... now figure out how to rearrange
        // cases
        if (c.getLeft()==null && c.getRight()==null) { c = null; this.size--; } // leaf
        else if (c.getLeft()==null && c.getRight()!=null) { c = c.getRight(); this.size--; } // RC only
        else if (c.getLeft()!=null && c.getRight()==null) { c = c.getLeft(); this.size--; } // LC only
        else { // 2 children
          Node mc = findMaxCell(c.getLeft());
          c.setValue(mc.getValue());
          c.setLeft(remove_r(c.getValue(), c.getLeft()));   // recurse
        }
        return c;
      }
    }
    // private recursive helper
    private Node findMaxCell(Node c) { 
      if (c.getRight()==null) return c;
      return findMaxCell(c.getRight());
    } 

  
   //====================================================================================
   //
   // The methods below here are part of the public BST interface we defined, 
   // but you will write the implementation code.
   // 
   // At the moment, they have return statements that return dummy values; this
   // is so they will compile, but those return values are just dummy behavior
   // you will replace the dummy returns with your own code and proper return values.
   //
   //====================================================================================

  
    @Override
    // interface method ==================================================
    public int insert(int val) {
        /*See BST.java for method specification */
        /*Your code here */
        /* Hint: Don't forget to update size */
        /* Hint: You can find examples of how to create a new Node object elsewhere in the code */
        //if the val is already in the tree just return val
        //if(this.contains(val)) {return val;}

        Node newNode = new NodeImpl(null, null, val);
        //System.out.println("insert called with value " + Integer.toString(newNode.getValue()));
        //empty list
        if (this.root == null) {
            this.root = newNode;
            this.size++;
            return val;
        }

        return this.recurI(val, this.root, newNode);

        /* non-recursive implementation
        boolean wentLeft = false;
        Node curr = this.root;

        for (boolean success = false; !success;) {
            System.out.println("entered loop with success = " + Boolean.toString(success) + " and size = " + Integer.toString(this.size));
            Node left = curr.getLeft();
            Node right = curr.getRight();
            Node prev = curr;

            //curr should end up in the position that newNode is supposed to be in
            //we just need to track where it came from and which direction it went
            //represented by prev, wentLeft
            if (left == null && right == null) {
                System.out.println("entered if statement, since left == null was " + Boolean.toString(left == null) + " and right == null was " + Boolean.toString(right == null));
                success = true;
                this.size++;
                if (wentLeft) {prev.setLeft(newNode);}
                else {prev.setRight(newNode);}
            }

            if (val < curr.getValue()) {curr = left; wentLeft = true;}
            else {curr = right; wentLeft = false;}


        }
         */
    }

    private int recurI(int val, Node c, Node newNode) {
        //base case
        Node left = c.getLeft();
        Node right = c.getRight();
        boolean goLeft;

        //System.out.println("Is " + Integer.toString(c.getValue()) + " more than " + Integer.toString(val) + "? " + Boolean.toString(c.getValue() > val));
        if (c.getValue() > val) goLeft = true;
        else goLeft = false;

        if (c.getValue() == val) return val;

        if ((left == null && goLeft) || (right == null && !goLeft)) {
            if (goLeft) {c.setLeft(newNode);}
            else {c.setRight(newNode);}
            this.size++;
            return val;
        }

        else {
            if (goLeft) return recurI(val, c.getLeft(), newNode);
            else return recurI(val, c.getRight(), newNode);
        }
    }

    @Override
    // interface method ==================================================
    public int findMin() {
        /*See BST.java for method specification */
        /* Your code here */
        if (this.root == null) {return Integer.MAX_VALUE;}
        else return findMin_r(this.root);
    }

    private int findMin_r(Node c) {
        Node left = c.getLeft();

        if (left == null) return c.getValue();
        else return findMin_r(left);
    }
    
    @Override
    // interface method ==================================================
    public int findMax() {
        /*See BST.java for method specification */
        /* Your code here */
        if (this.root == null) {return Integer.MAX_VALUE;}
        else return findMax_r(this.root);
    }

    private int findMax_r(Node c) {
        Node right = c.getRight();

        if (right == null) return c.getValue();
        else return findMax_r(right);
    }
    
    @Override
    // interface method ==================================================
    public Node get(int val) {
        /*See BST.java for method specification */
        /* Hint: Make sure you return a Node, not an int */
        /* Your code here */
        //edge cases
        if (this.root == null) return null;
        else if (this.root.getValue() == val) return this.root;

        //r func call
        else return get_r(val, this.root);
    }

    private Node get_r(int val, Node c){
        if (c.getValue() == val) return c;

        Node left = c.getLeft();
        Node right = c.getRight();

        if (val > c.getValue() && !(right == null)) return get_r(val, c.getRight());
        else if (val < c.getValue() && !(left == null)) return get_r(val, c.getLeft());
        else return null;

        /* this doesn't work because what if val doesn't exist
        else if (val > c.getValue()) return get_r(val, c.getRight());
        else return get_r(val, c.getLeft());
         */
    }
    
    @Override
    // interface method ==================================================
    public boolean isFullBT() {
        /*See BST.java for method specification */
        /* Hint: How can you "break-up" the problem into smaller pieces? */
        /* Your code here */
        if (this.root == null) return true;
        else return isFullTree_r(this.root);
    }

    private boolean isFullTree_r(Node c) {
        Node right = c.getRight();
        Node left = c.getLeft();
        //only one child
        if (right == null && !(left == null)) return false;
        else if (!(right == null) && left == null) return false;

        //no children
        else if (right == null && left == null) return true;

        //the only other case: two children
        return isFullTree_r(c.getLeft()) && isFullTree_r(c.getRight());
    }

    @Override
    // interface method ==================================================
    public int merge(BST nbt) {
        /*See BST.java for method specification */
      // Hint: traverse bst using pre-order
      // as each node is visited, take the value there
      // and do this.insert(value)
      // have to somehow count when an add is successful
      // so we can return the number of nodes added
         /* Your code here */
        int newSize = 0;
        if (nbt.getRoot() == null) return this.size;
        Node c = nbt.getRoot();
        int ret = merge_r(c, newSize);
        this.size += ret;
        return ret;
    }

    private int merge_r(Node c,  int hold) {
        //base case
        if (c.getLeft() == null && c.getRight() == null) {
            this.insert(c.getValue());
            hold++;
            //System.out.println("found no children. merge size currently is: " + hold);
            return hold;
        }

        //if only one node exists
       if (c.getLeft() == null && c.getRight() != null) {
           this.insert(c.getValue());
           hold++;
           hold = merge_r(c.getRight(), hold);
           //System.out.println("found one child. merge size currently is: " + hold);
           return hold;
       }

       if (c.getLeft() != null && c.getRight() == null) {
           this.insert(c.getValue());
           hold++;
           hold = merge_r(c.getLeft(), hold);
           //System.out.println("found one child. merge size currently is: " + hold);
           return hold;
       }

       //both nodes exist
       else {
           this.insert(c.getValue());
           hold++;
           hold = merge_r(c.getLeft(), hold);
           //System.out.println("processed left node. merge size currently is " + hold);
           hold = merge_r(c.getRight(), hold);
           //System.out.println("found two children. merge size currently is: " + hold);
           return hold;
       }
    }

    public int getMaxLeafHeightDiff () {
        /*See BST.java for method specification */
        /* Hint: Which of the methods you're given are most similar to this? */
        /* Your code here */
        if (this.root == null) return 0;
        if (this.root.getLeft() == null && this.root.getRight() == null) return 0;
        else {
            int max = getMaxLeafHeightDiff_max(this.root, 0);
            System.out.println(max);
            int min = getMaxLeafHeightDiff_min(this.root, 0);
            System.out.println(min);
            return max - min;
        }
    }

    private int getMaxLeafHeightDiff_min(Node c, int height){
        //base case
        if (c.getLeft() == null && c.getRight() == null) {
            return height;
        }

        //if only one node exists
        if (c.getLeft() == null && c.getRight() != null) {
            height ++;
            return getMaxLeafHeightDiff_min(c.getRight(), height);
        }

        if (c.getLeft() != null && c.getRight() == null) {
            height ++;
            return getMaxLeafHeightDiff_min(c.getLeft(), height);
        }

        //both nodes exist
        else {
            height++;
            int a = getMaxLeafHeightDiff_min(c.getLeft(), height);
            int b = getMaxLeafHeightDiff_min(c.getRight(), height);
            if (a<b) return a;
            else return b;
        }
    }

    private int getMaxLeafHeightDiff_max(Node c, int height) {
         //base case
        if (c.getLeft() == null && c.getRight() == null) {
            return height;
        }

        //if only one node exists
       if (c.getLeft() == null && c.getRight() != null) {
           height ++;
           return getMaxLeafHeightDiff_max(c.getRight(), height);
       }

       if (c.getLeft() != null && c.getRight() == null) {
           height ++;
           return getMaxLeafHeightDiff_max(c.getLeft(), height);
       }

       //both nodes exist
       else {
           height++;
           int a = getMaxLeafHeightDiff_max(c.getLeft(), height);
           int b = getMaxLeafHeightDiff_max(c.getRight(), height);
           if (a>b) return a;
           else return b;
       }
    }
}
