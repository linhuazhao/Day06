import java.io.File;
import java.util.*;

import org.dom4j.*;
import org.dom4j.io.SAXReader;


public class Demo3 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		test3();
	}
	public static void test3() throws Exception
	{
		SAXReader reader=new SAXReader();
		Document doc=reader.read(new File("./src/firstxml.xml"));
		Element rootElem=doc.getRootElement();
		
		String name=rootElem.getName();
		System.out.println(name);
		
		Element contactElem=rootElem.element("contact");
		System.out.println(contactElem.getName());
		
		//获取属性
//		List<Attribute> list1=contactElem.attributes();
//		for(Attribute a:list1)
//		{
//			System.out.println(a.getName()+" "+a.getValue());
//		}
		
		
		//获取标签里面的所有内容
		List<Element> list=rootElem.elements();
		for(Element e:list)
		{
			List<Element> list2=e.elements();
			for(Element e2:list2)
			{
				System.out.println(e2.getName()+":"+e2.getData());
			}
		}
		
	}
}
