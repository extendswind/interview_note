package concurrent;


// 一个简单的多线程实现，与简单的对类加锁
// 默认的对对象加锁，当每个类对应多个对象时，下面的结果是test函数会被三个线程同时调用，不存在堵塞
// 下面的对类加锁的方式，每个线程访问时会加锁，因此能够避免多线程


class TestSynchronized{
  public void test(){
    // 当锁住的是整个类的class时，对于多个线程中的多个对象，也会等待锁
    synchronized (TestSynchronized.class) {
      System.out.println("start: " + Thread.currentThread().getName());
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("end: " + Thread.currentThread().getName());
    }
  }

}

public class SimpleThread extends Thread{
  @Override
  public void run(){
    TestSynchronized testSynchronized = new TestSynchronized();
    testSynchronized.test();
  }

  public static void main(String[] argv){

    SimpleThread thread;
    for(int i=0; i<3; i++){
      thread = new SimpleThread();
      thread.setName("test thread: " + i);
      thread.start();
    }
  }

}
