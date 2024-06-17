package iterator;
import java.io.File;
import iterator.*;
import java.io.FileReader;
import java.util.*;
import nodes.*;
public abstract class Aggregate {
	protected List<Node> level0=new ArrayList<>();
	Stack<Node> stack=new Stack<>();

	public abstract void addNode(String key,String icon,int level,boolean isLeaf);
	
	public abstract Iterator createIterator();
	
	public void popNode() {
		stack.pop();
	}
	
	public void topAdd() {
		Node top=stack.peek();
		stack.pop();
		stack.peek().add(top);
	}
	
	public int getTopLevel() {
		return stack.peek().getLevel();
	}
	
	public void addList() {
		level0.add(stack.peek());
	}
	
	public boolean isStackEmpty() {
		return stack.isEmpty();
	}
	
	public void setLast() {
		stack.peek().setKidsLast(true);
	}
	
	public void setLevelLower() {
		level0.get(level0.size()-1). setLower(true);
	}
	
	public void setLevelUpper() {
		level0.get(0). setUpper(true);
	}
	
	public void setLevelLast() {
		level0.get(level0.size()-1). setLast(true);
	}
}