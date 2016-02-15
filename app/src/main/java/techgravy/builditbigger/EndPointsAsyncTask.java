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


    public EndPointsAsyncTask(Context context) {
        this.context = context;
    }


    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (myApiService == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.1.61:8080/_ah/api/");


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
        Log.d("Result",result);
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.TAG, result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
