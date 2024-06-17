package factory;

import iterator.Iterator;
import iterator.JsonAggregate;
import iterator.JsonIterator;

public class JsonFactory extends AbsFactory{
	public JsonFactory() {
		container=new JsonAggregate();
	}
	public Iterator getIterator() {
		return container.createIterator();
	}
}
