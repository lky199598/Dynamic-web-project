package InitClass;

//: Beetle.java
//The full process of initialization.
class Insect {
 int i = 9;
 int j=prt("基类实例变量 j initialized");
 static int x1 = prt("static Insect.x1 initialized");//注意这里是static字段
 
 Insect() {
     prt("基类构造函数:i = " + i + ", j = " + j);
     j = 39;
 }

 
 static int prt(String s) {
     System.out.println(s);
     return 47;
 }

}

public class Beetle extends Insect {
 int k = prt("子类实例变量：Beetle.k initialized");
 
 static int x2 = prt("static Beetle.x2 initialized");//注意这里是static字段

 Beetle() {
     prt("子类构造函数: k = " + k);
     prt("j = " + j);
 }

 static int prt(String s) {
     System.out.println(s);
     return 63;
 }

 public static void main(String[] args) 
 {
	   
		        String str = "abc";   
		       String str1 = "abc";   
		       String str2 = new String("abc");   
	        System.out.println(str == str1);   
		       System.out.println(str1 == "abc");   
		       System.out.println(str2 == "abc");   
	      System.out.println(str1 == str2);   
	       System.out.println(str1.equals(str2));   
	        System.out.println(str1 == str2.intern());   
	       System.out.println(str2 == str2.intern());   
	        System.out.println(str1.hashCode() == str2.hashCode());   

 }
 
}
