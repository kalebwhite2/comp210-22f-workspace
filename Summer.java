package a1;

/* Do not remove any code that is here.
 You may add new code if you wish to
 new data fields or helper methods. 
 Also note that this skeleton will not compile as is,
 since the methods that return things do not contain
 return statements... so you need to add them.
*/

import java.util.Arrays;

public class Summer {
   private int[] nums;
   // Any other data fields you decide you need can go here.
   private int nextIndex;

   public Summer(int n) {
      /* In this constructor, first allocate an array that hold n ints and put that in nums.
      Hint: If you add an extra field to store the index of the next open slot in the array,
      you would need to do something with that field here.
      */
      /*Your code here */
      nums = new int[n];
      nextIndex = 0;
   }

   public void add( int num ) {
     // In this method, take the parameter num and put that value into the Summer.
      /*Your code here */
      nums[nextIndex] = num;
      nextIndex++;
   }
   
   public int sum ( ) { 
     /* In this method, go through the array and add up all the ints
      that have been stored in it so far.
      Note that the sum of ints is of type int, so return the int sum you get.  */

      /*Your code here*/
      int sum = 0;
      for (int num : nums) {
         sum += num;
      }
      return sum;
   }
   
   public int high ( ) { 
     /* Find the largest number stored in the array so far
      and return it. */

      /*Your code here */
      //
      int high = Integer.MIN_VALUE;
      int[] subset = Arrays.copyOf(nums, nextIndex - 1);
      for (int num : subset) {
         if (num > high) {
            high = num;
         }
      }

      //edge-case for empty array
      if (high == Integer.MIN_VALUE) {
         high = 0;
      }

      return high;
   }
   
   public int low ( ) { 
     /* Find the smallest number stored in the array so far
      and return it. */

      /*Your code here */
      int low = Integer.MAX_VALUE;
      int[] subset = Arrays.copyOf(nums, nextIndex - 1);
      for (int num : subset) {
         if (num < low) {
            low = num;
         }
      }

      //edge-case for empty array
      if (low == Integer.MAX_VALUE) {
         low = 0;
      }

      return low;
   }
   
   public double average( ) {
     /* Find the average of all the numbers stored in the array
      so far, and return it.
      Note that the average of ints might produce a double, so
      we are returning a double.
     
      HEADS UP
      This method might get called before there are any 
      ints stored in the array, so you need to guard
      against divide by zero.
      We will simply define the average of no numbers
      to be 0.0 so return that if the array has no numbers in it.
       */

      /*Your code here */
      //guarding against no-value array edge case
      if (nums.length == 0) {
         return 0.0;
      }

      //guarding against initialized array with no values filled in, in all instances of which the sum of the array will be 0
      int sumOfArray = 0;
      for (int integer: nums) {
         sumOfArray += integer;
      }
      if (sumOfArray == 0) {
         return 0.0;
      }

      //tried to standardize this to make it easier to figure out what was going wrong
      else {
         double sumOfNumbers = 0.0;

         for (int integer: nums) {
            sumOfNumbers += integer;
         }

         return sumOfNumbers / nextIndex;
      }
   }
   
   public double avgOver( int thresh ) {

   /* Similar to average() except we want to only average up
      stored numbers that are ABOVE ( > ) the threshold
      parameter "thresh".
      
      Hint: Look at examples 1 and 2 in the readme make sure you 
      understand how to calculate avgOver.
     
      HEADS UP
      We have the same divide by zero issue here as in average()
      so again if you are trying to take an average on no numbers
      simply return 0.0
   */

      /*Your code here */
      double sumOfNumbers = 0.0;
      for (int integer: nums) {
         if (integer > thresh) {
            sumOfNumbers += integer;
         }
      }
      if (sumOfNumbers == 0) {
         return 0.0;
      }

      //also tried to standardize here to figure out what's happening
      else {
         return sumOfNumbers / nextIndex;
      }

   }
   
   public int count ( ) {  
     //Return the number of ints that have been stored in the array.
       
     /*Your code here */
      return nextIndex;
   }
}
