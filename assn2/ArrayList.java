package assn2;

public class ArrayList implements List {
   private double[] elts;
   private int size = 0;
   private int MAX = 1000;

   // default constructor makes an array with MAX elements
   public ArrayList ( ) {
      this.elts = new double[this.MAX];
      this.size = 0;
   }
   
   // alternate constructor allows specific array size to be created
   public ArrayList (int MAX) {
      this.elts = new double[MAX];
      this.size = 0;
      this.MAX = MAX;
   }

	
//================================================================= 
  // You will implement the 4 methods below for assignment 2.
  // IMPORTANT: Note that the methods are provided with default 
  // return values (e.g., "-1" for findLast) so that the code will
  // initially compile.  You should remove the default return value
  // when you implement the methods.
//=================================================================
    
   
  public boolean set ( int index, double element ) {
      //See List.java for a description of the method's behavior and examples.
      //Hint: Ask yourself how this is different from the "ins" method.
      //Hint: Remember that we start indexing with 0 rather than 1.

      /*Your code here */	
	if (index >= this.size) {
        return false;
    }
    else {
        this.elts[index] = element;
        return true;
    }
  }
      
  public int findLast ( double element ) {
    //See List.java for a description of the method's behavior and examples.
    //Hint: Make sure you understand how this is different from find
	  
    /*Your code here */
      // one variable to hold the last index, one to record whether it was found or not
      int lastIndex = 0;
      boolean foundIndex = false;

      //look for any index where that element equals the parameter element and replace lastIndex if it does
      //also set foundIndex to true
      for (int i  = 0; i < this.size; i++) {
          if (elts[i] == element) {lastIndex = i; foundIndex = true;}
      }

      // if found, return where found at, if not return -1
      if (foundIndex) {
          return lastIndex;
      }
      else {
          return -1;
      }
  }

  public boolean inSort ( double elt ) {
    //See List.java for a description of the method's behavior and examples.

    /*Your code here */
      // empty list
      if (this.isEmpty()) {this.ins(0, elt); return true;}
      // smaller than head
      else if (this.elts[0] > elt) {this.ins(0, elt); return true;}

      //inSort
      for (int i  = 0; i < this.size; i++) {
          //we will want to check i and i+1, not i and i-1, because i starts at 0
          if (elts[i] <= elt && elts[i+1] > elt){
              boolean succeedAdd = this.ins(i+1,elt);
              return succeedAdd;
          }
      }

      //if the last index (this.size()-1) is less than or equal to elt, insert elt
      //at the end of the list (the index of which is this.size()).
      //this assumes that there is no case in which elt can be bigger
      //than some element in the list and be smaller than the last element
      if (this.elts[this.size()-1] <= elt) {
          boolean succeedAdd = this.ins(this.size(),elt);
          return succeedAdd;
        }
      else { return false; }
  }
   
  public boolean bubbleIns  ( double elt ) {

    //See List.java for a description of the method's behavior and examples.
    //Hint: Do any of the methods you're already given help? 

    /*Your code here */
      // for tracking whether the list changes worked
      boolean succeedAdd;

      int index = this.find(elt);
      // if it found an index (indicated by it not not finding an index), remove that one
      if (!(index == -1)) {this.rem(index);}
      else {this.size++;}
      succeedAdd = this.ins(0, elt);

      //if add succeeded, return true
      if (succeedAdd) {return true;}
      else {return false;}
  }
	
   /* Implementation given to you. Do not modify below this. */
   
	@Override
   public boolean ins(int index, double element) { 
      if (index<0 || index>size || index>=this.MAX) { return false; }
      for (int i=this.size; i>=index; i--) {
         this.elts[i+1] = this.elts[i];
      }
      this.elts[index] = element;
      this.size++;
      return true;
   }
   
	@Override
   public boolean rem(int index) { 
      if (index>=size || index<0 || index>=this.MAX) { return false; }
      for (int i=index; i<size; i++) {
         this.elts[i] = this.elts[i+1];
      }
      this.size--;
      return true;
   }
   
	@Override
   public int size() { return this.size; }
   
   @Override
   public void clear() { this.size = 0; }
   
	@Override
   public boolean isEmpty() { return this.size == 0; }

	@Override
   public double get(int index) { 
      if (index<0 || index>=size || index>=this.MAX) { return Double.NaN; }
      return this.elts[index];
   }
	@Override
   public int find( double element ) { 
      int loc = -1;
      for (int i=0; i<size; i++) {
         if (this.elts[i]==element) { loc=i; break; }
      }
      return loc; 
   }
   
	@Override  
   public boolean contains ( double element ) {
      boolean res = false;
      for (int i=0; i<size; i++) {
         if (this.elts[i]==element) { res = true; break; }
      }
      return res;
   }

   /* prints out list */
   public String toString() { 
     if (this.size==0) { return "[empty]"; }
     String res = ""; 
     for (int i=0; i<size; i++) {
       res = res+this.elts[i]+", ";
     } 
     return res;
   }
     
}
