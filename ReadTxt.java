package GroupName_zero_Segmentation.chinese_segmentation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadTxt {
	public  String output="";
	/*
	 * 这是一个读取txt的方法
	 * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
	 * @param filePath 是txt文本的存放路径
	 */
	 public String readTxtFile(String filePath)
	 /*
	  * 该方法是读取一个.txt文件的方法，将文件中的内容读取到一个字符串中
	  * @param filePath是被读取的文件的路径名
	  */
	 {
	        try {
	               // String encoding="GBK";
	                File file=new File(filePath);
	                if(file.isFile() && file.exists()){ //判断文件是否存在
	                    InputStreamReader read = new InputStreamReader(
	                    new FileInputStream(file));//考虑到编码格式
	                    BufferedReader bufferedReader = new BufferedReader(read);
	                    String lineTxt ="";
	                   
	                    while((lineTxt = bufferedReader.readLine()) != null){    
	                        output=output+lineTxt;
	                    } 
	                    read.close();
	                  }else{
	                            System.out.println("找不到指定的文件");
	                       }
	           } 
	        catch (Exception e) {
	            System.out.println("读取文件内容出错");
	            e.printStackTrace();
	        }
	     return output;
	    }
}
