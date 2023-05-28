/* You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0. In one operation:
? choose an index i such that 0 <= i < nums.length,
? increase your score by nums[i], and
? replace nums[i] with ceil(nums[i] / 3).
Return the maximum possible score you can attain after applying exactly k operations. The ceiling function ceil(val)
is the least integer greater than or equal to val.
* Eg 1 : nums = [10,10,10,10,10]               k = 5              Output = 50
* Eg 2 : nums = [1,10,3,3,3]                   k = 3              Output = 16
*/
import java.util.*;
public class Maximal
{
      public int MaximumScore(int nums[], int k)
      {
            PriorityQueue<Integer> MaxHeap = new PriorityQueue<Integer>((a, b) -> b - a);    //*  Max Heap -> O(N)
            for(int i = 0; i < nums.length; i++)     //! Evaluation -> O(N)
                  MaxHeap.add(nums[i]);
            int sum = 0, val = 0;          //*   Variable -> O(1)
            while(k != 0)            //! Evaluation -> O(k)
            {
                  sum = sum + MaxHeap.peek();     // Adding the maximum element
                  val = MaxHeap.peek();
                  MaxHeap.remove();
                  k--;
                  MaxHeap.add((int)(Math.ceil(val / 3)));    // Adding the 1/3 rd of element into the element...
            }
            return sum;
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter array length : ");
            x = sc.nextInt();
            int array[] = new int[x];
            for(int i = 0; i < array.length; i++)
            {
                  System.out.print("Enter number : ");
                  array[i] = sc.nextInt();
            }
            System.out.print("Enter the value of k : ");
            x = sc.nextInt();
            Maximal maximal = new Maximal();
            System.out.println("The Maximal Score possible  : "+maximal.MaximumScore(array, x));
            sc.close();
      }
}



//! Time Complexity -> O(N + k)
//* Space Complexity -> O(N)