package nodes;

import visitor.Visitor;

public class JsonNode extends Node{
	public JsonNode(String name, String icon, int level, boolean islast) {
		super(name, icon, level, islast);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
