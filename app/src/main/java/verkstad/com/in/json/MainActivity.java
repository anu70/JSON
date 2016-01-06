package verkstad.com.in.json;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;


public class MainActivity extends ActionBarActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void send(View view) {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "http://api.androidhive.info/contacts/";

        final StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject jsonObject=new JSONObject(s);
                    JSONArray jsonArray=jsonObject.getJSONArray("contacts");

                    String id[]=new String[jsonArray.length()];String name[]=new String[jsonArray.length()];String email[]=new String[jsonArray.length()];
                    String address[]=new String[jsonArray.length()];String gender[]=new String[jsonArray.length()];String mobile[]=new String[jsonArray.length()];
                    String home[]=new String[jsonArray.length()];String office[]=new String[jsonArray.length()];

                    for(int i=0;i<jsonArray.length();i++) {
                        JSONObject n = jsonArray.getJSONObject(i);
                        String id1 = n.getString("id");
                        id[i]=id1;
                        String name1 = n.getString("name");
                        name[i]=name1;
                        String email1 = n.getString("email");
                        email[i]=email1;
                        String address1 = n.getString("address");
                        address[i]=address1;
                        String gender1 = n.getString("gender");
                        gender[i]=gender1;

                        JSONObject phone = n.getJSONObject("phone");
                        String mobile1=phone.getString("mobile");
                        mobile[i]=mobile1;
                        String home1=phone.getString("home");
                        home[i]=home1;
                        String office1=phone.getString("office");
                        office[i]=office1;

                    }
                   // Toast.makeText(getApplicationContext(),Arrays.toString(address),Toast.LENGTH_LONG).show();

                  CustomList cl = new CustomList(MainActivity.this ,id,name,email,address,gender,mobile,home,office);
                    listView= (ListView) findViewById(R.id.listView);
                  //  ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.customlist,name);
                   listView.setAdapter(cl);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
      requestQueue.add(stringRequest);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
