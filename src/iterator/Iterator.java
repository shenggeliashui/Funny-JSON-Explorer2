package iterator;

import java.util.List;

import nodes.Node;

public abstract class  Iterator {
	List<Node> level0;
	int par=0;
	int kid=0;
    public Iterator (List<Node> level0) {
    	this.level0=level0;
    }
	public abstract Node getNext();
	public abstract boolean hasNext();
	
}
