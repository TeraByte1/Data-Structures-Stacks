/**
 * This class demonstrates the implementation of 
 * a vector in the VectorStack class. 
 * @author tesver
 */
public class VectorDriver {
public static void main(String[] args) {
VectorStack<String> stack = new VectorStack<String>(2);
	stack.push("Think and Grow Rich");
	stack.push("Of Mice and Men");
	stack.push("The Grapes of Wrath");
	stack.push("The Outsiders");
	stack.push("Mary Poppins");
	stack.push("The Very Hungry Caterpillar");

	System.out.println(stack.isEmpty());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	stack.push("A Dog's Purpose");
	System.out.println(stack.peek());
	stack.clear();
	System.out.println(stack.isEmpty());
	}
}
