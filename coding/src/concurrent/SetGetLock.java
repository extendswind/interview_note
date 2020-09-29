package concurrent;

/**
 * 测试set函数是否会堵塞get函数
 * 当输出中"set begin -- ..." 和 "set end -- .." 之间有 get输出时，证明没有堵塞
 *
 * 当synchronized加在函数上时，上锁的位置并非代码段，而是整个对象。也就是说，
 * 当synchronized标记的函数被调用时，同对象其它synchronized标记的函数也需要等待当前函数执行完释放完锁。
 */


// 设计为线程安全的类
class LockClass{
  int local = 0;
  public LockClass(){
    System.out.println("construction");
  }

  // 可以测试此处，如果不加锁，get函数会在set函数未执行完时获取local的值
  public synchronized int get(){
    System.out.println("get");
    return local;

  }
  public synchronized void set(int value){
      System.out.println("set begin -- " + Thread.currentThread().getName());
      local = value;
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {

      }
      System.out.println("set end -- " + Thread.currentThread().getName());
  }
}

public class SetGetLock{


  public static void main(String[] argv){

    LockClass lockClass = new LockClass();
    for(int i=0; i<3; i++){
      Thread thread = new Thread(){
        @Override
        public void run(){
          int get = lockClass.get();
          lockClass.set(get + 1);
          System.out.println(lockClass.get());
        }
      };
      thread.setName("test thread: " + i);
      thread.start();
    }
  }

}
