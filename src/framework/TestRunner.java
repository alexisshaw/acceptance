package framework;

import framework.interfaces.*;
import framework.interfaces.AcceptanceInterface;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

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
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .filterInputsBy(new FilterBuilder.Include(FilterBuilder.prefix(packageName)))
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new SubTypesScanner()));
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
    private static AcceptanceInterface[] getAcceptanceInterfacesInPackage(String packageName){
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new SubTypesScanner()));
        Set<Class<? extends AcceptanceInterface>> acceptanceInterfaceClasses =
                    reflections.getSubTypesOf(AcceptanceInterface.class);
        for(Class<? extends AcceptanceInterface> c : acceptanceInterfaceClasses){
            System.out.println(c.getCanonicalName());
        }
        AcceptanceInterface[] returnValue = new AcceptanceInterface[acceptanceInterfaceClasses.size()];
        int noClassesWithEmptyConstructor = 0;
        for(Class<? extends AcceptanceInterface> acceptanceInterfaceClass:acceptanceInterfaceClasses){
            try{            
                Constructor<? extends AcceptanceInterface> acceptanceInterfaceConstructor =
                        acceptanceInterfaceClass.getConstructor();
                returnValue[noClassesWithEmptyConstructor] = acceptanceInterfaceConstructor.newInstance();
                noClassesWithEmptyConstructor++;
            } catch (Exception e){}
        }
        assert(noClassesWithEmptyConstructor == acceptanceInterfaceClasses.size());
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
        AcceptanceInterface[] acceptanceInterfaces = getAcceptanceInterfacesInPackage("");
        assert(acceptanceInterfaces.length > 0);
        for (AcceptanceInterface acceptanceInterface: acceptanceInterfaces){
            for (Test current : tests) {
                try {
                    System.out.println("Running Test " + current.getClass() + ":");
                    System.out.println("\t" + current.getShortDescription());

                    GameState state = acceptanceInterface.getInitialState();
                    MoveMaker mover = acceptanceInterface.getMover(state);
                    current.run(state,mover);
 
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
}
