package GroupName_zero_Segmentation.chinese_segmentation;
import javax.swing.*;

import org.ansj.splitWord.analysis.ToAnalysis;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;     
import java.util.regex.Pattern; 
public class Usergui extends JFrame implements ActionListener{
	String text;
	JPanel mb1,mb2,mb3;
	JLabel bq1,bq2,bq3;
	JButton an1;
	JTextArea wby1,wby2,wby3;//文本域
	JScrollPane gdt1,gdt2,gdt3;//滚动条
	
	Usergui()
	{
		bq1=new JLabel("单文本分析",JLabel.LEFT);
		bq1.setFont(new Font("宋体",Font.BOLD,16));
		bq1.setForeground(Color.BLUE);
		bq2=new JLabel("分词",JLabel.LEFT);
		bq2.setFont(new Font("宋体",Font.BOLD,16));
		bq2.setForeground(Color.BLUE);
		bq3=new JLabel("元数据提取",JLabel.LEFT);
		bq3.setFont(new Font("宋体",Font.BOLD,16));
		bq3.setForeground(Color.BLUE);
		
		an1=new JButton("提交文本");
		an1.setFont(new Font("宋体",Font.BOLD,16));
		an1.addActionListener(this);
		
		wby1=new JTextArea(10,100);
		wby1.setFont(new Font("宋体",Font.PLAIN,15));
		wby1.setLineWrap(true); //设置换行
		wby1.setWrapStyleWord(true);
		wby2=new JTextArea(10,100);
		wby2.setFont(new Font("宋体",Font.PLAIN,15));
		wby2.setLineWrap(true);
		wby2.setWrapStyleWord(true);
		wby3=new JTextArea(10,100);
		wby3.setFont(new Font("宋体",Font.PLAIN,15));
		wby3.setLineWrap(true);
		wby3.setWrapStyleWord(true);
		
		gdt1=new JScrollPane(wby1);
		gdt2=new JScrollPane(wby2);
		gdt3=new JScrollPane(wby3);
		mb1=new JPanel();
		mb2=new JPanel();
		mb3=new JPanel();
		
		//添加面板的组件
		mb1.setLayout(new BorderLayout(5,5));
		mb1.add(bq1,BorderLayout.NORTH);  mb1.add(gdt1,BorderLayout.CENTER);  mb1.add(an1,BorderLayout.SOUTH);
		mb2.setLayout(new BorderLayout(5,5));
		mb2.add(bq2,BorderLayout.NORTH);  mb2.add(gdt2,BorderLayout.SOUTH);
		mb3.setLayout(new BorderLayout(5,5));
		mb3.add(bq3,BorderLayout.NORTH);  mb3.add(gdt3,BorderLayout.SOUTH);
		
		//将面板添加到窗体中
		this.add(mb1,BorderLayout.NORTH);
		this.add(mb2,BorderLayout.CENTER);
		this.add(mb3,BorderLayout.SOUTH);
		
		this.setTitle("元数据提取");
		this.setIconImage((new ImageIcon("image/1.jpg")).getImage());
		this.setSize(1000, 600);
		this.setLocation(300, 10);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}
	//点击按钮时的事件
	public void actionPerformed(ActionEvent e)
	{   
		String filePath = "F:\\研究生学习\\中科大工程实践项目\\元数据相关文档\\文件公告\\1.txt";
		text=wby1.getText();
		try{
			FileWriter fw = new FileWriter(filePath); 
		    BufferedWriter bw = new BufferedWriter(fw); 
		    bw.write(text); 
		    bw.close(); 
		    fw.close();
		    }
		catch(IOException ex)
		{ 
			ex.printStackTrace(); 
		}
	    ReadTxt read=new ReadTxt();
		String ReadContent= read.readTxtFile(filePath);
		//去除第一个文本域中的空格
	    String par1=deltebrace(ReadContent,1);
	    this.wby1.setText(par1);
		//去除第二个文本域中的空格,回车，换行符，制表符
		String SegContent=ToAnalysis.parse(par1).toString();
		String par2=deltebrace(SegContent,0);
		this.wby2.setText(par2);
		//将提取的时间显示到第三个文本域中
		ExtractDate draw=new ExtractDate();
		draw.extract(par1);  
		String put="提取的时间："+"\n";
		//System.out.println(draw.extract(par1).size());
		for(int i=0;i<draw.extract(par1).size();i++)
		{  
			put=put+(draw.extract(par1).get(i).toString()+"      ");
			if(i%4==0 &&i!=0)
			{
			    put=put+"\n";
			}
		}
		this.wby3.setText(put);
		e.getActionCommand();
		
	}
	//i=0去除空格,回车，换行符，制表符,i=1 只去除空格
	String deltebrace(String str,int i)
	{
		String par="";
		if( str!=null&&i==0)
		{
			Pattern p=Pattern.compile("\\s*|\t|\r|\n");
			Matcher m=p.matcher(str);
		    par=m.replaceAll("");
		}
		if( str!=null&&i==1)
		{
			Pattern p=Pattern.compile("\\s*");
			Matcher m=p.matcher(str);
		    par=m.replaceAll("");
		}
		return par;
	}
	
	
}
