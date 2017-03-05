package test;

import java.io.File;

public class Digui {

	public static void print(File dir,int num) {
		
		//3、创建文件对象数组并使用list方法获取
		File[] files = dir.listFiles();
		for (File file : files) {
			//4、遍历数组，判断是否是文件，是文件则输出文件名，是文件夹则输出文件夹名并递归
			if(file.isFile()) {
				for (int i = 0; i < num; i++) {
					System.out.print(" ");
				}
				System.out.println(file.getName());
			}else if(file.isDirectory()) {
				for (int i = 0; i < num; i++) {
					System.out.print(" ");
				}
				System.out.println(file.getName());
				num+=4;
				print(file,num);
			}
		}
	}
	
	public static void main(String[] args) {
		File file=new File("D:/aaa");
		print(file,1);
	}
}
