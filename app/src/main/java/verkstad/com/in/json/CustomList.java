package verkstad.com.in.json;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;

/**
 * Created by anu on 12/25/2015.
 */
public class CustomList extends ArrayAdapter<String> {
    String[] id;
    String[] name;
    String[] email;
    String[] address;
    String[] gender;
    String[] mobile;
    String[] home;
    String[] office;
    Activity context;


    public  CustomList(Activity context, String[] id, String[] name, String[] email, String[] address,
                      String[] gender, String[] mobile, String[] home, String office[]) {
        super(context, R.layout.customlist,name);

        this.context = context;
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.mobile = mobile;
        this.home=home;
        this.office=office;
        Toast.makeText(context,"customlist is called",Toast.LENGTH_LONG).show();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItems = inflater.inflate(R.layout.customlist, null, true);
        TextView textViewid= (TextView) listViewItems.findViewById(R.id.textView2);
        TextView textViewname= (TextView) listViewItems.findViewById(R.id.textView3);
        TextView textViewemail= (TextView) listViewItems.findViewById(R.id.textView4);
        TextView textViewaddress= (TextView) listViewItems.findViewById(R.id.textView5);
        TextView textViewgender= (TextView) listViewItems.findViewById(R.id.textView6);
        TextView textViewmobile= (TextView) listViewItems.findViewById(R.id.textView7);
        TextView textViewhome= (TextView) listViewItems.findViewById(R.id.textView8);
        TextView textViewoffice= (TextView) listViewItems.findViewById(R.id.textView9);

        textViewid.setText(id[position]);
        textViewname.setText(name[position]);
        textViewemail.setText(email[position]);
        textViewaddress.setText(address[position]);
        textViewgender.setText(gender[position]);
        textViewmobile.setText(mobile[position]);
        textViewhome.setText(home[position]);
        textViewoffice.setText(office[position]);

        return listViewItems;

    }
}