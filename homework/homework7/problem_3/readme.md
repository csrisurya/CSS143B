## Autocomplete (40pt)

Okay, so you've made it to the final challenge!!

You now have the chance to solve this problem from scratch putting everything we've learned together in this quarter. And the problem we are solving is "auto-complete".

It works similar to google search autocomplete. When you start typing in the search bar, a list of suggested phrase is immediately provided. Here is an example:

![google search example](https://github.com/pdgetrf/CSS143B/blob/master/homework/homework7/problem_3/example.png)

And here is another example. Given a set of words ["hello", "high", "seattle", "seatac", "see", "hollow", "how"]:

- when you input "h", it'll produce ["hello", "high", "hollow", "how"]
- when you input "se", it'll produce ["seattle", "see"]
- when you input "sea", it'll produce ["seattle", "seatac"]
- when you input "ho", it'll produce ["how"]
- when you input "xyz", it'll produce []

**The goal of the algorithm is to have as low complexity as possible to retrieve the suggested words when given the search text**. In real life, this is usually implement at the browser end so it needs to be FAST. 

Finish the problem in 3 steps:

1. Write a 1 or 2-page document describe the design of your code. Use the above examples to illustrate how it works. Specify what data structure you are using and why. Specify the theoritical performance complexity of design with big O notation. Show result from your unit tests to complete the design doc. Argue that it's the fastest way you can come up with. 
2. Implement the autocomplete solution in Java. The input is a set of strings (no need to read from file). Then given a search word (here assuming it's only a single or partial word), the output is a set of strings from the input string set that starts with the given search word. You can only use Java natative data types and java.util classes such as map, stack, queue, etc. 
3. Add unit tests using JUnit for the search function to show that it works correctly. Write as many test cases as you think appropriate. ***The above example test cases must be included***.

Add your design doc and code and tests to a separate repo.



If you need help on ideas, [here](https://medium.com/@daetam/trie-autocomplete-8dd23ddd3846)'s a good start. Please try to work it out yourself first before resorting to this. 
