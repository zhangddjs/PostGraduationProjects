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
	File stuFile = new File("stuInformation.txt");	//д����Ϣ��Ŀ���ļ�
	
	//����ѧ����Ϣ
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
	
	//��ȡѧ����Ϣ
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
	
	//��ѧ����Ϣ������ļ�
	protected void saveFile() {
		try {
			Writer out = new FileWriter(stuFile, true);
			BufferedWriter bf = new BufferedWriter(out);
			bf.write(name + "ѧ������Ϣ��"); 
			bf.newLine();
			bf.write("������" + name);
			bf.newLine();
			bf.write("ѧ�ţ�" + studyID);
			bf.newLine();
			bf.write("�Ա�" + sex);
			bf.newLine();
			bf.write("Ժϵ��" + yuanXi);
			bf.newLine();
			bf.write("רҵ��" + zhuanYe);
			bf.newLine();
			bf.write("�༶��" + banJi);
			bf.newLine();
			bf.write("���֤�ţ�" + personID);
			bf.newLine();
			bf.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("�����ļ����Ƴ���");
		}
	}
	
	//����ļ���ѧ����Ϣ�Ƿ�����ظ� trueΪ���ظ� falseΪ���ظ�
	protected boolean check() throws FileNotFoundException{
		Scanner ck = new Scanner(stuFile);
		while (ck.hasNext()) {
			String info = ck.next();
			if (info.contains("������"+this.name)
					|| info.contains("ѧ�ţ�"+this.studyID) 
					|| info.contains("���֤�ţ�"+this.personID)) {
				return true;
			} 
		}
		return false;
	}
	
}
