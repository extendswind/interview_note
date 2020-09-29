package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {

  public static void main(String[] argv){
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    ExecutorService executorService2 = Executors.newCachedThreadPool();
  }
}
