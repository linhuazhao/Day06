import java.io.File;
import org.dom4j.io.SAXReader;
import org.dom4j.*;
public class Demo1 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SAXReader reader=new SAXReader();
		Document doc=reader.read(new File("./src/firstxml.xml"));
		System.out.println(doc);
	}

}
