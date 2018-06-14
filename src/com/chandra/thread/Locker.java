package com.chandra.thread;

import java.util.concurrent.CountDownLatch;

public class Locker extends Thread {

   private final CountDownLatch latch;
   private final Object         obj1;
   private final Object         obj2;

   Locker(Object obj1, Object obj2, CountDownLatch latch) {
      this.obj1 = obj1;
      this.obj2 = obj2;
      this.latch = latch;
   }

   @Override
   public void run() {
      synchronized (obj1) {

         latch.countDown();
         try {
            latch.await();
         } catch (InterruptedException e) {
            throw new RuntimeException();
         }
         synchronized (obj2) {
            System.out.println("Thread finished");
         }
      }

   }

   public static void main(String[] args) {
      final Object obj1 = new Object();
      final Object obj2 = new Object();
      final CountDownLatch latch = new CountDownLatch(2);

      new Locker(obj1, obj2, latch).start();
      new Locker(obj2, obj1, latch).start();

   }

}
