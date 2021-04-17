package com.github.yangli2004;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

public class Application {
   private static Node head;
   static char[] uppers = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'k', 'L', 'M', 'N', 'O', 'P',
         'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
   static char[] lowers = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
         'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

   public static void main(String[] args) {
     /* int r = 3;
      List<Long> arr = Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L);

      Map<Long, Long> rightMap = new HashMap<>();
      Map<Long, Long> leftMap = new HashMap<>();

      arr.stream().forEach(e -> rightMap.put(e, rightMap.getOrDefault(e, 0L) + 1));

      int count =0;

      for(int i=0; i< arr.size(); i++) {
         long mid = arr.get(i);
         long c1 = 0, c3 =0;
         rightMap.put(mid, rightMap.getOrDefault(mid, 0L) -1);
         if(leftMap.containsKey(mid/r) && mid % r ==0) {
            c1 = leftMap.get(mid/r);
         }
         if(rightMap.containsKey(mid * r)) {
            c3 = rightMap.get(mid*r);
         }
         count += c1 * c3;

         leftMap.put(mid, leftMap.getOrDefault(mid, 0L) +1);
      }


      System.out.println(count);*/

     /* try {
         crypto();
      } catch (Exception e) {
         e.printStackTrace();
      }*/

      /*Map<Person, String> map = new HashMap<>();

      Person p1 = new Person("Yang", "Li");
      Person p2 = new Person("Yang", "Li");

      System.out.println(Integer.toHexString(p1.hashCode()));
      System.out.println(Integer.toHexString(p2.hashCode()));

      map.put(p1, "one");
      map.put(p2, "two");

      System.out.println(map);

      p2.firstName="Yang";
      p2.lastName="Li";
      System.out.println(map);

      System.out.println(Integer.toHexString("Yang Li".hashCode()));
      System.out.println(Integer.toHexString("Yang Li".hashCode()));*/

      //System.out.println(rotationalCipher("abcdZXYzxy-999.@", 200));
      //System.out.println(rotationalCipher2("abcdZXYzxy-999.@", 200));
      /*long start = System.currentTimeMillis();
      System.out.println(fib2(100, new double[101]));
      //System.out.println(fib(7));
      long end = System.currentTimeMillis();
      System.out.println(end - start);*/
      /*System.out.println(fib2(50, new HashMap<>()));
      System.out.println(System.currentTimeMillis()-end);*/
      //pairSums(new int[] { 1, 5, 3, 3, 3 }, 6);
      //countSubArrays(new int[] {3, 4, 1, 6, 2});
      findSignature(new int[] {2, 1});
   }

   private static void findSignature(int[] arr){
      int [] result = new int[arr.length];
      for(int i=0; i<arr.length; i++) {
         int v = arr[i];
         int counter = 1;
         for(int j = v-1; j>=0; j--) {
            if(arr[j]!=v) {
               counter++;
            }
         }
         result[i] = counter;
      }
   }

   private static void countSubArrays(int[] arr) {
      int[] result = new int[arr.length];
      for (int i = 0; i < arr.length; i++) {
         int counter = 1;
         if (i > 0) {
            for (int j = i - 1; j >= 0; j--) {
               if (arr[j] >= arr[i]) {
                  counter += i - j - 1;
                  break;
               } else if (j == 0) {
                  counter += i;
               }
            }
         }

         if (i < arr.length - 1) {
            for (int j = i + 1; j < arr.length; j++) {
               if (arr[j] >= arr[i]) {
                  counter += j - i - 1;
                  break;
               } else if(j==(arr.length -1)) {
                  counter += j-i;
               }
            }
         }

         result[i] = counter;
      }
      Arrays.stream(result).forEach(v ->System.out.println(v +","));
   }

   private static void pairSums(int[] arr, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int v : arr) {
         if (map.get(v) == null) {
            map.put(v, 1);
         } else {
            map.put(v, map.get(v) + 1);
         }
      }

      int counter = 0;
      for (int v : arr) {
         if (map.get(k - v) != null) {
            counter += map.get(k - v);
         }
         if (k - v == v) {
            counter--;
         }
      }

      System.out.println(counter / 2);

   }

   //
   private static double fib2(int n, double[] map) {
      if (n < 2) {
         return n;
      } else if (map[n] == 0) {
         map[n] = fib2(n - 1, map) + fib2(n - 2, map);
      }
      return map[n];
   }

   private static double fib(int n) {
      if (n < 2) {
         return n;
      } else {
         return fib(n - 1) + fib(n - 2);
      }
   }

   private static char findLetter(char c, int rotation, char[] chars) {
      int index = 0;
      for (int i = 0; i < chars.length; i++) {
         if (chars[i] == c) {
            index = i;
            break;
         }
      }
      index += rotation;
      index = index % chars.length;
      return chars[index];
   }

   private static char nextChar(char c, int rotation) {
      char next;
      if (Character.isUpperCase(c)) {
         next = findLetter(c, rotation, uppers);
      } else {
         next = findLetter(c, rotation, lowers);
      }
      return next;
   }

   private static String rotationalCipher(String input, int rotationFactor) {
      // Write your code here
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < input.length(); i++) {
         char c = input.charAt(i);
         if (Character.isLetter(c)) {
            sb.append(nextChar(c, rotationFactor));
         } else if (Character.isDigit(c)) {
            int val = (Integer.parseInt(c + "") + rotationFactor) % 10;
            sb.append(val);
         } else {
            sb.append(c);
         }
      }
      return sb.toString();

   }

   private static char rotateLetter(char c, int rotation) {
      if (Character.isUpperCase(c)) {
         return (char) (((c - 'A' + rotation) % 26) + 'A');
      } else {
         return (char) (((c - 'a' + rotation) % 26) + 'a');
      }
   }

   private static String rotationalCipher2(String input, int rotation) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < input.length(); i++) {
         char c = input.charAt(i);
         if (Character.isLetter(c)) {
            sb.append(rotateLetter(c, rotation));
         } else if (Character.isDigit(c)) {
            int val = (Integer.parseInt(c + "") + rotation) % 10;
            sb.append(val);
         } else {
            sb.append(c);
         }
      }
      return sb.toString();
   }

   /*private static int findNextNumber(int original, int rotation, int offset, ) {

   }*/

   private static void crypto() throws Exception {
      String alg = "PBKDF2WithHmacSHA256";
      String passPhrase = "CIRA_ROCKS";
      int iteration = 10000;
      //SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
      byte[] salt = "ROCKHARD".getBytes();
      byte[] iv = "asdfasdfasdfasdf".getBytes();
      //sr.nextBytes(salt);

      String password = "password23";

      PBEKeySpec spec = new PBEKeySpec(passPhrase.toCharArray(), salt, iteration, 256);
      SecretKeyFactory kf = SecretKeyFactory.getInstance(alg);
      SecretKey key = new SecretKeySpec(kf.generateSecret(spec).getEncoded(), "AES");
      Cipher encrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
      encrypt.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
      AlgorithmParameters parameters = encrypt.getParameters();
      //byte[] iv = parameters.getParameterSpec(IvParameterSpec.class).getIV();
      byte[] encrypted = encrypt.doFinal(password.getBytes());

      System.out.println(Base64.getEncoder().encodeToString(iv));
      String encryptedPWD = Base64.getEncoder().encodeToString(encrypted);

      System.out.println(encryptedPWD);

      Cipher decrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
      decrypt.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));

      byte[] data = Base64.getDecoder().decode(encryptedPWD);
      byte[] decryptedData = decrypt.doFinal(data);

      String pwd = new String(decryptedData, "UTF-8");

      System.out.println(pwd);

   }

   private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
      byte[] bytes = new byte[hex.length() / 2];
      for (int i = 0; i < bytes.length; i++) {
         bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
      }
      return bytes;
   }

   private static String toHex(byte[] array) {
      BigInteger bi = new BigInteger(1, array);
      String hex = bi.toString(16);
      int paddingLength = (array.length * 2) - hex.length();
      if (paddingLength > 0)
         return String.format("%0" + paddingLength + "d", 0) + hex;
      else
         return hex;
   }

   private static void traverseForward(Node node) {
      while (node != null) {
         System.out.println(node.data);
         node = node.next;
      }
   }

   private static void traverseBack(Node node) {
      if (node == null) {
         return;
      }
      traverseBack(node.next);
      System.out.println(node.data);
   }

   private static class Node {

      int data;
      Node next;

      Node(int d) {
         data = d;
         next = null;
      }
   }

   private static void concurrentMap() {
      ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
      map.put("foo", "bar");
      map.put("han", "solo");
      map.put("r2", "d2");
      map.put("c3", "p0");
      String result = map.reduce(1,
            (k, v) -> {
               System.out.println("Transform: " + Thread.currentThread().getName());
               return k + "=" + v;
            },
            (s1, s2) -> {
               System.out.println("Reduce: " + Thread.currentThread().getName());
               return s1 + ", " + s2;
            }
      );

      System.out.println("Result: " + result);
   }

   private static void atomicVars() {
      LongBinaryOperator op = (x, y) -> 2 * x + y;
      LongAccumulator accumulator = new LongAccumulator(op, 1L);
      ExecutorService executor = Executors.newFixedThreadPool(2);
      IntStream.range(0, 10)
            .forEach(i -> executor.submit(() -> accumulator.accumulate(i)));
      stop(executor);
      System.out.println(accumulator.getThenReset());
   }

   private static void synchronizedTest() {

      ExecutorService executor = Executors.newFixedThreadPool(10);
      Semaphore semaphore = new Semaphore(5);
      Runnable longRunningTask = () -> {
         boolean permit = false;
         try {
            permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
            System.out.println("semaphore count " + semaphore.getQueueLength());
            if (permit) {
               System.out.println("Semaphore acquired");
               sleep(5);
            } else {
               System.out.println("Could not acquire semaphore");
            }
         } catch (InterruptedException e) {
            e.printStackTrace();
         } finally {
            if (permit) {
               semaphore.release();
            }
         }
      };

      IntStream.range(0, 10).forEach(i -> executor.submit(longRunningTask));

      stop(executor);

   }

   private static void increment() {
      //      lock.lock();
      //      try {
      //         count = count + 1;
      //      } finally {
      //         lock.unlock();
      //      }

   }

   private static void scheduled() throws InterruptedException {
      ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
      Runnable task = () -> {
         try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Scheduling: " + System.nanoTime());
         } catch (InterruptedException e) {
            System.err.println("task interrupted");
         }

      };

      int initialDelay = 0;
      int period = 1;
      ScheduledFuture<?> future = executor.scheduleWithFixedDelay(task, initialDelay, period, TimeUnit.SECONDS);
   }

   private static void callAble() throws ExecutionException, InterruptedException, TimeoutException {

      List<Callable<String>> callables = Arrays.asList(
            callable("task1", 2),
            callable("task2", 1),
            callable("task3", 3));

      ExecutorService executor = Executors.newWorkStealingPool();
      System.out.println(executor.invokeAny(callables));
   }

   private static Callable<String> callable(String name, long seconds) {
      return () -> {
         TimeUnit.SECONDS.sleep(seconds);
         return name;
      };
   }

   private static void threads() {
      ExecutorService executor = Executors.newSingleThreadExecutor();
      executor.submit(() -> {
         String threadName = Thread.currentThread().getName();

         System.out.println("Hello " + threadName);
         throw new Exception();
      });

      /*try {
         System.out.println("attempt to shutdown executor");
         executor.shutdown();
         executor.awaitTermination(5, TimeUnit.SECONDS);
         System.out.println("shutdown normally");
      } catch (InterruptedException e) {
         System.err.println("tasks interrupted");
      } finally {
         if (!executor.isTerminated()) {
            System.err.println("cancel non-finished tasks");
         }
         if (!executor.isShutdown()) {
            System.out.println("shutdown now");
            executor.shutdownNow();
         }
         System.out.println("shutdown finished");
      }*/

      /*Runnable task = () -> {
         try {
            String name = Thread.currentThread().getName();
            System.out.println("Foo " + name);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bar " + name);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      };


      //task.run();
      Thread thread = new Thread(task);
      thread.start();
      */

      System.out.println("Done !");
   }

   private static long testDateTime(String timeStr, LocalDateTime refDate) {
      String WEB_DATE_FORMAT = "dd/MM/yyyy";
      int DAY_IN_MIN = 1440;
      DateTimeFormatter dtf =
            DateTimeFormatter.ofPattern(WEB_DATE_FORMAT + " HH:mm");

      String dd = refDate.getDayOfMonth() > 9 ? "" + refDate.getDayOfMonth() : "0" + refDate.getDayOfMonth();
      String mm = refDate.getMonthValue() > 9 ? "" + refDate.getMonthValue() : "0" + refDate.getMonthValue();

      LocalDateTime scheduledDate =
            LocalDateTime.parse(String.format("%s/%s/%s %s", dd,
                  mm, refDate.getYear(), timeStr), dtf);

      long nextExec = refDate.until(scheduledDate, ChronoUnit.MINUTES);
      //adjust negative value: means that the scheduled time is a past time
      return nextExec < 0 ? DAY_IN_MIN + nextExec : nextExec;
   }

   public static void printArray(int[][] data) {
      Arrays.stream(data).forEach(ar -> {
         Arrays.stream(ar).forEach(i -> System.out.print(i + " "));
         System.out.println();
      });
   }

   public static int[][] gameLife(int[][] data) {
      int[][] result = new int[data.length][];
      for (int i = 0; i < data.length; i++) {
         int[] curr = data[i];
         int[] above = i > 0 ? data[i - 1] : new int[0];
         int[] below = i < data.length - 1 ? data[i + 1] : new int[0];
         int[] tmp = new int[curr.length];
         for (int j = 0; j < curr.length; j++) {
            int counter = 0;
            if (j > 0 && curr[j - 1] == 1) {
               counter++;
            }
            if (j < curr.length - 1 && curr[j + 1] == 1) {
               counter++;
            }
            if (above.length > 0 && above[j] == 1) {
               counter++;
            }
            if (below.length > 0 && below[j] == 1) {
               counter++;
            }

            if (counter >= 2) {
               tmp[j] = 1;
            } else {
               tmp[j] = 0;
            }

         }

         result[i] = tmp;
      }
      return result;
   }

   public static Map<Integer, List<Integer>> gameOfLife(Map<Integer, List<Integer>> data) {
      Map<Integer, List<Integer>> result = new HashMap<>();
      for (Integer k : data.keySet()) {
         List<Integer> tmp = new ArrayList<>();
         for (int i = 0; i < data.get(k).size(); i++) {
            if (isAlive(k, i, data)) {
               tmp.add(1);
            } else {
               tmp.add(0);
            }
         }
         result.put(k, tmp);
      }
      return result;
   }

   public static boolean isAlive(Integer k, int pos, Map<Integer, List<Integer>> data) {
      int counter = 0;
      List<Integer> current = data.get(k);
      List<Integer> above = k > 0 ? data.get(k - 1) : new ArrayList<>();
      List<Integer> blow = k < data.size() - 1 ? data.get(k + 1) : new ArrayList<>();
      if (pos > 0 && current.get(pos - 1) == 1) {
         counter++;
      }
      if (pos < current.size() - 1 && current.get(pos + 1) == 1) {
         counter++;
      }
      if (!above.isEmpty() && above.get(pos) == 1) {
         counter++;
      }
      if (!blow.isEmpty() && blow.get(pos) == 1) {
         counter++;
      }

      return counter >= 2;

   }

   private static void printData(Map<Integer, List<Integer>> data) {

      for (Integer k : data.keySet()) {
         data.get(k).forEach(v -> System.out.print(v + " "));
         System.out.println();
      }

   }

   private static void stop(ExecutorService executor) {
      try {
         executor.shutdown();
         executor.awaitTermination(60, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
         System.err.println("termination interrupted");
      } finally {
         if (!executor.isTerminated()) {
            System.err.println("killing non-finished tasks");
         }
         executor.shutdownNow();
      }
   }

   private static void sleep(int seconds) {
      try {
         TimeUnit.SECONDS.sleep(seconds);
      } catch (InterruptedException e) {
         throw new IllegalStateException(e);
      }
   }

   private static class Singleton {
      private static Singleton instance;
      private boolean inUse;
      private int val;

      private Singleton() {
         inUse = true;
         val = 5;
      }

      public static Singleton getInstance() {
         if
         (instance == null)
            instance = new Singleton();
         return instance;
      }

      public static Singleton getInstance2() {
         if (instance == null) {
            synchronized (Singleton.class) { //1
               if (instance == null) //2
                  instance = new Singleton(); //3
            }
         }
         return instance;
      }

      public static Singleton getInstance3() {
         if (instance == null) {
            synchronized (Singleton.class) {//1
               Singleton inst = instance; //2
               if (inst == null) {
                  synchronized (Singleton.class) { //3
                     inst = new Singleton(); //4
                  }
                  instance = inst; //5
               }
            }
         }
         return instance;
      }

   }

   private static class Person {
      String firstName;
      String lastName;

      public Person(final String firstName, final String lastName) {
         this.firstName = firstName;
         this.lastName = lastName;
      }
   }
}
