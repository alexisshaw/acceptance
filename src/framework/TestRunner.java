package framework;

import framework.interfaces.AcceptanceInterface;

import tests.stable.*;
import tests.testing.*;
import tests.unstable.*;

/**
 * Class to run several tests, and handle the results
 *
 * @author Matthew Moss (matthew.moss)
 * @author Lasath Fernando (lasath.fernando)
 * @author Benjamin James Wright (ben.wright)
 * @author Damon Stacey (damon.stacey)
 */
public class TestRunner {

    AcceptanceInterface testee;
    int numTestsPassed = 0;
    int numTestFailed = 0;
    int numNotImplemented = 0;
    int numInvalidTests = 0;

    private static Test[] getUnverifiedTests() {

        return new Test[]{};
    }

    private static Test[] getBorderlineTests() {

        return new Test[]{};
    }

    private static Test[] getTrueTests() {

        return new Test[]{};
    }

    public static void main(String[] args) {

        TestRunner runner = new TestRunner();
        runner.doYourThing();
    }

    private void doYourThing() {
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
            runTests(getTrueTests());
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

            } catch (AssertionError e) {
                numTestFailed++;
                System.out.println(current.getOutputSteam());
                System.out.println("Test Failed");

            } catch (UnsupportedOperationException e) {
                numNotImplemented++;
                System.out.println(current.getOutputSteam());
                System.out.println("Test Failed");

            } catch (IllegalArgumentException e) {
                numInvalidTests++;
                System.out.println(current.getOutputSteam());
                System.out.println("Test Failed");
            }
        }
    }
}
