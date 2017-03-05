import java.io.File;
import java.util.Iterator;

import org.dom4j.*;
import org.dom4j.io.SAXReader;


public class Demo2 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SAXReader reader=new SAXReader();
		Document document=reader.read(new File("./src/firstxml.xml"));
		
		Iterator<Node> it=document.nodeIterator();
		while(it.hasNext())
		{
			Node node=it.next();
			String name=node.getName();
			System.out.println(name);
			
			if(node instanceof Element)
			{
				Element elem=(Element)node;
				getChildElement(elem);
			}
		}
	
	}
	public static void getChildElement(Element elem)
	{
		Iterator<Node> it=elem.nodeIterator();
		while(it.hasNext())
		{
			Node node=it.next();
			String name=node.getName();
			if(name!=null)
			System.out.println(name);
			
			if(node instanceof Element)
			{
				Element elem1=(Element)node;
				getChildElement(elem1);
			}
		}
	}

}
