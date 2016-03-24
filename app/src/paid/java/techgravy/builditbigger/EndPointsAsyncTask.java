package techgravy.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import techgravy.androidlibrary.JokeDisplayActivity;
import techgravy.p4.backened.jokeApi.JokeApi;
import techgravy.p4.backened.jokeApi.model.JokeBean;

/**
 * Created by aditlal on 15/02/16.
 */
class EndPointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static JokeApi myApiService = null;
    private Context context;
    private boolean isProgress;


    public EndPointsAsyncTask(Context context, boolean isProgress) {

        this.isProgress = isProgress;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (isProgress) {
            CommonUtils.displayProgressDialog(context, "Fetching a fancy joke");
        }
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (myApiService == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.1.84:8080/_ah/api/");
            myApiService = builder.build();
        }

        try {
            return myApiService.putJoke(new JokeBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String result) {
        Log.d("Result", result);
        if (isProgress)
            CommonUtils.dismissProgressDialog();
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.INTENT_TAG, result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
