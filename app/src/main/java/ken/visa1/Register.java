package ken.visa1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity implements View.OnClickListener {
//Activity to register Login details
    protected final String TAG = getClass().getSimpleName();
    //MySQL
    String byidURL = "http://aril.16mb.com/visa/registervisalogin.php";
    private static final String ServerAddress = "152.3.214.12:8080";
    private static final int CAMERA_REQUEST = 1888;
    //Item
    private EditText Email;
    private EditText PhoneNumber;
    private EditText Nickname;
    private EditText Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Spinner element
        Email = (EditText) findViewById(R.id.Email);
        PhoneNumber = (EditText) findViewById(R.id.PhoneNo);
        Nickname = (EditText) findViewById(R.id.Nickname);
        Password = (EditText) findViewById(R.id.Password);

    }

    @Override
    public void onClick(View view) {
        registerUser();
    }

    public void registerUser()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, byidURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.w(TAG, "response: " + response);
                        Toast.makeText(Register.this, response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(error instanceof TimeoutError)
                        {
                            Log.d(TAG, error.getMessage());
                        }
                        if (error instanceof NetworkError) {

                            Toast.makeText(getApplicationContext(), "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                            //Log.d(TAG, "Cannot connect to Internet...Please check your connection!");
                        }
                        //System.out.println(error);
                    }
                }){
            @Override
            protected Map<String,String> getParams(){

                //Converting Bitmap to String
                //String image = getStringImage(mphoto);
                Map<String,String> params = new HashMap<String, String>();
                params.put("Email",Email.getText().toString());
                params.put("PhoneNo",PhoneNumber.getText().toString());
                params.put("Nickname",Nickname.getText().toString());
                params.put("Password",Password.getText().toString());

                return params;

            }
        };
        //stringRequest.setRetryPolicy(new DefaultRetryPolicy(7000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
