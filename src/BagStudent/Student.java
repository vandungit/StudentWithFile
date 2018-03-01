package BagStudent;


public class Student {
	private String Name;
	private int Age;
	private String Address;
	public Student() {}
	public Student(String na, int ag, String add)
	{
		this.Name = na;
		this.Age = ag;
		this.Address = add;
	}
	public void setName(String name)
	{
		Name = name;
	}
	public String getName()
	{
		return Name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
}

