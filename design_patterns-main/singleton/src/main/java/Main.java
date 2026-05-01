// References  https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
//https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//Before jumping into pattern just explain what is lazy loading and eager loading
// Mainly this class used to show violations using serializable and reflection.
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //exampleSerialization();
       exampleReflection();
    }
    // 1 Break Singleton using Serialization
    private static void exampleSerialization() throws IOException, ClassNotFoundException {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.obj"));
        objectOutputStream.writeObject(lazySingleton);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.obj"));
        LazySingleton deserializedLazy = (LazySingleton) objectInputStream.readObject();
        objectInputStream.close();
        // Both objects have different hashcode so both object are not same
        System.out.println("Object 1 :" + lazySingleton.hashCode());
        System.out.println("Object 2 :" + deserializedLazy.hashCode());

        SerializableSingleton serializableSingleton = SerializableSingleton.getInstance();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream("object1.obj"));
        objectOutputStream2.writeObject(serializableSingleton);
        objectOutputStream2.close();
        ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream("object1.obj"));
        SerializableSingleton deserializedInstance = (SerializableSingleton) objectInputStream2.readObject();
        objectInputStream2.close();
        // Both objects have same hashcode so both object are same
        System.out.println("SerializableSingleton Object 1 :" + serializableSingleton.hashCode());
        System.out.println(" SerializableSingleton Object 2 :" + deserializedInstance.hashCode());
    }

    // 2 Break singleton using Reflection
    private static void exampleReflection() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // getting all the constructors from the class
       Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();
       //Knowing only one constructor taking it using index
        Constructor constructor = constructors[0];
        // changing the accessability from private to public
        constructor.setAccessible(true);
        LazySingleton lazySingleton = (LazySingleton) constructor.newInstance();
        // since the constructor is accessible it will give the new instance every time
        LazySingleton instance = LazySingleton.getInstance();
        // Both objects are different
        System.out.println("Reflected hashcode singleton :"+lazySingleton.hashCode());
        System.out.println("Singleton instance : "+ instance.hashCode());
        //Solution to this is go by enum
        EnumSingleton.INSTANCE.doSomething();
    }
}
