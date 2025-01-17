package FrameWork;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


public class TreeSetClass 
{
	public static void add(TreeSet<Student> ts)
	{       
	}
	
	public static void query1(TreeSet<Student> ts)
	{
		System.out.println("hash.size(): "+ts.size());
		for(Student s:ts)	
		{
			System.out.println(s.toString());
		}
		System.out.println();
	}
	
	public static void query2(TreeSet<Student> ts)
	{

		System.out.println("hash.size(): "+ts.size());
		
		Iterator<Student> stu = ts.iterator();
		
		while(stu.hasNext())
		{
			System.out.println(stu.next().toString());
		}
		System.out.println();
	}
	
    public static void main(String[] args)  
    {
        TreeSet<Student> ts = new TreeSet<Student>(/*new StudentComparator()*/);
          
         add(ts);
         query1(ts);
         query2(ts);
    }
}
 



/*
class Student
{
    private int age;
    private String name;
    
    Student(String name,int age)
    {
        this.age = age;
        this.name = name;
    }
 
 
    public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String toString()
    {
        return name+"::"+age;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		return true;
	}
       
}

 
class StudentComparator implements Comparator {
	
	public int compare(Object o1, Object o2) {

		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		
		int flag = s1.getAge() > s2.getAge() ? 1 : (s1.getAge() == s2
				.getAge() ? 0 : -1);
		if (flag == 0)
			return s1.getName().compareTo(s2.getName());

	
	   flag =new Integer(s1.getAge()).compareTo(s2.getAge());
	   return flag==0 ? s1.getName().compareTo(s2.getName()):flag;
	   
		return flag;
	}

}



*/