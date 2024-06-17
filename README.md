# Design Pattern 2
## 作业要求

对已有的FJE实现进行设计重构。

1.改用迭代器+访问者模式，或者迭代器+策略模式。



## 类图和说明

![image-20240617202958955](https://github.com/shenggeliashui/Funny-JSON-Explorer2/assets/128944650/d19ee5aa-d67b-462b-b011-b072228a040f)




## 使用的设计模式和作用

使用了迭代器+访问者模式。

### 访问者模式：

​		是一种行为型模式。将数据结构和对该数据结构的操作进行解耦合，从而使得添加新的操作变得更容易。元素的执行算法可以随着访问者改变而改变。



#### 结构：

**访问者** ：接口声明了一系列以对象结构的具体元素为参数的访问者方法。

**具体访问者**：实现了访问者接口，包含对每个元素类的访问逻辑。

**元素** ：接口声明了一个方法来 “接收” 访问者。 该方法必须有一个参数被声明为访问者接口类型。

**具体元素** ：必须实现接收方法。



#### 代码部分：

定义了Visitor、RectVisitor、TreeVisitor的访问者类。定义了JsonNode、Node的元素类。

其中元素类中包含accept方法：

~~~java
public abstract void accept(Visitor visitor );
~~~

~~~java
public void accept(Visitor visitor) {
	visitor.visit(this);
}
~~~

访问者类中包含对元素的访问方式：

~~~java
public abstract void visit(Node node);
~~~

使用时：

~~~java
while(iterator.hasNext()) {
	iterator.getNext().accept(visitor);
}
~~~



### 迭代器模式：

提供一种统一的方法来遍历不同的聚合对象，同时不暴露对象的内部表示。



#### 结构：

**迭代器接口**：定义了访问和遍历聚合对象中各个元素的方法，通常包含next（），hasnext（）等的方法。

**具体迭代器**：实现了迭代器接口，负责对聚合对象进行遍历和访问。

**聚合对象接口**:定义了创建迭代器对象的接口.

**具体聚合对象**:实现了聚合对象接口，负责创建具体的迭代器对象，并提供需要遍历的数据。



#### 代码部分：

定义了Aggregate、JsonAggregate的聚合对象类，和Iterator、JsonIterator的迭代器类。

聚类对象类是需要遍历的元素的结构。（Node是要遍历的元素）

~~~java
protected List<Node> level0=new ArrayList<>();
~~~

同时还应该能创造迭代器：

~~~
public abstract Iterator createIterator();
~~~

~~~java
public Iterator createIterator() {
    Iterator itera=new JsonIterator(this.level0);
    return itera;
}
~~~

迭代器类实现getNext()和hasNext()的方法：

~~~java
public abstract Node getNext();
public abstract boolean hasNext();
~~~

~~~java
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
    if(stack.isEmpty())return false;
    return true;
}
~~~

迭代器的使用：

~~~java
while(iterator.hasNext()) {
	iterator.getNext().accept(visitor);
}
~~~



## 运行截图：

run.bat文件运行
![image-20240617203606467](https://github.com/shenggeliashui/Funny-JSON-Explorer2/assets/128944650/48788f49-259b-4a87-8489-6ce817553e15)

 
