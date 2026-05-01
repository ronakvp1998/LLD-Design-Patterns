import java.io.Serializable;

/**
 * Lazy initialization mean application will create instance when it is requested.
 * However, this can be used when you have non-thread-safe application. If used in multi threading it might break,
 * Why? because your getinstance method if invoked by two thread at same time then!!!!
 *
 * When to use?  Non thread safe and creating common resource like db connection.
 *
 *
 */
public class LazySingleton implements Serializable {
    // 1 static instance of the class
    private static LazySingleton instance = null;

    // 2 constructor private
    private LazySingleton() {

    }

    // 3 static method to get the instance of the class
    // in this class multi thread is not handeled
    public static LazySingleton getInstance() {
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
