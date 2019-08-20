package Threads.create;

import java.util.concurrent.Callable;

public class CallableExample implements Callable<Integer> {

    private Integer value;

    public CallableExample(Integer value) {
        this.value = value;
    }

    @Override
    public Integer call() throws Exception {
        return Math.min(value,2);
    }
}
