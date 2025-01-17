package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

//抽象主题
interface IHello{
	/**
	 * 业务方法
	 * @param str
	 */
	void sayHello(String str);
}

/*
 * 目标类代码；真实主题
 */
class Hello implements IHello{
	@Override
	public void sayHello(String str) {
		System.out.println("hello " + str);
	}
}


class Logger{
	
	public static void start() {
		System.out.println(new Date() + " say hello start...");
	}

	public static void end() {
		System.out.println(new Date() + " say hello end");
	}
}


public class DynaProxyHello implements InvocationHandler {
	private Object target;// 目标对象

	/**
	 * 通过反射来实例化目标对象
	 * @param object
	 * @return
	 */
	public Object bind(Object object) {
		this.target = object;
		//返回真是主题类对象
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
				this.target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable{

		Object result = null;
		
		Logger.start();// 添加额外的方法		
		
		// 通过反射机制来运行目标对象的方法
		result = method.invoke(this.target, args);
		
		Logger.end();
		
		System.out.println("\nproxy: "+proxy.getClass().getSimpleName());
		System.out.println("target: "+target.getClass().getSimpleName());
		System.out.println("method: "+method.getName());
		System.out.println("args[0]: "+args[0].getClass().getName());
		System.out.println("result: "+result+"\n");
		
		return result;
	}
	
	public static void main(String[] args) {
		IHello hello = (IHello) new DynaProxyHello().bind(new Hello());
		// 如果我们需要日志功能，则使用代理类
		// IHello hello = new Hello();//如果我们不需要日志功能则使用目标类
		hello.sayHello("明天");
	}
}

