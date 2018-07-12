package ken.visa1;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TrackStatus extends AppCompatActivity {

    String byidURL = "http://103.21.34.216:81/visa/query.php";
    String DocNo;

    private EditText PassportNo;
    private TextView StartDate;
    private TextView EndDate;
    private TextView VisaType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_status);
        PassportNo = (EditText)findViewById(R.id.passportNo);
        StartDate = (TextView)findViewById(R.id.StartDate);
        EndDate = (TextView)findViewById(R.id.EndDate);
        VisaType = (TextView)findViewById(R.id.VisaType);
    }

    public void buttonOnClick (View view)
    {

        Query();

    }


    public void Query()
    {  final ProgressDialog loading = ProgressDialog.show(this,"Uploading...","Please wait...",false,false);
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, byidURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            System.out.println(response);

                            //Creating JsonObject from response String
                            JSONObject jsonObject = new JSONObject(response.toString());

                            //extracting json array from response string
                            JSONArray jsonArray = jsonObject.getJSONArray("customer");
                            System.out.println("test" + jsonArray.length());

                            if(jsonArray.length() == 0)
                            {
                                Toast.makeText(getApplicationContext(), "Passport Number does not exist", Toast.LENGTH_SHORT).show();
                            }

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject customer = jsonArray.getJSONObject(i);


                                String VisaTypeDet = customer.getString("VisaType");
                                String EntryDate = customer.getString("EntryDate");
                                String ExitDate = customer.getString("ExitDate");
                                VisaType.setText(VisaTypeDet);
                                StartDate.setText(EntryDate);
                                EndDate.setText(ExitDate);
                            }
                        }
                        catch (JSONException ex)
                        {

                        }        loading.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error);
                    }
                }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("AccNo", PassportNo.getText().toString());
                return parameters;
            }

        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
