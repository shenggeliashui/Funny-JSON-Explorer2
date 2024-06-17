package iterator;


import nodes.*;

public class JsonAggregate extends Aggregate{

	@Override
	public void addNode(String key, String icon, int level, boolean isLeaf) {
		JsonNode newTop=new JsonNode(key, icon, level, isLeaf);
		stack.add(newTop);
		
	}

	@Override
	public Iterator createIterator() {
		Iterator itera=new JsonIterator(this.level0);
		return itera;
	}
	
	
}
