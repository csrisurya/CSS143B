

## 2020 Winter CSS143B Midterm 2 &nbsp; &nbsp; &nbsp; Student Name:

**All choice questions are single choice**

**By "array" or "Java array", it means the primitive Java array like int[], not collection like ArrayList**

**1. (2pt) Which of the following is true comparing linked lists with Java arrays? (A)**

- (A) Accessing a random node in a linked list requires, in the worst-case, a full traverse of the list.
- (B) You can implement a stack using a linked list but not an array.
- (C) Both linked lists and arrays are random-access data structures.
- (D) Linked list and array can both change size as needed.

**2. (2pt) Which of the following naturally suggests a recursive solution? (B)**

- (A) Printing a message to the console.
- (B) Printing all valid combination of parentheses of *n* pairs
- (C) Multiplication of two numbers.
- (D) Linear search over a set of characters.

**3.（2pt) When implementing a Stack ADT using a linked list vs array, which statement is wrong? (C)**

- (A) Array is faster for push and pop because linkedlist requires traversal to access nodes
- (B) Linkedlist is better in terms of flexible stack size
- (C) Array and linked list can have equally quick pop and push implementation
- (D) Stack using linked list has slightly higher storage overhead comparing to array due to the additional node references

**4. (2pt) Which of the following is NOT true for a single linked list? (D)**

- (A) It has to have a dummy node
- (B) It can be used to implement both Stack and Queue
- (C) Each node exists in heap memory
- (D) Each node can hold various kind of values such as int, float or class object by its reference.

**5. (2pt) Which of the following is NOT true for binary tree? (A) (C) both okay**

- (A) It can only have one root node
- (B) Each node can only have one parent node
- (C) Each node can only have two childern nodes
- (D) It can be traversed in more than one ways

**6. (15pt) Write the code to reverse a single linked list ITERATIVELY.** 

Definition for the list node is

```java
 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
```

Assume the linked list **has dummy node**. The reverse function also:

- ***CANNOT*** use any collection such as array, stack, queue
- ***CANNOT*** create any new node
- ***CANNOT*** change the content of val in any node
- ***CANNOT*** use recursion

```java
class Solution {
    public ListNode reverse(ListNode head) {
        ListNode p1 = head.next;
        ListNode p2 = p1.next;
        while (p2 != null) {
            p1.next = p2.next;
            p2.next = head.next;
            head.next = p2;
            p2 = p1.next;
        }
    }
}
```

**7. (2pt) Given the following code**

```java
        int id = 23;
        String pName = "Jon";
        List p = null;
        p = new ArrayList();
```

Which of the following is wrong:  **(A)**

- (A) Variable *p* is in heap memory.
- (B) Variable *id* is in stack memory.
- (C) Variable *pName* is in stack memory.
- (D) The ArrayList that reference *p* points to is in heap memory.

**8.(2pt) Which of the following is wrong about heap and stack memory? (B)**

- (A) Local variables of function call are stored in stack memory.
- (B) Usually stack memory has no size limit but heap does.
- (C) Class objects are held in heap.
- (D) StackOverFlow happens when stack memory is exhausted.

**9.(2pt) Which of the following is wrong about recursion? (A)**

- (A) It is always more efficent in performance than iterative method for solving the same problem
- (B) It requires a stopping condition till the problem is small enough to be solved without recursion
- (C) Backtracking is a kind of recursion algorithm
- (D) A recursion solution can also be implemented iteratively using a stack ADT

**10. (4pt) Describe how quicksort works and explain its relation to recursion**

```bash
select a pivot, move elements smaller than the pivot to its left, larger to its right
repeat the same process on both the sub-arrays on the left and right of the pivot 
```

**11. (15pt) Write code to find the height of a binary tree**

The height of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node. For example, given the following tree:

```bash
    3
   / \
  9  20
    / 
   15   
```

The height of the tree is 3. The definition of a binary tree is

```java
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
```

```java
class Solution {
    public int height(TreeNode root) {
    		if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
```

**12. (15pt) What is the pre-order, in-order and post-order traversal of the following tree**

```bash
          2
        /   \
       4     5
        \     \
         1     3
              /
             6
```

pre-order: 2 4 1 5 3 6



In-order: 4 1 2 5 6 3



post-order: 1 4 6 3 5 2



**13. (10pt) What is the definition of a binary search tree? How would you check if a given tree is a binary search tree?**

```bash
for each node:
	The left subtree of a node contains only nodes with keys lesser than the node’s key.
	The right subtree of a node contains only nodes with keys greater than the node’s key.
	The left and right subtree each must also be a binary search tree.
```

**14. (5pt) If a binary search tree is too out-of-balance like the following tree, how could this affect the search performance using this tree?**

Here's an example out-of-balance binary search tree:

```bash
       2
        \
         3
          \
           4
            \
             5
```

search performance is close to linear time 
**note to Max**: we haven't officially talked about big O yet so it's okay they don't mention O(nlgn) or O(n)

**15. (5pt) What is the difference in internal data structure choice between the ArrayList and LinkedList from java.util? And for a problem that will repeatedly add or remove data, which one should you choose and why?**

**Note to Max**: I will grade this one


**16. (15pt) Answer the following questions about the climbing stair problem**

For a staircase with  *n (n>0)* steps. If each time you can either climb 1 or 2 steps. 

Write the code to calculate how many unique ways can you climb to the top **recursively**.

```java
class Solution {
  public int climbStairs(int n) {
        if (n==1) return 1;
    		if (n==2) return 2;
    		return climbStairs(n-1) + climbStairs(n-1);   
  }
}
```

This recursive solution is not efficient in terms of performance. The running time grows exponentially as *n* becomes larger. What is the reason? And how would you fix it?

```bash
reason: repeated subproblem. same subprobem being calculated repeatedly

fix: "dynamic programming"
no recursion. going from the beginning iteratively 
```

**17. (5pt) EXTRA CREDIT: Which movie was mentioned in class when we talk about recursion as an example?**

**Note to Max**: I will grade this one


