/*
 * 
 * 功能：获取一个xml文件里面的所有内容，并且按照文本格式全部输出出来
 */
import org.dom4j.*;
import org.dom4j.io.*;

import java.io.File;
import java.util.*;
public class Demo4 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//从指定地址获取xml文件
				SAXReader reader=new SAXReader();
				Document document=reader.read(new File("./src/firstxml.xml"));
				//获取xml根标签
				Element rootelem=document.getRootElement();
				StringBuffer sb=new StringBuffer();
				getChildElement(rootelem,sb);
				System.out.println(sb.toString());
	}
	//获取xml文件内容

	private static void getChildElement(Element elem,StringBuffer sb)
	{
		sb.append("<"+elem.getName());
		List<Attribute> attrs=elem.attributes();
		if(attrs!=null)
		{
			for(Attribute attribute:attrs)
			{
			sb.append(" "+attribute.getName()+"=\""+attribute.getValue()+" ");
			}
		}
		sb.append(">");
		Iterator<Node> it=elem.nodeIterator();
		while(it.hasNext())
		{
			Node node=it.next();
			if(node instanceof Element)
			{
				Element ele=(Element)node;
				getChildElement(ele, sb);
			}
			if(node instanceof Text)
			{
				Text text=(Text)node;
				sb.append(text.getText());
			}
		}
		
		sb.append("</"+elem.getName()+">");
	}
}
