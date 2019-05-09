package com.example.apppi;

import android.os.AsyncTask;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class fetchData extends AsyncTask<Void,Void,Void> {
    private String data = "";
    String st;

    //https://api.myjson.com/bins/1a961u
 /*   private String client_id = "76e9fc9e-d25f-41b1-b045-8f5656458e0b";
    private String client_secret = "82227672-11e3-4a27-80d0-967bb6ce0737";
    private String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJJMHJIV2tYWUlIdV9EVUNrUF9nME5fR0p1S09UMG13Zk1mMHpYRy1rNklJIn0.eyJqdGkiOiJlYWNhZWRkMS1hZTU1LTQxMjUtOTA0YS01NGVhOTFkZmIxODAiLCJleHAiOjE1NTYwMDUxNzksIm5iZiI6MCwiaWF0IjoxNTU2MDAxNTc5LCJpc3MiOiJodHRwczovL3NlY3VyaXR5LWtleWNsb2FrL2F1dGgvcmVhbG1zL3NhbmRib3giLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiN2MwZTdhZWEtYjc4Yy00M2NhLWIzNzYtMzIyOTYzNTA2NzAwIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiNzZlOWZjOWUtZDI1Zi00MWIxLWIwNDUtOGY1NjU2NDU4ZTBiIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiMTY4YTMxN2QtYmZhMy00MWY5LWFhMjEtNzEyN2ZhOGQ5OTUwIiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJyZXRhaWwtYmFua2luZy1wYXltZW50cy12MS1jYTY4NTQ4My04YzExLTQ3OTktYmUzOS02NzRkNGMxYTE1MjMgcmV0YWlsLWJhbmtpbmctYWNjb3VudHMtdjEtNzQ4MGU4MjYtM2UzYy00MzIxLWE4MjAtNDY3YmU5YzUzMzEwIHBsYXRmb3JtIiwiY2xpZW50SWQiOiI3NmU5ZmM5ZS1kMjVmLTQxYjEtYjA0NS04ZjU2NTY0NThlMGIiLCJjbGllbnRIb3N0IjoiMTAuMjA2LjcwLjExOSIsImlzcyI6Imh0dHBzOi8vYXBpLmxvYmRldi5mdXNpb25mYWJyaWMuY2xvdWQvbG9naW4vdjEvc2FuZGJveCIsImNsaWVudEFkZHJlc3MiOiIxMC4yMDYuNzAuMTE5IiwidGVuYW50Ijoic2FuZGJveCIsInVzZXJuYW1lIjoic2VydmljZS1hY2NvdW50LTc2ZTlmYzllLWQyNWYtNDFiMS1iMDQ1LThmNTY1NjQ1OGUwYiJ9.iK9oLs2Vzxkv_540-aa1Y1VyRCduRWnPSZH3aQpJuOs5XvktblRRQLjmrb6_OAS-VxfumnX-UwzlfJVZgkGNVr2xXl7OZmLff0LPPsY_nS9fIOJpcvXNnCdcLmvVg1qIgRfDy31Nzl5B6mGHxh-B4d2QKk2gHyiEjW2328XVLbySFBhliJcl7ywPN2lRQ0psJf2WmECz1dfol6y8qmfYQNnKd0BjvZkvcUUrKSB8bcsC52gPpulNc1XTPjPXyEF1S9DPa6U95b93vg257KIkrQwezTjfq6EJu5KvwiluiihRW0GKDxnsTsPje5u4MVdmIqlG98ImGO8HGFIhSk5cRA";
    private URLConnection conn; */

    @Override
    protected Void doInBackground(Void... voids) {
        try {

         /*   URL url = new URL(st);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            https://www.datakick.org/4800049721135
            */

            URL url = new URL("https://www.datakick.org/api/items/4800010961447");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

          /*  conn.addRequestProperty("client_id", client_id);
            conn.addRequestProperty("client_secret", client_secret);
            conn.setRequestProperty("Authorization", "OAuth " + token); */

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line ="";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.data);
    }
}
