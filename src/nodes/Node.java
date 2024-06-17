package nodes;

import java.awt.print.Printable;
import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;
import java.util.List;

import visitor.Visitor;

public abstract class Node {
	protected String name;
	protected String icon;
	protected int level;
	protected boolean islast;
	protected boolean upper;
	protected boolean lower;
	protected List<Node> kids=new ArrayList<>();
	public Node(String name, String icon, int level, boolean islast) {
        this.name = name;
        this.icon = icon;
        this.level = level;
        this.islast=islast;
        this.upper=false;
        this.lower=false;
        
    }
	
	public abstract void accept(Visitor visitor );
	
	public Node getKid(int kidIndex) {
		return kids.get(kidIndex);
	}
	public void setUpper(boolean upper) {
		this.upper=upper;
	}
	
	public void setLower(boolean lower) {
		this.lower=lower;
	}
	
	public void  setKidsLower() {
		if(this.lower) {
//			System.out.println("ll");
			for(Node kid :kids) {
				kid.setLower(true);
			}
		}
	}
	
	public void setKidsLast(boolean last) {
		kids.get(kids.size()-1).islast=last;
	}
	
	public void setLast(boolean last) {
		this.islast=last;
	}
	
	public boolean getLast() {
		return islast;
	}
	public int getLevel() {
		return level;
	}
	
	public boolean getLower() {
		return lower;
	}
	
	public boolean getUpper() {
		return upper;
	}
	
	public String getName() {
		return name;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void add(Node a) {
		kids.add(a);
	}
	
	public int getKidsSize() {
		return kids.size();
	}
}
