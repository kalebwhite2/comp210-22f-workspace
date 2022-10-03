package a3;

public class Tester {

  public void merge(BST ot) {
    BST nt = new BSTImpl();
    int[] v1 = new int[]{55, 25, 105, 45, 1135, 15};
    for (int v : v1) {
      ot.insert(v);
    }
    int[] v2 = new int[]{5, 3, 8, 2, 6, 1, 9, 4};
    for (int v : v2) {
      nt.insert(v);
    }
    Print.tree(ot);
    Print.tree(nt);
    System.out.println("merge returned " + ot.merge(nt) + " when it should have returned " + nt.size());
    Print.tree(ot);

    nt = new BSTImpl();
    Print.tree(nt);
    v1 = new int[]{107, 27, 1137, 77, 457, 7};
    for (int v : v1) {
      nt.insert(v);
    }
    Print.tree(nt);
    System.out.println("merge returned " + ot.merge(nt) + " when it should have returned " + nt.size());
    Print.tree(ot);

    v1 = new int[]{1137, 7, 55, 105, 1138, 5, 25, 9}; // 8 elements, 7 dupes, 1 new one
    for (int v : v1) {
      nt.insert(v);
    }
    System.out.println("merge returned " + ot.merge(nt) + " when it should have returned " + nt.size());
    Print.tree(ot);

  }

  public void emptyTree(BST bst) {
    System.out.println("\n== testing emptyTree =================");

    System.out.print((bst.size() == 0));
    System.out.println("   size: " + bst.size());

    System.out.print((bst.height() == -1));
    System.out.println("   height: " + bst.height());
  }

  public void insert(BST bst) {
    System.out.println("\n== testing insert ====================");

    int[] insertions = new int[]{17, 8, 34, 3, 77, 19, 5, 11};
    for (int dval : insertions) {
      bst.insert(dval);
    }

    Print.tree(bst);
    System.out.print((bst.size() == 8));
    System.out.println("   size: " + bst.size());
    System.out.print((bst.height() == 3));
    System.out.println("   height: " + bst.height());

    System.out.println(bst.contains(3));
    System.out.println(bst.contains(44));

    System.out.println(bst.contains(11));
    bst.remove(34);
    Print.tree(bst);
    System.out.println(bst.height());
    System.out.println(bst.size());
    System.out.println(bst.contains(34));

    bst = new BSTImpl();
    Print.tree(bst);
    System.out.print((bst.size() == 0));
    System.out.println("   size: " + bst.size());
    System.out.print((bst.height() == -1));
    System.out.println("   height: " + bst.height());
    System.out.println(bst.contains(34));
    bst.insert(34);
    Print.tree(bst);
    System.out.print((bst.size() == 1));
    System.out.println("   size: " + bst.size());
    System.out.print((bst.height() == 1));
    System.out.println("   height: " + bst.height());
    System.out.println(bst.contains(34));

    bst = new BSTImpl();
    int[] i2 = new int[]{88, 88, 88, 88, 44, 44, 44, 44, 91, 2, 37, 41};
    for (int dval : i2) {
      bst.insert(dval);
    }

    Print.tree(bst);
    System.out.print((bst.size() == 6));
    System.out.println("   size: " + bst.size());
    System.out.print((bst.height() == 4));
    System.out.println("   height: " + bst.height());

    bst = new BSTImpl();
    int[] i3 = new int[]{87, 128, 145, 46, 44, 45, 147};
    for (int dval : i3) {
      bst.insert(dval);
    }
    Print.tree(bst);
  }

  public void get(BST bst) {
    System.out.println("\n== testing get ====================");

    int[] insertions = new int[]{17, 8, 34, 3, 77, 19, 5, 11};
    for (int dval : insertions) {
      bst.insert(dval);
    }
    Print.tree(bst);

    System.out.println(Boolean.toString(bst.get(33) == null) + " should be true");
    Node t = bst.get(8);
    System.out.println(t.getLeft().getValue() + " should be 3");

    bst = new BSTImpl();
    int[] i2 = new int[]{5, 2, 21, 1};
    for (int dval : i2) {
      bst.insert(dval);
    }
    Print.tree(bst);

    System.out.println(Boolean.toString(bst.get(33) == null) + " should be true");
    Node t2 = bst.get(2);
    System.out.println(t2.getValue() + " should be 2");
  }

  public void remove(BST bst) {
    System.out.println("\n== testing remove ====================");

    Print.tree(bst);
    System.out.println(bst.height());
    System.out.println(bst.size());

    System.out.println(bst.contains(3));
    System.out.println(bst.contains(44));

    System.out.println(bst.contains(11));
    bst.remove(34);
    Print.tree(bst);
    System.out.println(bst.height());
    System.out.println(bst.size());
    System.out.println(bst.contains(34));
  }

  public void isFullBT(BST bst) {
    int[] insertions = new int[]{17, 8, 34, 3, 77, 19, 5, 11};
    for (int dval : insertions) {
      bst.insert(dval);
    }

    Print.tree(bst);
    System.out.println(Boolean.toString(bst.isFullBT()) + " should be false");

    insertions = new int[]{11, 5, 16, 2, 8, 14, 18, 1, 3, 6, 9, 12, 15, 17, 19};
    bst = new BSTImpl();
    for (int dval : insertions) {
      bst.insert(dval);
    }

    Print.tree(bst);
    System.out.println(Boolean.toString(bst.isFullBT()) + " should be true");
  }

  public void findMin(BST bst) {
    System.out.println("\n== testing findMin ====================");

    int[] insertions = new int[]{13, 9, 24, 7, 28, 8, 29, 31};
    for (int dval : insertions) {
      bst.insert(dval);
    }

    Print.tree(bst);

    System.out.println((bst.findMin() == 7) + " should be true. findMin() returned " + bst.findMin());

  }

  public void findMax(BST bst) {
    System.out.println("\n== testing findMin ====================");

    int[] insertions = new int[]{13, 9, 24, 7, 28, 8, 29, 31};
    for (int dval : insertions) {
      bst.insert(dval);
    }

    Print.tree(bst);

    System.out.println((bst.findMax() == 31) + " should be true. findMax() returned " + bst.findMax());

  }

  public void getMaxLeafHeightDiff(BST bst) {
    System.out.println("\n== testing getMaxLeafHeightDiff ====================");

    int[] insertions = new int[]{17, 8, 37, 2, 21, 39, 6};
    for (int dval : insertions) {
      bst.insert(dval);
    }

    Print.tree(bst);

    System.out.println((bst.getMaxLeafHeightDiff() == 1) + " should be true. getMaxLeafHeightDiff() returned " + bst.getMaxLeafHeightDiff());


    bst = new BSTImpl();
    int[] i2 = new int[]{43, 9, 2};
    for (int dval : i2) {
      bst.insert(dval);
    }

    Print.tree(bst);

    System.out.println((bst.getMaxLeafHeightDiff() == 0) + " should be true. getMaxLeafHeightDiff() returned " + bst.getMaxLeafHeightDiff());

  }
}



