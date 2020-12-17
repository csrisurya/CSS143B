## 2020 Fall CSS143B Final Exam

**All choice questions are single choice**

**1. (2pt) Which of the following statements about sorting algorithm is FALSE?**

- (A) Insertion sort has the same worst case complexity as bubble sort
- (B) The selection of pivot in Quicksort could have adverse (bad) impact to the sorting complexity
- (C) Quicksort always has O(nlgn) time complexity
- (D) Quicksort is not always faster than bubble sort

**2. (2pt) Which of the following statements about Stack and Queue ADT is FALSE?**

- (A) Stack is First-In-Last-Out
- (B) Queue is First-In-First-Out
- (C) Stack can be used to implement a recursive algorithm iteratively
- (D) Queue can only be implemented with array, and as a result its size cannot be changed once allocated

**3. (2pt) Which of the following statements about software testing is FALSE?**

- (A) Tests can serve as a "manual" to provide info about the input and output of the function
- (B) Code can be tested by comparing actual results from running code with known expcted results  
- (C) Test cases should include edge cases and bad inputs
- (D) If test passes, my code is correct without any doubt

**4. (2pt) Which of the following statements about the dictionary ADT is FALSE?**

- (A) Chaining can be used to solve the collision problem
- (B) Dictionary always has O(1) time complexity for entry retrieval such as ***get(key)***
- (C) Dictionary can be implemented with array
- (D) The hash function needs to have low complexity, preferably O(1)

**5. (2pt) Our mini-google search engine service is getting pretty popular, and search requests are "pouring in" faster than the speed of the searcher can process. Which of the following is NOT an effective choice to improve this situation?** 

- (A) Add a hashtable to cache recent searches to prevent asking the searcher to do the same search again
- (B) Optimize the search algorithm for lower complexity
- (C) Find a way to parallel process of search request
- (D) Remove the index and search directly in all the documents

**6. (10pt) You can't handle the truth!**

In the lecture we saw the following code that calculate and sort the word frequency based on part of the movie "a few good men".

```java
    public static TreeMap<Integer, Set<String>> wordCount(String msg) {
 				
	TreeMap<Integer, Set<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        if (msg == null || msg.isEmpty()) {
            return sortedMap;
        }

        // split the message into word set
        String[] words = msg.split(" ");

        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
                continue;
            }
            wordMap.put(word, 1);
        }
      
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            int key = entry.getValue();
            Set<String> values = sortedMap.containsKey(key) ?
                    sortedMap.get(key) : new HashSet<>();
            values.add(entry.getKey());
            sortedMap.put(entry.getValue(), values);
        }
        return sortedMap;
    }
```

Answer the following question about this code:

6.1 (3pt) With this definition:

```java
	      TreeMap<Integer, Set<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
```

Explain why the value of the TreeMap variable ***sortedMap*** is a Set<String>, instead of a String:

```bash



```

6.2 (3pt) Why is ***sortedMap*** defined as a TreeMap instead of HashMap? 

```bash



```

6.3 (4pt) Suppose ***wordMap*** has the following data:

```bash
and : 8
men : 1
of : 3
what : 2
we : 3
```

What is the resulted data in ***sortedMap*** after running the given code?

```bash



```

**7. (5pt) Improve the following code for better code quality?**

```java
        Stack<Integer> test1 = new Stack<Integer>();
        test1.push(-1);
        tests.add(test1);
        Stack<Integer> test2 = new Stack<Integer>();
        test2.push(0);
        tests.add(test2);
        Stack<Integer> test3 = new Stack<Integer>();
        test3.push(1);
        test3.push(0);
        tests.add(test3);
        Stack<Integer> test4 = new Stack<Integer>();
        test4.push(2);
        test4.push(1);
        test4.push(0);
        tests.add(test4);
        Stack<Integer> test5 = new Stack<Integer>();
        test5.push(5);
        test5.push(1);
        test5.push(3);
        test5.push(2);
        tests.add(test5);
```

**7.1 (2pt) What should be the type of variable '*tests*'?**

```


```

**7.2 (3pt) Discuss and Improve the code quality**

```bash



```

**8. (5pt) Suppose in a project at work, a List of List is initialized like this:**

```java
        // create the original array
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(9, 4, 0, 8);
        List<List<Integer>> buffer1 = new ArrayList<>();
        buffer1.add(list1);
        buffer1.add(list2);
```

Now, your co-worder Jerry has the following code where he intends to make a **deep** copy of the data in *buffer1* into *buffer2*:

```java
        // make a copy.
	// has a bug
        List<List<Integer>> buffer2 = new ArrayList<>();
        for (List<Integer> list : buffer1) {
            buffer2.add(list);
        }
```

A "deep copy" of *buffer1* means any change made to the data in *buffer2* won't affect the original data in *buffer1*. 

For example, if the 2nd list in *buffer2* is changed by:

```java
        buffer2.get(1).set(3, -1);
```

Data in *buffer1* will not change at all. 

However, when Jerry runs this code, he found that data in *buffer2* also changed when data in *buffer1* is changed. He's asking for your help. After some debugging you guys realize there's a bug in the code that does the copy. Since you know TDD (Test Driven Development) is a good practice, you would suggest Jerry to write a new test to catch this bug first and then fix it. 

Explain to Jerry what the bug is:

```




```

Describe how the test should be designed to catch the bug:

```




```

Describe your fix to the bug:

```




```

**9. (15pt) Based on the following tree**

```bash
          41
        /    \
       18    33
      / \    / \
     11  3  1  19 
    /
   5
```

What is the pre-order, in-order and post-order traversal of the above tree
```bash
pre-order:


In-order:


post-order:


```

**10. (10pt) Write the code to iteratively reverse THE SECOND HALF of a single linked list in place.**

The single linked list has a dummy node. And "second half" means from the middle of the list to the end. If there's odd number of nodes, the node in the dead center does not participate in the reversal. The dummy node is not considered part of the list to be counted for reversal.

10.1 (5pt) Write the code given the following list node definition

   ```java
   public class ListNode {
       int val;
       ListNode next;
       public ListNode(int val) {
           this.val = val;
           this.next = null;
       }
   }
   ```

For example, 

```bash
Input: h-->1-->3-->2, output: h-->1-->3-->2
Input: h-->1-->5-->3-->4, output: h-->1-->5-->4-->3
Input: h-->1-->2-->3-->4-->5, output: h-->1-->2-->3-->5-->4
Input: h-->1-->2-->3-->4-->5-->6, output: h-->1-->2-->3-->6-->5-->4
```

The reversal is to be done **in place** like the regular iterative reversal.

```java
public class Solution {
      public void reverse2ndHalf(ListNode head) {
      // your code here
      // head is the dummy node
    }
}
```

10.2 (5pt) What's the time complexity of your code in big O notation ?

```bash



```

**11. (5pt) Answer the following questions about the Cat and Animal classes**

```java
public abstract class Animal {
    private String name;
    private String gender;
    private int age;
    
    public abstract void speak();
    
    public Animal(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
}

public class Cat extends Animal {
  private String furColor;
  public Cat(String name, String gender, int age, String furColor) {
        super(name, gender, age);
        this.furColor = furColor;
    }
    
    @Override
    public void speak() {
        System.out.println("Cat " + getName() + " says 'meow'");
    }
}
```

11.1 (2pt) Why does the keyword ***abstract*** do in the definition of ***speak()***  in Animal class?

```bash


```

11.2 (1pt) What does ***"@Override"*** mean?

```bash


```

11.3 (2pt) What does the call to ***super(name, gender, age)*** do?

```bash

```

**(10pt) Bonus Points 1**

For the "unique path" problem we dicussed in lecture, the following recursion solution was given

```java
    public static int uniquePaths(int m, int n) {
        if (m==0 || n==0) {
            return 0;
        }
        if (m==1 && n==1) {
            return 1;
        }
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }
```

This implementation has horrible performance because of "repeated subprobem". Re-write this with an iterative solution that trades (uses) space for better time performance.  

```java
    public static int uniquePathsIterative(int m, int n) {
			// your code here
    }
```

Discuss the big O time complexity of this iterative method.

```bash




```
