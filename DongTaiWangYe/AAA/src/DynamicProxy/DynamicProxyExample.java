package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/*
 * 首先创建委托类对象，将其以构造函数传入代理处理器，代理处理器ProxyHandler中会以Java反射方式调用该委托类对应的方法。
 * 然后使用Java反射机制中的Proxy.newProxyInstance方式创建一个代理类实例，
 * 创建该实例需要指定该实例的类加载器，需要实现的接口(即目标接口)，以及处理代理实例接口调用的处理器。
 * 最后，调用代理类目标接口方法时，会自动将其转发到代理处理器中的invoke方法内，
 * invoke方法内部实现预处理，对委托类方法调用，事后处理等逻辑。
 */
public class DynamicProxyExample {
	public static void main(String[] args){
		 ConcreteClass c=new ConcreteClass();//元对象(被代理对象),创建委托类对象
		 InvocationHandler ih=new ProxyHandler(c);//代理实例的调用处理程序。
		 
		 //创建一个实现业务接口的代理类,用于访问业务类(见代理模式)。
		 
		 //返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序，如ProxyHandler。
		 
		 TargetInterface targetInterface=
			 (TargetInterface)Proxy.newProxyInstance(c.getClass().getClassLoader(),c.getClass().getInterfaces(),ih);
		 
		 //调用代理类方法, Java执行InvocationHandler接口的方法.
		 int i=targetInterface.targetMethodA(5);
		 System.out.println(i);
		 System.out.println();
		 
		 int j=targetInterface.targetMethodB(15);
		 System.out.println(j);
	}
}