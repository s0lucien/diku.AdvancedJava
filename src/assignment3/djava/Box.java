package assignment3.djava;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A box that encapsulates an object, providing access to fields and method
 * through reflection.
 * 
 * @author fmma
 * 
 */
public class Box {

//	private Box objClass;
	private HashMap<String, Method> methods = new HashMap<>();
	private HashMap<String, Field> fields = new HashMap<>();


	/**
	 * The boxed object.
	 */
	private Object boxedObject;

	/**
	 * Creates a box of a given object.
	 * 
	 * @param obj
	 *            The object to box.
	 */
	public Box(Object obj) {
		this.boxedObject = obj;
		Class<?> oc= this.boxedObject.getClass();
//		this.objClass = new Box(oc);
		
//		Method[] me = oc.getDeclaredMethods();
//		for (Method m:me) {
//			this.methods.put(m.getName(), new Box(m));
//		}
		
//		Field[] fi = oc.getDeclaredFields();
//		this.fields = new Box[fi.length];
//		for (int i = 0; i < fi.length; i++) {
//			Field f = fi[i];
//			this.fields[i] = new Box(f.getName(), null);
//		}
//
//
//		new Box(oc.getName(), this.fields);

		//new Box(objClass, resolvedFields);
	}

	/**
	 * Creates a new boxed object, by finding the constructor identified by
	 * className and the types of the input arguments boxedArgs, and calling it
	 * using reflection. If an exception is thrown, set the boxed object to the
	 * exception.
	 * 
	 * @param className
	 *            The class name of the constructor (e.g. "java.util.List").
	 * @param boxedArgs
	 *            The (boxed) arguments given to the constructor.
	 */
	public Box(String className, Box... boxedArgs) {
//		try {
			System.out.println("how to resolve the constructors ?  " +
					"Should we create a new object, or simply wrap existing fields?. " +
					"We tried a lot of stuff but gave up");
//		} catch (ClassNotFoundException ex) {
//			Box exception = new Box(ex);
//		}

	}

	/**
	 * Lookup and return the content of a field identified by fieldName.
	 * 
	 * @param fieldName
	 *            The name of one of the fields of the boxed object.
	 * @return The (boxed) content of that field on success. A boxed exception
	 *         on failure.
	 */
	Box get(String fieldName) {
		return new Box(fields.get(fieldName));
	}

	/**
	 * Set the content of a field identified by fieldName.
	 * 
	 * @param fieldName
	 *            The name of one of the fields of the boxed object.
	 * @param value
	 *            A value to set the field to.
	 * @return null on success, a boxed exception on failure.
	 */
	Box set(String fieldName, Box value) {

		// should we also do something about the boxedObject ?
		try {
			this.fields.get(fieldName).set(fieldName, value.boxedObject);
			return null;
		} catch (Exception e) {
			return new Box(e);
		}
	}

	/**
	 * Invoke a method on the boxed object using reflection.
	 * 
	 * @param methodName
	 *            The name of the method.
	 * @param boxedArgs
	 *            The input arguments to the method.
	 * @return The (boxed) return value of the method on success (void returns
	 *         (unboxed) null), or a boxed exception on failure.
	 */
	Box call(String methodName, Box... boxedArgs) {
		ArrayList<Object> params = new ArrayList<>();
		for (Box box:boxedArgs ) {
			params.add(box.boxedObject);
		}
		Object[] paramsArray = params.toArray();
		try {
			return new Box(this.methods.get(methodName).invoke(this.boxedObject,paramsArray));
		} catch (Exception e) {
			return new Box(e);
		}
	}

	/**
	 * Returns the simple name of the class of the boxed object, followed by a
	 * key-value print of contents of the fields of the boxed object. E.g.
	 * Employee[age=30, salary=4000, name="John doe"].
	 * 
	 * Bonus points: If a field does not declare a toString method, use toString
	 * of Box recursively on that field. Recursion should be limited to some
	 * depth, so that cyclic references wont cause toString to loop forever.
	 */
	@Override
	public String toString() {
		String s = this.boxedObject.getClass().getName() + "[";
		for (String key: fields.keySet()) {
			s += key + "=" + fields.get(key).toString() + "; ";
		}
		// this will keep going, check whether toString is declared in the boxed object before calling toString
		return s+"]";

	}

}
