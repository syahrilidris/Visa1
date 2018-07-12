package ken.visa1;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Overview extends AppCompatActivity implements View.OnClickListener {

    protected final String TAG = getClass().getSimpleName();
    //MySQL

    String byidURL = "http://103.21.34.216:81/visa/query2.php";
    private static final String ServerAddress = "152.3.214.12:8080";

    private ProgressDialog progress;

    //Item
    private EditText VisaDetailsInput;
    private TextView VisaDetails;
    //DOB
    private DatePickerDialog fromDatePickerDialog;

    TextView tvName;
    TextView tvNationality;
    TextView tvType;
    TextView tvPassportNo;
    TextView tvGender;
    TextView tvDOB;
    TextView tvMail;
    TextView tvAddress;
    TextView tvPostcode;
    TextView tvCity;
    TextView tvCountry;
    TextView tvPhoneNo;
    TextView tvEntry;
    TextView tvExit;
    TextView tvStatus;
    ImageView imageFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        // Spinner element
        VisaDetailsInput = (EditText) findViewById(R.id.VisaDetailsInput);
        VisaDetails = (TextView) findViewById(R.id.VisaDetails);

        tvName = (TextView)findViewById(R.id.tvName);
        tvNationality = (TextView)findViewById(R.id.tvNationality);
        tvType = (TextView)findViewById(R.id.tvType);
        tvPassportNo = (TextView)findViewById(R.id.tvPassportNo);
        tvGender = (TextView)findViewById(R.id.tvGender);
        tvDOB = (TextView)findViewById(R.id.tvDOB);
        tvMail = (TextView)findViewById(R.id.tvMail);
        tvAddress = (TextView)findViewById(R.id.tvAddress);
        tvPostcode = (TextView)findViewById(R.id.tvPostcode);
        tvCity = (TextView)findViewById(R.id.tvCity);
        tvCountry = (TextView)findViewById(R.id.tvCountry);
        tvPhoneNo = (TextView)findViewById(R.id.tvPhoneNo);
        tvEntry = (TextView)findViewById(R.id.tvEntry);
        tvExit = (TextView)findViewById(R.id.tvExit);
        tvStatus= (TextView)findViewById(R.id.tvStatus);
         imageFace = (ImageView)findViewById(R.id.imageFace);
        ImageView sample = (ImageView)findViewById(R.id.imagesample);

       // sample.setImageBitmap(mark( "For Demo Purposes"));
    }


    public static Bitmap mark(Bitmap src, String watermark) {
        int w = src.getWidth();
        int h = src.getHeight();
        Bitmap result = Bitmap.createBitmap(w, h, src.getConfig());
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(src, 0, 0, null);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(18);
        paint.setAntiAlias(true);
        paint.setUnderlineText(true);

        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
        canvas.drawText(watermark, 40, 60, paint);

        return result;
    }
    @Override
    public void onClick(View view) {
           // fromDatePickerDialog.show();
    }

    public void buttonOnClick (View view)
    {
        progress = ProgressDialog.show(Overview.this, "Waiting", "Sending", true);
        Query();
    }


    private void getImage() {

        progress.dismiss();
        //String imgUrl = "http://152.3.214.12:8080/arges-service/api/person/face-image/" + FaceID + "?app-id=test&app-key=test";
        String imgUrl = "http://www.gerbangrevolusi.com/mvisa/suppdoc/Supp_" + VisaDetailsInput.getText().toString()+".jpg";
        http://www.gerbangrevolusi.com/mvisa/suppdoc.php

        System.out.println("imgURL 1: " + imgUrl);
        Picasso.with(this).load(imgUrl).into(imageFace);
        // bio.disconnect();
        //aq.id(R.id.imageView).progress(R.id.imageView).image(imgUrl, true, true, 0, R.drawable.user);

    }


    public void Query()
    {
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, byidURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            progress.dismiss();
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
                                String Name = customer.getString("Name");
                                String Nationality = customer.getString("Nationality");
                                String VisaType = customer.getString("VisaType");
                                String PassportNo = customer.getString("PassportNo");
                                String Gender = customer.getString("Gender");
                                String DOB = customer.getString("DOB");
                                String Mail = customer.getString("Mail");
                                String add1 = customer.getString("add1");
                                String add2 = customer.getString("add2");
                                String add3 = customer.getString("add3");
                                String pCode = customer.getString("pCode");
                                String City = customer.getString("City");
                                String Country = customer.getString("Country");
                                String PhoneNo = customer.getString("PhoneNo");
                                String EntryDate = customer.getString("EntryDate");
                                String ExitDate = customer.getString("ExitDate");



                            /*    VisaDetails.setText("Name       : " + Name+"\n"+
                                                    "Nationality: " + Nationality+"\n"+
                                                    "VisaType   : " + VisaType+"\n"+
                                                    "PassportNo : " + PassportNo+"\n"+
                                                    "Gender     : " + Gender+"\n"+
                                                    "DOB        : " + DOB+"\n"+
                                                    "E-mail     : " + Mail+"\n"+
                                                    "Address    : " + add1+", " + add2+", "+ add3+"\n"+
                                                    "Post Code  : " + pCode+"\n"+
                                                    "City       : " + City+"\n"+
                                                    "Country    : " + Country+"\n"+
                                                    "PhoneNo    : " + PhoneNo+"\n"+
                                                    "EntryDate  : " + EntryDate+"\n" +
                                                    "ExitDate   : " + ExitDate+"\n"+
                                                    "\nStatus     : Approve");


*/
                                LinearLayout detail = (LinearLayout)findViewById(R.id.lineardetail);
                                detail.setVisibility(View.VISIBLE);

                                TextView congrats = (TextView) findViewById(R.id.tvCongrats);
                                congrats.setVisibility(View.VISIBLE);
                                        tvName.setText(": "+Name);
                                        tvNationality.setText(": "+Nationality);
                                        tvType.setText(": "+VisaType);
                                        tvPassportNo.setText(": "+PassportNo);
                                        tvGender.setText(": "+Gender);
                                        tvMail.setText(": "+Mail);
                                        tvDOB.setText(": "+DOB);
                                        tvAddress.setText(": "+ add1+", " + add2+", "+ add3);
                                        tvPostcode.setText(": "+pCode);
                                        tvCity.setText(": "+City);
                                        tvCountry.setText(": "+Country);
                                        tvPhoneNo.setText(": "+PhoneNo);
                                        tvEntry.setText(": "+EntryDate);
                                        tvExit.setText(": "+ExitDate);
                                        tvStatus.setText(": Approved");


                             //   Bitmap suppdoc = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/Supp_" + VisaDetailsInput.getText().toString() + ".jpg");
                                getImage();
                               // imageFace.setImageBitmap(suppdoc);
                            }
                        }
                        catch (JSONException ex)
                        {
                        }
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
                parameters.put("AccNo", VisaDetailsInput.getText().toString());
                return parameters;
            }

        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
