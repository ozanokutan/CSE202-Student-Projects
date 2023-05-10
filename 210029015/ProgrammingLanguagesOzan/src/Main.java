import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

  
   //Applies a function to each element of a list and returns a new list containing the results.
   
  public static <A, B> List<B> map(Function<A, B> f, List<A> xs) {
    if (xs.isEmpty()) {
      return new ArrayList<B>(); // If the input list is empty, return an empty list
    } else {
      A x = xs.get(0); // Get the first element of the input list
      List<A> xsTail = xs.subList(1, xs.size()); // Get the remaining elements of the input list
      B y = f.apply(x); // Apply the function to the first element of the input list
      List<B> ysTail = map(f, xsTail); // Recursively apply the function to the remaining elements of the input list
      ysTail.add(0, y); // Add the result of applying the function to the first element of the input list to the beginning of the output list
      return ysTail; // Return the output list
    }
  }


 public static <T> List<T> filter(Predicate<T> predicate, List<T> list) {
    // Create a new ArrayList to store the filtered elements
    List<T> filteredList = new ArrayList<>();

    // Loop through each element in the input list
    for (T element : list) {
      // Check if the current element satisfies the predicate
      if (predicate.test(element)) {
        // If it does, add it to the filtered list
        filteredList.add(element);
      }
    }

    // Return the filtered list
    return filteredList;
  }





	
	public static <A> A reduce(BiFunction<A, A, A> f, A acc, List<A> xs) {
	    // If the list is empty, return the accumulator
	    if (xs.isEmpty()) {
	        return acc;
	    }
	    // Otherwise, recursively apply the function to the accumulator and the head of the list,
	    // and pass the result and the tail of the list to the next iteration
	    else {
	        return reduce(f, f.apply(acc, xs.get(0)), xs.subList(1, xs.size()));
	    }
	}

	
	
	// The type parameters <a, b, c> represent the types of the input and output
	// values of the functions g and f, respectively.
	public static <a, b, c> Function<a, c> compose(Function<b, c> f, Function<a, b> g) {
	    // Return a new function that applies f to the result of applying g to the input value.
	    return x -> f.apply(g.apply(x));
	}

	public static <A, B, C> C flip(BiFunction<A, B, C> f, B x, A y) {
	    return f.apply(y, x);
	
	}
}
	



