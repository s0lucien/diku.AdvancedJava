package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import reflection.Employee;
//import assignment1.Mutation;

public class ProxyExample {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		InvocationHandler handler = new MyInvocationHandler();
		Class<?> proxyClass = Class.forName("assignment1.Mutation");

//		Mutation<Employee> m = (Mutation<Employee>) proxyClass.getConstructor(
//				new Class[] { InvocationHandler.class }).newInstance(
//				new Object[] { handler });
//		
//		m.mutate(null);
	}
}
