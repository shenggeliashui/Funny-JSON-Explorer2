package visitor;

import nodes.Node;

public class RectVisitor extends Visitor{

	@Override
	public void visit(Node node) {
		StringBuilder output=new StringBuilder();
		if(node.getLevel()!=0) {
			output.append("│ ");
			for(int i=0;i<node.getLevel();i++) {
				if(i==0)output.append("  ");
				else output.append("│ ");
			}
		}
		if(node.getUpper()) {
			output.append("┌─");
		
		}else if(node.getLast() && (node.getKidsSize()==0 || node.getLevel()!=0)) {
			output.append("└─ ");
		}else{
			output.append("├─ ");
		}
		output.append(node.getIcon()+" "+node.getName());
		
		while(output.length()<60) {
			if(output.length()==59) {
				if(node.getUpper()) {
					output.append("—─┐");
				}else {
					output.append("—─┤");
				}
				
			}
			else{
				output.append("—");
			}
		}
		
		if(node.getLower()) {
			if(node.getKidsSize()==0) {
				output.replace(0,4, "└─——");
				output.replace(60, 62,"—┘");
			}else {
				node.getKid(node.getKidsSize()-1).setLower(true);
			}
		}
		System.out.println(output);
		
	}

}
