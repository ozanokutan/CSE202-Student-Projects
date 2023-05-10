import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Test {

  public static void main(String[] args) {
    // Test case 1
    boolean testFilter1 = Main.filter((Integer number) -> number % 2 == 0, List.of(1, 2, 3, 4, 5, 6)).equals(List.of(2, 4, 6));
    System.out.println("Test case 1 passed: " + testFilter1);
    
     Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        Function<Integer, Integer> composedFunction1 = addOne.compose(multiplyByTwo);
        boolean testCompose1 = composedFunction1.apply(3) == 7;
        System.out.println("testCompose1: " + testCompose1);
        
        List<Integer> input1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected1 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> output1 = Main.filter(n -> n % 2 == 0, input1);
        System.out.println("Test case 1 passed: " + expected1.equals(output1));
        
        
            // Test case 1: map' (+1) [1,2,3] == [2,3,4]
            List<Integer> xs1 = Arrays.asList(1, 2, 3);
            List<Integer> expectedOutput1 = Arrays.asList(2, 3, 4);
            Function<Integer, Integer> f1 = x -> x + 1;
            List<Integer> actualOutput1 = Main.map(f1, xs1);
            boolean testMap1 = actualOutput1.equals(expectedOutput1);
            System.out.println("Test case 1 passed? " + testMap1); 								
            
         // Test 1: Summing integers
            List<Integer> integers = List.of(1, 2, 3, 4, 5);
            BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
            assert Main.reduce(sum, 0, integers) == 15;
        	
  
  			//Test 2: Composing a square function with a doubling function should result in a function that doubles and then squares the input
  			Function<Integer, Integer> square = x -> x * x;
  			Function<Integer, Integer> doubler = y -> 2 * y;
  			Function<Integer, Integer> doubledAndSquared = Main.compose(square, doubler);
  			assert doubledAndSquared.apply(5) == 100;
  			
  		// Define some test functions
  		    BiFunction<Integer, String, String> f11 = (x, y) -> "f1(" + x + ", " + y + ")";
  		    BiFunction<String, Double, Integer> f2 = (x, y) -> (int) (x.length() + y);

  		    // Test the flip function with f1
  		    System.out.println(Main.flip(f11, "hello", 42)); // Output: f1(42, hello)

  		    // Test the flip function with f2
  		    System.out.println(Main.flip(f2, 3.14, "world")); // Output: 9
  
  
  
  }
}
  
  
  
  
  /*report map 
   *  The map function takes a Function that maps an input element of type A to an output element of type B, and a List of elements of type A.
   *  It applies the function to each element of the input list and returns a new list of elements of type B.
   *  One challenge encountered when implementing this function is the need to create a new list to store the output elements, as Java's List interface does not support immutable lists.
   *  This requires managing mutable state, which can lead to errors such as accidental modification of the input list.
   * 
   * 
   * report filter 
   * The filter() function takes a Predicate object and a list as input, and returns a new list containing only the elements from the input list that satisfy the predicate.
   * One of the challenges in implementing this function is to ensure that the type of the input list and the filtered list match.
   * In this implementation, both lists have the same generic type T, which is inferred from the input list. Another challenge is to ensure that the input list is not modified during the filtering process, which is addressed by creating a new filtered list to store the results.
   * 
   * 
   * report reduce
   * The reduce function takes a binary function f, an initial accumulator value acc, and a list xs of elements. The function applies f recursively to the accumulator and the head of the list, and passes the result and the tail of the list to the next iteration, until the list is exhausted.
   * The final result is the accumulated value.
   * One potential challenge of implementing the reduce function is ensuring that the function f is associative, meaning that it satisfies the property f(x, f(y, z)) = f(f(x, y), z) for all elements x, y, and z. 
   * 
   * 
   * report compose
   * The compose function takes two functions f and g as inputs, where f takes a type b as input and returns a type c, and g takes a type a as input and returns a type b.
   * The function returns a new function that applies f to the result of applying g to the input value.
   * 
   * report flip
   * The flip function is a simple function that takes a binary function f and two arguments x and y, and applies f to the arguments in reverse order (i.e., f(y, x) instead of f(x, y)).
   * This function can be useful in functional programming when we want to create a new function from an existing one that takes its arguments in the opposite order.
   * The flip function is a simple function that takes a binary function f and two arguments x and y, and applies f to the arguments in reverse order (i.e., f(y, x) instead of f(x, y)).
   *
   */
  
  
  
  
  
  

         
       
        
  
        
        
        

    
  





