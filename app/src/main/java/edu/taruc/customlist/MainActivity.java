package edu.taruc.customlist;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    String urladdress="http://";
    String[] name;
    String[] email;
    String[] imagepath;
    ListView listView;
    BufferedInputStream is;
    String line=null;
    String result=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView(ListView)findViewById(R.id.listview);

        StrictMode.getThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
    }

    private viod collectData()
    {
        //connection
        try{
            URL url=new URL(urladdress);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            is=new BufferedInputStream((con.getInputStream()));


        }catch(Exception ex)
        {
          ex.printStackTrace();
        }
        //content
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            while ((line=br.readLine())!=null){
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();


        }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }

            //json

        try{
            JSONArray js=new JSONArray((result));
            JSONObject jo =null;
            name=new String[js.length()];
            email=new String[js.length()];
            imagepath=new String[js.length()];

            for(i-0;i<=js.length();i++){
                jo=js.getJSONObject(i);
                name[i]
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }


    }
}
