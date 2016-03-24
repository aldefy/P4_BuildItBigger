package techgravy.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

/**
 * Created by aditlal on 15/02/16.
 */
public class EmptyStringTest extends AndroidTestCase {

    private static final String LOG_TAG = "EmptyStringTest";


    @SuppressWarnings("unchecked")
    public void runTest() {


        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        Log.v(LOG_TAG, "Running EmptyStringTest test");

        String result = null;
        EndPointsAsyncTask endpointsAsyncTask = new EndPointsAsyncTask(getContext(),false);
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
            Log.d(LOG_TAG, "Yay, Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }


}
