// Question 1: Cumulative Multiple of an Array with exception handling
import java.util.Arrays;

public class CumulativeMultipleArray {
    public static void main(String[] args) {
        int[] arrNum = {5, 3, 4, 2, 0, 8};

        try {
            calculateCumulativeMultiple(arrNum);
            System.out.println("arrNum = " + Arrays.toString(arrNum));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void calculateCumulativeMultiple(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array is empty.");
        }

        int cumulativeMultiple = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                // If any element is zero, all subsequent elements will be zero as well
                cumulativeMultiple = 0;
                break;
            }
            cumulativeMultiple *= arr[i];
            arr[i] = cumulativeMultiple;
        }
    }
}


// Question 2: Find missing numbers in array -
import java.util.ArrayList;
import java.util.List;

public class MissingNumbersArray {
    public static void main(String[] args) {
        int[] arrNum1 = {1, 2, 4, 5, 6};
        int[] arrNum2 = {1, 2, 3, 5, 6, 8, 10, 11, 14};

        System.out.println("Missing numbers in arrNum1: " + findMissingNumbers(arrNum1));
        System.out.println("Missing numbers in arrNum2: " + findMissingNumbers(arrNum2));
    }

    public static List<Integer> findMissingNumbers(int[] arr) {
        List<Integer> missingNumbers = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return missingNumbers;
        }

        int n = arr.length;
        int expectedNumber = arr[0];
        for (int i = 0; i < n; i++) {
            while (arr[i] != expectedNumber) {
                missingNumbers.add(expectedNumber);
                expectedNumber++;
            }
            expectedNumber++;
        }

        return missingNumbers;
    }
}


// Question 3: Find the count of singulars in array -
import java.util.HashMap;
import java.util.Map;

public class SingularSocksCount {
    public static void main(String[] args) {
        int[] arrNum = {10, 20, 20, 10, 10, 30, 50, 10, 20};

        int singularSocksCount = findSingularSocksCount(arrNum);
        System.out.println("Count of singular socks = " + singularSocksCount);
    }

    public static int findSingularSocksCount(int[] arr) {
        Map<Integer, Integer> pairsCount = new HashMap<>();

        // Count the number of pairs for each sock ID
        for (int sockId : arr) {
            pairsCount.put(sockId, pairsCount.getOrDefault(sockId, 0) + 1);
        }

        // Calculate the count of singular socks
        int singularSocksCount = 0;
        for (int count : pairsCount.values()) {
            if (count % 2 != 0) {
                singularSocksCount++;
            }
        }

        return singularSocksCount;
    }
}

// Question 4: Java Subarray
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] array1= new int[n];
    for(int i=0;i<n;i++){
        array1[i]=sc.nextInt();
    }
    int count=0;
    for(int j=0;j<n;j++){
        int sum=0;
        for(int k=j;k<n;k++){
            sum=array1[k]+sum;
            if(sum<0){
                count++;
            }
        }
    }
    System.out.println(count);
    }
}

// Question 5: Merge and Sort the elements in two Linked-List
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}


public class MergeAndSortLinkedLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(25);
        head1.next = new ListNode(35);
        head1.next.next = new ListNode(12);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(36);
        head1.next.next.next.next.next = new ListNode(48);

        ListNode head2 = new ListNode(8);
        head2.next = new ListNode(32);
        head2.next.next = new ListNode(22);
        head2.next.next.next = new ListNode(45);
        head2.next.next.next.next = new ListNode(63);
        head2.next.next.next.next.next = new ListNode(49);

        ListNode mergedHead = mergeLinkedLists(head1, head2);
        ListNode sortedHead = sortLinkedList(mergedHead);

        printLinkedList(sortedHead);
    }

    public static ListNode mergeLinkedLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        if (head1.val <= head2.val) {
            head1.next = mergeLinkedLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeLinkedLists(head1, head2.next);
            return head2;
        }
    }

    public static ListNode sortLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;

        ListNode left = sortLinkedList(head);
        ListNode right = sortLinkedList(nextOfMiddle);

        return merge(left, right);
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode mergedHead = new ListNode(0);
        ListNode current = mergedHead;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        }
        if (head2 != null) {
            current.next = head2;
        }

        return mergedHead.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("null");
    }
}

// Question 6: Remove Duplicates from Linked-List
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

public class RemoveDuplicatesFromLinkedLists {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(5);
        head.next.next = new ListNode(12);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next = new ListNode(5);

        ListNode uniqueHead = removeDuplicates(head);

        printLinkedList(uniqueHead);
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("null");
    }
}


// Question 7: Longest Palindromic Substring
class Solution {
  public String longestPalindrome(String s) {
    if (s.isEmpty())
      return "";

    // [start, end] indices of the longest palindrome in s
    int[] indices = {0, 0};

    for (int i = 0; i < s.length(); ++i) {
      int[] indices1 = extend(s, i, i);
      if (indices1[1] - indices1[0] > indices[1] - indices[0])
        indices = indices1;
      if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
        int[] indices2 = extend(s, i, i + 1);
        if (indices2[1] - indices2[0] > indices[1] - indices[0])
          indices = indices2;
      }
    }

    return s.substring(indices[0], indices[1] + 1);
  }

  // Returns [start, end] indices of the longest palindrome extended from s[i..j]
  private int[] extend(final String s, int i, int j) {
    for (; i >= 0 && j < s.length(); --i, ++j)
      if (s.charAt(i) != s.charAt(j))
        break;
    return new int[] {i + 1, j - 1};
  }
}

// Question 8: Java Stack
import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Solution{
	
	public static void main(String []argh){
        public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length();++i){
            if (s.charAt(i) == '(') stack.push('(');
            else if (s.charAt(i) == '{') stack.push('{');
            else if (s.charAt(i) == '[') stack.push('[');
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '(') return false;
            }
            else if (s.charAt(i) == '}') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '{') return false;
            }
            else if (s.charAt(i) == ']') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        String line;
        while (sc.hasNextLine()){
            line = sc.nextLine();
            if (isBalanced(line)) System.out.println("true");
            else System.out.println("false");
        }
    }
}

// Question 9: Java Dequeue

// Question 10: Java Priority Queue
// Question 11: Swap Nodes in Pairs
// Question 12: Reverse Nodes in k-Group
