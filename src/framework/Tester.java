/**
 * TODO add description.
 * @author Benjamin James Wright (@ben.wright)
 * @author Damon Stacey (@damon.stacey)
 * @version 0.0.1
 * @since 05.04.2012
 */

package framework;

import tests.unstable.ExampleTest;
import tests.unstable.isGameStateImplemented;
//import acceptanceTests.borderlineTests.*;
//import acceptanceTests.trueTests.*;


public class Tester {

   private static final Test[] unverifiedTests = {
      new ExampleTest(),
      new isGameStateImplemented()
   };

   private static final Test[] borderlineTests = {

   };

   private static final Test[] trueTests = {

   };

   public static void main (String[] args) {
      System.out.println ("Roma acceptance tests starting...");
      boolean runTrueTests = true;
      boolean runBorderlineTests = true;
      boolean runUnverifiedTests = true;
      boolean assertionsEnabled = false;
      try {
         assert (false);
      } catch (AssertionError e) {
         assertionsEnabled = true;
      }
      boolean failed = false;
      if (!assertionsEnabled) {
         System.out.println ("Please enable assertions, run with java -ea");
         failed = true;
      } else {
         // step thru all the tests one at a time
         if (runTrueTests) {
            if (doesFailTests(trueTests))
               failed = true;
         }
         if (runBorderlineTests) {
            if (doesFailTests(borderlineTests))
               failed = true;
         }
         if (runUnverifiedTests) {
            if (doesFailTests(unverifiedTests))
               failed = true;
         }
      }
      if (failed) {
         System.out.println ("FAILED");
         System.out.println ("Not accepted!");
      } else {
         System.out.println ("ACCEPTED");
         System.out.println ("You are awesome!");
      }
   }


   private static boolean doesFailTests(Test[] tests) {

      Test test;
      boolean failed = false;
      for ( int i = 0; i < tests.length && !failed; i++) {
         test = tests[i];
         System.out.println ("* "+test);
         try {
            test.run();
         } catch (Throwable t) {
            System.out.println ("TEST FAILED");
            System.out.println ("Printing stack trace...");
            t.printStackTrace ();
            failed = true;
         }
      }
      return failed;
   }
}
