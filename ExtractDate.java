package GroupName_zero_Segmentation.chinese_segmentation;

import java.util.*;
import java.util.regex.Matcher;     
import java.util.regex.Pattern; 
public class ExtractDate {
	ArrayList extract(String dateStr)
	{
		 ArrayList matches = new ArrayList(); ; 
         Pattern p = Pattern.compile("(\\d{1,2}[-|\\/]\\d{1,2}[-|\\/]\\d{1,4})|(\\d{1,4}[-|\\/.]\\d{1,2}[-|\\/.]\\d{1,2})|(\\d{1,4}[年]\\d{1,2}[月]\\d{1,2}[日])|(\\d{1,4}[年]\\d{1,2}[月])|(\\d{1,2}[月]\\d{1,2}[日])|(\\d{1,4}[年])|([一二三四五六七八九零〇]{1,4}[年]([一二三四五六七八九十]{1,2}[月])*([一二三四五六七八九十]{1,2}[日])*)|([０１２３４５６７８９]{1,4}[年]([０１２３４５６７８９]{1,2}[月])*([０１２３４５６７８９]{1,2}[日])*)" ); 
         Matcher matcher = p.matcher(dateStr); 
	            while (matcher.find()) 
	            {
	            	matches.add(matcher.group(0));
	            }
	            //删除重复ArrayList中重复的项
	           HashSet hashSet = new HashSet(matches);

	           //Assign the HashSet to a new ArrayList
	           ArrayList arrayList2 = new ArrayList(hashSet) ;

	           //Ensure correct order, since HashSet doesn't
	           Collections.sort(arrayList2);
	           return arrayList2;
	}   
	     
}
