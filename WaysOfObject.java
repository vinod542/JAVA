package com.Java.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class WaysOfObject implements Serializable, Cloneable {
	static String name = "Vinod Kumar Vadlamudi";

	static String name1;

	public WaysOfObject() { // constructor for newInstance method and Basic new method
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
		this.name = name;
	}

	WaysOfObject(String name1) { // using for object serializing
		this.name1 = name;
	}

	String newMethod(String name) {
		return name;
		/*
		 * 1. New keyword - basic -
		 * 
		 */

	}

	/*
	 * newInstance() {
	 *
	 * 2. New instance: If we know the name of the class & if it has a public
	 * default constructor we can create an object –Class.forName. We can use it to
	 * create the Object of a Class. Class.forName actually loads the Class in Java
	 * but doesn’t create any Object. To Create an Object of the Class you have to
	 * use the new Instance Method of the Class.
	 * 
	 * }
	 */
	public void newInstancetest() {
		try {
			Class<?> cls = Class.forName("WaysOfObject"); // Class. Class.forNameactually loads the Class in Java
			WaysOfObject Instanceobj = (WaysOfObject) cls.newInstance(); // Create an Object of the Class you have to //
																			// use the
			// new Instance Method of the Class
			System.out.println(Instanceobj.name1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 3. Deserialization - Whenever we serialize and then deserialize an object,
	 * JVM creates a separate object. In deserialization, JVM doesn’t use any
	 * constructor to create the object. To deserialize an object we need to
	 * implement the Serializable interface in the class. step1 - need to implement
	 * Serializable step2 - need to serialize the object first step3 - once the
	 * serializing need to deserialize
	 */
	public void serializing() { // output [converting object into sequence of bytes]- ¨Ì sr 
								// com.Java.practice.WaysOfObjectπ^\üö˙∞b  xp

		try {
			WaysOfObject WOF = new WaysOfObject(name1);
			FileOutputStream FOS = new FileOutputStream("sample.txt");
			ObjectOutputStream OOS = new ObjectOutputStream(FOS);
			OOS.writeObject(WOF); // serialized
			OOS.close();
			FOS.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deserializing() {
		WaysOfObject WOF1 = null;
		try {

			FileInputStream FIS = new FileInputStream("sample.txt");
			ObjectInputStream OIS = new ObjectInputStream(FIS);
			WOF1 = (WaysOfObject) OIS.readObject(); // readObject() to deserialized
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(WOF1.name1);
	}

	// 4. Using newInstance() method of constructed class.
	public void newInstanceMethod() {
		try {
			Constructor<WaysOfObject> constructor = WaysOfObject.class.getDeclaredConstructor();
			WaysOfObject w = constructor.newInstance();
			w.setName(name);
			System.out.println(w.name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected // 5. clone() - whenever clone is called on Object, JVM creates a new object and
	// copies all content of previous object into it.
	// no need to invoke constructor to create an object using clone method
	// step1: implements cloneable
	
	 Object clone() throws CloneNotSupportedException {
		return super.clone();

	}

	public void cloneable() throws CloneNotSupportedException {
		WaysOfObject WOF2 = new WaysOfObject();
		WaysOfObject WOF3 = (WaysOfObject) WOF2.clone();
		System.out.println(WOF2.name1);
	}

	public static void main(String[] args) throws CloneNotSupportedException {

		// 1 - using new keyword

		WaysOfObject newObj = new WaysOfObject();
		System.out.println(newObj.newMethod(name));
		// 2.New instance
		newObj.newInstancetest();
		// 3. deserializing
		WaysOfObject WOF = new WaysOfObject(name1);
		WOF.serializing(); // output [converting object into sequence of bytes]- ¨Ì sr 
							// com.Java.practice.WaysOfObjectπ^\üö˙∞b  xp
		WOF.deserializing(); // output - Vinod Kumar Vadlamudi
		WOF.newInstanceMethod();
		WOF.cloneable();

	}

}
