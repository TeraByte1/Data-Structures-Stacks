/**
 * This driver demonstrates the implementation of 
 * a linked chain of nodes in the LinkedBookStack class.
 * @author tesver
 *
 */
public class NodeDriver {
	public static void main(String[] args) {
		LinkedBookStack<String> pile=new LinkedBookStack<String>();
		pile.push("Brave New World");
		pile.push("Animal Farm");
		pile.push("The Catcher in the Rye");
		pile.push("Number the Stars");
		pile.push("The Hobbit");
		pile.push("Lord of the Flies");
		
		System.out.println(pile.peek());
		System.out.println(pile.pop());
		System.out.println(pile.isEmpty());
		System.out.println(pile.pop());
		System.out.println(pile.peek());
		pile.clear();
		System.out.println(pile.isEmpty());
	}
}