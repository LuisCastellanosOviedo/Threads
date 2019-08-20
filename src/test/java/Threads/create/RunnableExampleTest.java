package Threads.create;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
https://dzone.com/articles/java-thread-tutorial-creating-threads-and-multithr
        https://www.baeldung.com/java-start-thread
        https://www.baeldung.com/java-future
        https://www.baeldung.com/java-start-thread
        https://www.baeldung.com/java-runnable-callable

 */

public class RunnableExampleTest {

    @Test
    public void testRunnable() {
        Thread hilo = new Thread(new RunnableExample());
        System.out.println(hilo.getName());
        System.out.println(hilo.getPriority());
        System.out.println(hilo.isAlive());
        hilo.setName("new name");
        System.out.println(hilo.getName());
        hilo.start();
    }

    @Test
    public void testThread() {
        ThreadExample threadExample = new ThreadExample();
        threadExample.run();
    }

    @Test
    public void testLambdaThread() {
        Runnable newThread = () -> {
            System.out.println(" new thread using lambda");
        };

        newThread.run();
    }


    @Test
    public void thereExecutorService() {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        executor.execute(() -> {
            System.out.println(" new thread using lambda");
        });
        executor.execute(() -> {
            System.out.println(" new thread using lambda2");
        });
        executor.execute(() -> {
            System.out.println(" new thread using lambda3");
        });
        executor.execute(() -> {
            System.out.println(" new thread using lambda4");
        });
        executor.execute(() -> {
            System.out.println(" new thread using lambda5");
        });
        executor.shutdown();
    }

    @Test
    public void thereExecutorServiceScalable() {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executor.execute(() -> {
            System.out.println(" new thread using lambda");
        });
        executor.execute(() -> {
            System.out.println(" new thread using lambda2");
        });
        executor.execute(() -> {
            System.out.println(" new thread using lambda3");
        });
        executor.execute(() -> {
            System.out.println(" new thread using lambda4");
        });
        executor.execute(() -> {
            System.out.println(" new thread using lambda5");
        });

        executor.shutdown();
    }


    @Test
    public void testCallable() {
        CallableExample callableExample = new CallableExample(3);
        try {
            System.out.println(callableExample.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testCreateFuture() throws ExecutionException, InterruptedException {
        CallableExample callableExample = new CallableExample(3);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<Integer> future = executor.submit(callableExample);
        System.out.println(future.get().intValue());

    }
}
