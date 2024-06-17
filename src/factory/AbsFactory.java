package factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import iterator.*;
import icons_family.*;

public abstract class AbsFactory {
	Aggregate container;

	public Aggregate createContainer(String filePath,Icons icon) {
		
		try (FileReader reader = new FileReader(filePath)) {
            int level = -1;
            while (reader.ready()) {
                char c = (char) reader.read();
                if (c == '{') {		//进入一个{}
                	level+=1;
                }else if (c == '}') {			//说明一个node完成了
                	if(container.isStackEmpty()) {
                		break;
                	}else if(container.getTopLevel()==0) {	//如果是最低等级的nodes
                		container.addList();	//添加到列表
                		container.setLast();
                		container.popNode();	
                	}else {
                		container.setLast();
                		container.topAdd();
                	}
                	
                	level-=1;

                } else if (c == '"') {		//获得key值
                    String key = readString(reader);
                    c = (char) reader.read();
                    if (c == ':') {
                    	c = (char) reader.read();
                    	if (c == '{') {		//非叶子
                    		container.addNode(key,icon.getComICon(),level,false);
                    		level+=1;
                    		continue;
                    	}else {
                    		String value = readValue(c,reader);
                            if(value.equals("null,")||value.equals("null")) {
                            	value="";
                            }else {
                            	key=key+":"+value;
                            }
                    		container.addNode(key,icon.getLeafIcon(),level,false);
                    		container.topAdd();
                        }
                            	
                    }
                    
                }
                
            }
            container.setLevelUpper();
            container.setLevelLower();
            container.setLevelLast();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return container;
		
	}
	public abstract Iterator getIterator();	
	private static String readString(FileReader reader) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int i = 0;
	    while (reader.ready()) {
	        char c = (char) reader.read();
	        if (c == '"') {
	            break;
	        } else if (c == '\\') {
	            i++;
	            if (i % 2 == 0) {
	                sb.append(c);
	            }
	        } else {
	            sb.append(c);
	        }
	    }
	    return sb.toString();
	}
	
	private static String readValue(char  a,FileReader reader) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    if(a!='"') {
	    	sb.append(a);
	    }
	    
	    int i = 0;
	    while (reader.ready()) {
	        char c = (char) reader.read();
	        if(c=='"') {
	        	break;
	        }
	        if (c =='\r'||c =='\n'||c==',') {
	            break;
	        } else if (c == '\\') {
	            i++;
	            if (i % 2 == 0) {
	                sb.append(c);
	            }
	        } else {
	            sb.append(c);
	        }
	    }
	    return sb.toString();
	}

}

