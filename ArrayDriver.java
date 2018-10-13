/**
 * This driver demonstrates the implementation of
 * a resizable array in the BookArray class. 
 * @author tesver
 */
public class ArrayDriver {
	public static void main(String[] args) {
	BookArray<String> stack = new BookArray<String>(3);
	stack.push("The Great Gatsby");
	stack.push("Catch-22");
	stack.push("1984");
	stack.push("Lord of the Rings");
	stack.push("The Hunger Games");
	
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.peek());
	System.out.println(stack.isEmpty());
	stack.clear();
	System.out.println(stack.isEmpty());
	}
}
