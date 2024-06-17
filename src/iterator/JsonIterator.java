package iterator;

import java.util.List;
import java.util.Stack;

import nodes.JsonNode;
import nodes.Node;

public class JsonIterator extends Iterator{
	Stack<Node> stack=new Stack<>();
	public JsonIterator(List<Node> level0) {
		super(level0);
		for(int i=level0.size()-1;i>=0;i--) {
			stack.push(level0.get(i));
		}
	}

	@Override
	public Node getNext() {
		if(!hasNext()) {
			return null;
		}
		Node top=stack.pop();
		for(int i=top.getKidsSize()-1;i>=0;i--) {
			stack.push(top.getKid(i));
		}
		return top;
	}

	@Override
	public boolean hasNext() {
//		System.out.println("has one");
		if(stack.isEmpty())return false;
		return true;
	}
}
