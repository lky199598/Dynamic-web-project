package Emp;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Hash_Map {
	
	private HashMap<String, Integer> M = new HashMap<String, Integer>();

	public HashMap<String, Integer> getElement()
	{
		return M;
	}
	public void AddElement(String str, int number)
	{
		if(M.containsKey(str))
			M.put(str, M.get(str)+number);
		else
			M.put(str, number);
	}
	
	public static void main(String[] args)
	{
		Hash_Map H = new Hash_Map();
		String s1 =new String("aaa");
		String s2 = new String("aaa");
		
		H.AddElement(s1, 1);
		H.AddElement("bbb", 2);
		H.AddElement(s2, 2);
		
		for(Entry<String, Integer> entry : H.getElement().entrySet())
			System.out.println("����: "+entry.getKey()+"�� ����: "+entry.getValue()+"\n");
	}
	
}
