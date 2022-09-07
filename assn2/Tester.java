package assn2;

public class Tester {
   
   public void ins ( List ls ) {
      System.out.println("== Test of ins op ==========");
      ls.clear();
      System.out.println(ls.ins(0,10.0)); 
      System.out.println(ls);
      ls.ins(0,11.1); ls.ins(1,12.2);
      System.out.println(ls);
      System.out.println(ls.ins(14,111.1));
      System.out.println(ls.ins(3,101.01));
      System.out.println(ls); 
      return;
   }
   
   public void rem (List ls) {
     System.out.println("== Test of rem op ==========");
     ls.clear();
     System.out.println(ls.rem(0)); 
     System.out.println(ls);
     ls.ins(0,11.1); ls.ins(1,12.2); ls.ins(2,13.3);
     System.out.println(ls);
     System.out.println(ls.rem(0));
     System.out.println(ls.rem(1));
     System.out.println(ls); 
     System.out.println(ls.size());
     ls.ins(0,14.4); ls.ins(1,17.7);
     System.out.println(ls);
     System.out.println(ls.rem(1));
     System.out.println(ls); 
     System.out.println(ls.rem(100));
     System.out.println(ls);
     return;
   }
   
   public void get (List ls) {
     System.out.println("== Test of get op ==========");
     ls.clear();
     System.out.println(ls.get(0)); 
     System.out.println(ls);
     ls.ins(0,11.1); ls.ins(1,12.2); ls.ins(2,13.3);
     System.out.println(ls);
     System.out.println(ls.get(0));
     System.out.println(ls.get(1));
     System.out.println(ls.get(100));
     System.out.println(ls); 
     System.out.println(ls.size());
     ls.ins(0,14.4); ls.ins(1,17.7);
     System.out.println(ls);
     System.out.println(ls.get(1));
     System.out.println(ls); 
     System.out.println(ls.get(-100));
     System.out.println(ls);
     return;
   }
   
   public void find (List ls) {
     System.out.println("== Test of find op =========");
     ls.clear();
     System.out.println(ls.find(12.2));
     ls.ins(0,11.1);
     System.out.println(ls.find(11.1));
     System.out.println(ls.find(12.2));
     ls.ins(0,22.2); ls.ins(1,33.3); ls.ins(0,44.4);
     System.out.println(ls.find(33.3));
     System.out.println(ls.find(11.1));
     System.out.println(ls.find(-5.5));
     ls.clear();
     System.out.println(ls.find(11.1));
     return;
   }

   public void isEmpty (List ls) {
      System.out.println("== Test of isEmpty op =======");
      ls.clear();
      System.out.println(ls.isEmpty());
      ls.ins(0,1.1);
      System.out.println(ls.isEmpty());
      ls.ins(0,2.2);
      System.out.println(ls.isEmpty());
      ls.rem(0);
      System.out.println(ls.isEmpty());
      ls.rem(100);
      System.out.println(ls.isEmpty());
      ls.rem(0);
      System.out.println(ls.isEmpty());
      return;
   }
   
   public void contains(List ls) {
      System.out.println("== Test of contains op ======");
      ls.clear();
      return;
   }
   
   public void size (List ls) {
      System.out.println("== Test of size op ==========");
      ls.clear();
      System.out.println(ls.size());
      ls.ins(0,1.1); System.out.println(ls.size());
      ls.ins(0,2.2); System.out.println(ls.size());
      for (int i=2; i<20; i++) { ls.ins(i,i*1.1); }
      System.out.println(ls.size());
      for (int i=0; i<5; i++) { ls.rem(0); }
      System.out.println(ls.size());
      ls.clear();
      System.out.println(ls.size());
      return;
   }
   
   public void clear (List ls) {
      System.out.println("== Test of clear op =========");
      System.out.println(ls.size());
      double n = ls.get(0);
      System.out.println(ls.find(n));
      ls.clear();
      System.out.println(ls.size());
      System.out.println(ls.get(0));
      System.out.println(ls.get(100));
      System.out.println(ls.find(n));
      return;
   }

   public void set (List ls) {
       System.out.println("== Test of set =========");
       ls.clear();
       ls.ins(0,8.2); ls.ins(1,-7.3); ls.ins(2,3.4); ls.ins(3, 5.0); ls.ins(4,3.4);ls.ins(5,2.1);
       System.out.println(ls.set(2, 1.9));
       System.out.println(ls.get(0) + " should be 8.2");
       System.out.println(ls.get(1) + " should be -7.3");
       System.out.println(ls.get(2) + " should be 1.9");
       System.out.println(ls.get(3) + " should be 5.0");
   }

    public void findLast (List ls) {
        System.out.println("== Test of findLast =========");
        ls.clear();
        ls.ins(0,8.2); ls.ins(1,-7.3); ls.ins(2,3.4); ls.ins(3, 5.0); ls.ins(4,3.4);ls.ins(5,2.1);
        System.out.println(ls.findLast(3.4) + " should be 4");
        System.out.println(ls.findLast(1.2) + " should be -1");
    }

    public void inSort (List ls) {
        System.out.println("== Test of inSort =========");
        ls.clear(); //3.1, 5.5, 18.2, 23.01 --> 3.1, 5.5, 7.1, 18.2, 23.01
        ls.ins(0,3.1); ls.ins(1,5.5); ls.ins(2,18.2); ls.ins(3, 23.01);
        System.out.println("== Test 1 ==");
        System.out.println(ls.inSort(7.1));
        System.out.println(ls.get(1) + " should be 5.5");
        System.out.println(ls.get(2) + " should be 7.1");
        System.out.println(ls.get(3) + " should be 18.2");
        System.out.println("== Test 2 ==");
        ls.rem(2); //3.1, 5.5, 18.2, 23.01 --> 3.1, 5.5, 18.2, 23.01, 55.2
        System.out.println(ls.inSort(55.2));
        System.out.println(ls.get(3) + " should be 23.01");
        System.out.println(ls.get(4) + " should be 55.2");
        System.out.println("== Test 3 ==");
        ls.clear();
        ls.ins(0,1.2); ls.ins(1,5.5); ls.ins(2,17.03); ls.ins(3, 12.8); ls.ins(4, 6.6);
        System.out.println(ls.inSort(19.0));
        System.out.println(ls.get(4) + " should be 6.6");
        System.out.println(ls.get(5) + " should be 19.0");
    }

    public void bubbleIns (List ls) {
        System.out.println("== Test of bubbleIns =========");
        ls.clear();
        ls.ins(0,11.3); ls.ins(1,45.1); ls.ins(2,-5.6); ls.ins(3, 17.3);
        System.out.println("== Test 1 ==");
        System.out.println(ls.bubbleIns(21.0));
        System.out.println(ls.get(0) + " should be 21.0");
        System.out.println(ls.get(1) + " should be 11.3");
        System.out.println("== Test 2 ==");
        ls.rem(0);
        System.out.println(ls.bubbleIns(-5.6));
        System.out.println(ls.get(2) + " should be 45.1");
        System.out.println(ls.get(0) + " should be -5.6");
        System.out.println("== Test 3 ==");
        ls.rem(0); ls.ins(2,-5.6); ls.ins(4,45.1); ls.ins(5,11.3);
        System.out.println(ls.bubbleIns(45.1));
        System.out.println(ls.get(0) + " should be 45.1");
        System.out.println(ls.get(1) + " should be 11.3");
        System.out.println(ls.get(4) + " should be 45.1");
        System.out.println(ls.get(5) + " should be 11.3");
    }

}
