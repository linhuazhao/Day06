import java.io.File;
import java.util.*;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
public class Demo5 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<Contact> list=new ArrayList<Contact>();
		SAXReader reader=new SAXReader();
		Document document=reader.read(new File("./src/firstxml.xml"));
		
		Iterator<Element> it=document.getRootElement().elementIterator();
		while(it.hasNext())
		{
			Element elem=it.next();
			Contact contact=new Contact();
			contact.setId(elem.attributeValue("id"));
			contact.setAge(elem.elementText("age"));
			contact.setEmail(elem.elementText("email"));
			contact.setIphone(elem.elementText("iphone"));
			contact.setName(elem.elementText("name"));
			contact.setQq(elem.elementText("qq"));
			list.add(contact);
		}
		
		for(Contact contact:list)
		{
			System.out.println(contact);
		}
	}

}
