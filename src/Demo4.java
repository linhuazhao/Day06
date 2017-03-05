/*
 * 
 * ���ܣ���ȡһ��xml�ļ�������������ݣ����Ұ����ı���ʽȫ���������
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
		//��ָ����ַ��ȡxml�ļ�
				SAXReader reader=new SAXReader();
				Document document=reader.read(new File("./src/firstxml.xml"));
				//��ȡxml����ǩ
				Element rootelem=document.getRootElement();
				StringBuffer sb=new StringBuffer();
				getChildElement(rootelem,sb);
				System.out.println(sb.toString());
	}
	//��ȡxml�ļ�����

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
