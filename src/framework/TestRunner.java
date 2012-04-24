package framework;

import framework.interfaces.AcceptanceInterface;
import java.util.logging.Level;
import java.util.logging.Logger;

import tests.verified.*;
import tests.borderline.*;
import tests.unverified.*;

import org.reflections.Reflections;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Constructor;
import java.util.Set;

/**
 * Class to run several tests, and handle the results
 *
 * @author Matthew Moss (matthew.moss)
 * @author Lasath Fernando (lasath.fernando)
 * @author Benjamin James Wright (ben.wright)
 * @author Damon Stacey (damon.stacey)
 * @author Alexis Shaw (alexis.shaw)
 */
public class TestRunner {

    AcceptanceInterface testee;
    int numTestsPassed = 0;
    int numTestFailed = 0;
    int numNotImplemented = 0;
    int numInvalidTests = 0;


    private static Test[] getUnverifiedTests() {
         return getTestsInPackage("tests.unverified");
    }

    private static Test[] getBorderlineTests() {
         return getTestsInPackage("tests.borderline");
    }

    private static Test[] getVerifiedTests() {
         return getTestsInPackage("tests.verified");
    }

    private static Test[] getTestsInPackage(String packageName){
         Reflections reflections = new Reflections(packageName);
         Set<Class<? extends Test>> testClasses = reflections.getSubTypesOf(Test.class);

         Test[] returnValue = new Test[testClasses.size()];
         int NumClassesWithEmptyConstructor = 0;
         for(Class<? extends Test> testClass : testClasses){
             try{
                 Constructor<? extends Test> testConstructor = testClass.getConstructor();
                 returnValue[NumClassesWithEmptyConstructor] = testConstructor.newInstance();
                 NumClassesWithEmptyConstructor++;
             } catch (Exception e){}
         }
         assert(NumClassesWithEmptyConstructor == testClasses.size());

        return returnValue;
    }

    public static void main (String[] args) {
         TestRunner runner = new TestRunner();
         runner.testGame();
    }

    public void testGame() {
        System.out.println("Roma acceptance tests starting...");

        boolean assertionsEnabled = false;
        try {
            assert (false);
        } catch (AssertionError e) {
            assertionsEnabled = true;
        }

        boolean failed;
        if (!assertionsEnabled) {
            System.out.println("Please enable assertions, run with java -ea");
            failed = true;
        } else {
            // step through all the tests one at a time
            runTests(getVerifiedTests());
            runTests(getBorderlineTests());
            runTests(getUnverifiedTests());

            failed = (numTestFailed > 0) || (numNotImplemented > 0);
        }

        if (failed) {
            System.out.println("FAILED");
            System.out.println("Not accepted!");
        } else {
            System.out.println("ACCEPTED");
            System.out.println("You are awesome!");
        }
    }

    private void runTests(Test[] tests) {

        for (Test current : tests) {
            try {
                System.out.println("Running Test " + current.getClass() + ":");
                System.out.println("\t" + current.getShortDescription());

                current.run(null, null);

                numTestsPassed++;
                System.out.println("Test passed");

            } catch (UnsupportedOperationException ex) {
                numNotImplemented++;
                System.out.println("Feature not implemented yet. Skipping test...");

            } catch (IllegalArgumentException ex) {
                numInvalidTests++;
                System.out.println(current.getOutputSteam());
                Logger.getLogger(TestRunner.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error in test. Please report this to your "
                        + "representative.");

            } catch (Exception ex) {
                numTestFailed++;
                System.out.println(current.getOutputSteam());
                Logger.getLogger(TestRunner.class.getName()).log(Level.SEVERE, null, ex);

                System.out.println("Test Failed");
            }
        }
    }
}
