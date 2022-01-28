class MyThread extends Thread{
  @Override
  public void run(){
    //
    for(int i=0;i<=1000;i++){
      System.out.println(Thread.currentThread().getName() + " counts: " + i);
    }
  }
}

class MainThread{
  public static void main(String[] args){
    MyThread t1 = new MyThread();
    t1.start();
  }
}