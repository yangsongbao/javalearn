package per.yang.lock;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public static void main(String[] args) {

        Date reasonableSendTime = getReasonableSendTime();
        System.out.println(reasonableSendTime);

    }


    private static Date getReasonableSendTime() {
        DateTime sendTime = DateTime.now().plusHours(16);
        if (sendTime.getHourOfDay() >= 21) {
            return sendTime.plusDays(Days.ONE.getDays()).withTimeAtStartOfDay().plusHours(10).toDate();
        }
        if (sendTime.getHourOfDay() < 9) {
            return sendTime.withTimeAtStartOfDay().plusHours(10).toDate();
        }
        return sendTime.toDate();
    }

}
