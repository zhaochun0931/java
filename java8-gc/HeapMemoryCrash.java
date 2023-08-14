/* HeapMemoryCrash.java
 * Copyright (c) HerongYang.com. All Rights Reserved.
 */
class HeapMemoryCrash {
   public static void main(String[] a) {
      int max = 1000;
      Object[] arr = new Object[max];
      heapCheck();
      for (int n=0; n<max; n++) {
         arr[n] = new long[10*1024*128];
         System.out.println((n+1)+": "
            +((n+1)*10)+" MB of objects created.");
         heapCheck();
      }
   }
   public static void heapCheck() {
      Runtime rt = Runtime.getRuntime();
      rt.gc();
      long total = rt.totalMemory();
      long free = rt.freeMemory();
      long used = total - free;
      java.io.Console con = System.console();
      con.format("Total memory: %s%n",total);
      con.format(" Free memory: %s%n",free);
      con.format(" Used memory: %s%n",used);
      String str = con.readLine("Press ENTER key to continue: ");
   }
}
