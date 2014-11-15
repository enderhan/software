package GroupName_zero_Segmentation.chinese_segmentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPlace 
{
	ArrayList extractplace(String str)
	{
		 ArrayList matches = new ArrayList(); ; 
         Pattern p = Pattern.compile("([\u4E00-\u9FA5]+[/][n][s])|([\u4E00-\u9FA5]+[/][n][s][f])|([\u4E00-\u9FA5]+[/][n][t])|([\u4E00-\u9FA5]+[/][n][z])" ); 
         Matcher matcher = p.matcher(str); 
	     while (matcher.find()) 
	     {
	         matches.add(matcher.group(0));
	     }
	     //删除重复ArrayList中重复的项
	     HashSet hashSet = new HashSet(matches);
	     //将HashSet中的内容放到ArrayList中去
	     ArrayList arrayList2 = new ArrayList(hashSet) ;
	     //对arraylist中的内容进行排序
	     Collections.sort(arrayList2);
	     //提取出/ns之前的内容
	     for(int i=0;i<arrayList2.size();i++)
	     {
	    	 String s1=null;
	         s1=arrayList2.get(i).toString();
	         int index=s1.indexOf("/");
	         String s2=s1.substring(0, index);
	         arrayList2.set(i, s2);  
	     }
		return arrayList2;
	}

}
