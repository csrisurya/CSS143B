

# !!!EXAMPLE ONLY!!!

## 2020 Winter CSS143B Final Exam &nbsp; &nbsp; Student Name:

**All choice questions are single choice**

**1. Which of the following statements about sorting algorithm is FALSE?**

- (A) Heap sort has O(1) space complexity
- (B) Quick sort is stable
- (C) Bubble sort has O(n^2) time complexity  
- (D) Merge sort can be implemented by recursion



**2. "You can't handle the truth!"**

In the lecture we saw the following code that calculate and sort the word frequency based on part of the movie "a few good men".

```java
        // use map to count the occurrences of each word
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word)+1);
                continue;
            }
            wordMap.put(word, 1);
        }

        // sort the map based on number of occurrences
        TreeMap<Integer, Set<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            int key = entry.getValue();
            Set<String> values = sortedMap.containsKey(key) ?
                    sortedMap.get(key) : new HashSet<>();
            values.add(entry.getKey());
            sortedMap.put(entry.getValue(), values);
        }
```

Answer the following question about this code:

1. Supposed ***wordMap*** has the following data:

```bash
and : 2
men : 1
of : 2
what : 2
we : 5
```

What is the corresponding data in ***sortedMap***?

```bash



```

**3. Answer the following questions about the Cats and animal classes**

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

1. Why is ***speak()*** defined as ***abstract*** in the Animal class?

```bash

```

2. What does "@Override" mean?

```bash

```

**4. Given a single linked list with a dummy node, write the code to iteratively reverse the list in place.**

1. Write the code given the following list node definition

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

The reversal is to be done **in place** like the regular iterative reversal.

```java
public class Solution {
      public void reverse(ListNode head) {
      // your code here
      // head is the dummy node
    }
}
```

