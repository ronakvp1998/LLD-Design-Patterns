package circuitbreaker;

public class CBMain {
    static void main() throws InterruptedException {
        CircuitBreaker circuitBreaker = new CircuitBreaker(2,2000);

        executeSafely(circuitBreaker,CBMain::successfullRemoteCall);
        executeSafely(circuitBreaker,CBMain::successfullRemoteCall);

        executeSafely(circuitBreaker,CBMain::failingRemoteCall);
        executeSafely(circuitBreaker,CBMain::failingRemoteCall);

        executeSafely(circuitBreaker,CBMain::successfullRemoteCall);

        Thread.sleep(2100);

        executeSafely(circuitBreaker,CBMain::successfullRemoteCall);
        executeSafely(circuitBreaker,CBMain::successfullRemoteCall);

    }

    private static void executeSafely(CircuitBreaker cb, java.util.function.Supplier<String> call) {
        try {
            String result = cb.execute(call);
            System.out.println("Success " + result);
        }catch (CircuitBreaker.CircuitBreakerOpenException e){
            System.out.println("Blocked " + e.getMessage());
        }catch (Exception e){
            System.out.println("Failed service threw an exception");
        }
    }

    private static String successfullRemoteCall(){
        return "200 OK - Data fetched successfully";
    }

    private static String failingRemoteCall(){
        throw new RuntimeException(" internal server error");
    }
}
