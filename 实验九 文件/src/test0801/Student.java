package test0801;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Student {
	private String name;
	private String studyID;
	private String sex;
	private String yuanXi;
	private String zhuanYe;
	private String banJi;
	private String personID;
	File stuFile = new File("stuInformation.txt");	//写入信息的目标文件
	
	//设置学生信息
	protected void setInformation(String name, String studyID, 
			String sex, String yuanXi, String zhuanYe, String banJi
			, String personID){
		this.name = name;
		this.studyID = studyID;
		this.sex = sex;
		this.yuanXi = yuanXi;
		this.zhuanYe = zhuanYe;
		this.banJi = banJi;
		this.personID = personID;
	}
	
	//获取学生信息
	protected String getStudyID(){
		return studyID;
	}
	protected String getName(){
		return name;
	}
	protected String getYuanXi(){
		return yuanXi;
	}
	protected String getPersonID(){
		return personID;
	}
	protected String getSex(){
		return sex;
	}
	protected String getZhuanYe(){
		return zhuanYe;
	}
	protected String getBanJi(){
		return banJi;
	}
	
	//将学生信息保存进文件
	protected void saveFile() {
		try {
			Writer out = new FileWriter(stuFile, true);
			BufferedWriter bf = new BufferedWriter(out);
			bf.write(name + "学生的信息："); 
			bf.newLine();
			bf.write("姓名：" + name);
			bf.newLine();
			bf.write("学号：" + studyID);
			bf.newLine();
			bf.write("性别：" + sex);
			bf.newLine();
			bf.write("院系：" + yuanXi);
			bf.newLine();
			bf.write("专业：" + zhuanYe);
			bf.newLine();
			bf.write("班级：" + banJi);
			bf.newLine();
			bf.write("身份证号：" + personID);
			bf.newLine();
			bf.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("保存文件机制出错");
		}
	}
	
	//检查文件中学生信息是否出现重复 true为有重复 false为无重复
	protected boolean check() throws FileNotFoundException{
		Scanner ck = new Scanner(stuFile);
		while (ck.hasNext()) {
			String info = ck.next();
			if (info.contains("姓名："+this.name)
					|| info.contains("学号："+this.studyID) 
					|| info.contains("身份证号："+this.personID)) {
				return true;
			} 
		}
		return false;
	}
	
}
