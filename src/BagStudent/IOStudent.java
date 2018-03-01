package BagStudent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class IOStudent {
	
	public static void writeFileText(String file)
	{
		try (FileWriter fw = new FileWriter(new File(file), true)){
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println("Hello i am Dung handsome");
			pw.println("I am student!!!");
			pw.close();
		} catch (Exception e) {
			System.out.println("Had an Exception!!!");
		}
	}
	public static void readFileText(String file)
	{
		try (Scanner sc = new Scanner(new File(file))){
			while(sc.hasNext())
			{
				String str = sc.nextLine();
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println("Had an Exception!!!");
		}
	}
	public void writeFileStudent(Object st, String file)
	{
		try (FileOutputStream fos = new FileOutputStream(new File(file))){
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(st);
		} catch (Exception e) {
			System.out.println("Had an Exception!!!");
		}
	}
	public Student readFileStudent(String file)
	{
		Student st = new Student();
		try (FileInputStream fis = new FileInputStream(new File(file))){
			ObjectInputStream ois = new ObjectInputStream(fis);		
			st = (Student)ois.readObject();
		} catch (Exception e) {
			System.out.println("Had an Exception!!!");
		}
		return st;
	}
	public void writeFileListStudent(String file, ArrayList<Student> listst)
	{
		try (FileOutputStream fos = new FileOutputStream(new File(file))){
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listst);
		} catch (Exception e) {
			System.out.println("Had an Exception!!!");
		}
	}	
	public ArrayList<Student> readFileListStudent(String file)
	{
		ArrayList<Student> listst = null;
		try (FileInputStream fis = new FileInputStream(new File(file))){
			ObjectInputStream ois = new ObjectInputStream(fis);
			listst = (ArrayList<Student>)ois.readObject();
		} catch (Exception e) {
			System.out.println("Had an Exception!!!");
		}
		return listst;
	}
	
	public static void main(String[] args) {
		IOStudent ios = new IOStudent();
		//String file = "Student.doc";
		//writeFileText(file);
		//readFileText(file);
		//Student st1 = new Student("Le Van Dung",20,"Thanh Hoa");
		//ios.writeFileStudent(st1, "Student.doc");
		//Student st2 = ios.readFileStudent("Student.txt");
		//System.out.println(st2.getAge() + " " + st2.getName() + " " + st2.getAddress());
		ArrayList<Student> listst = new ArrayList<Student>();
		listst.add(new Student("Le Hoang Duong", 18, "Ha Noi"));
		listst.add(new Student("Dao Quang Trong", 20, "Phu Tho"));
		listst.add(new Student("Luu Duc Bao", 17, "Da Nang"));
		//ios.writeFileListStudent("ListStudent.doc", listst);
		ArrayList<Student> listst1 = ios.readFileListStudent("ListStudent.doc");		
		for (Student s1 : listst1) {
			System.out.println(s1.getAge() + " " + s1.getName() + " " + s1.getAddress());
		}
	}
}

