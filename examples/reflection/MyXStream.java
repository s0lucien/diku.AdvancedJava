package reflection;

import java.lang.reflect.Field;

import reflection.Employee;

public class MyXStream {
	
	private static void openingTag(int tab, StringBuilder sb, String name) {
		tabs(tab, sb);
		sb.append("<" + name + ">\n");
	}
	
	private static void closingTag(int tab, StringBuilder sb, String name) {
		tabs(tab, sb);
		sb.append("</" + name + ">\n");
	}
	
	private static void tabs(int tab, StringBuilder sb) {
		for (int i = 0; i < tab; i++) {
			sb.append(' ');
		}
	}

	public static void serialize(int tab, StringBuilder sb, Object obj) throws IllegalArgumentException, IllegalAccessException{
		Class<?> c = obj.getClass();
		
		if(c.isAnnotationPresent(Serialize.class)) {
		
			openingTag(tab, sb, c.getSimpleName());
			
			for(Field f : c.getDeclaredFields()) {
				if(f.isAnnotationPresent(Serialize.class)) {
					f.setAccessible(true);
					openingTag(tab + 1, sb, f.getName());
					serialize(tab + 2,sb, f.get(obj));
					closingTag(tab + 1, sb, f.getName());
				}
			}
			
	
			closingTag(tab, sb, c.getSimpleName());
		}
		
		else {
			tabs(tab, sb);
			sb.append(obj.toString());
			sb.append("\n");
		}
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder sb = new StringBuilder();
		Employee bob = new Employee("Bob", 42, 1000);
		serialize(0, sb, bob);
		System.out.println(sb.toString());
	}
}
