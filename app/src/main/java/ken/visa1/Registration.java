package ken.visa1;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;


public class Registration extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    //public static String URL = "http://103.21.34.216:81/mvisa/suppdoc.php";
    public static String URL = "http://www.gerbangrevolusi.com/mvisa/suppdoc.php";
    public static final String UPLOADIMAGE_URL = "http://aril.16mb.com/AndroidImageUpload/upload.php";
    private int year, month, day;
    //Uri to store the image uri
    private Uri filePath;
    protected final String TAG = getClass().getSimpleName();

    //MySQL
    String byidURL = "http://103.21.34.216:81/visa/insert.php";
    private String UPLOAD_URL ="http://103.21.34.216:81/visa/upload.php";
    private String KEY_IMAGE = "image";
    private String KEY_NAME = "name";

    private Bitmap bitmap;
    private Bitmap sendingimage;

    private static final String ServerAddress = "152.3.214.12:8080";
    private static final int CAMERA_REQUEST = 1888;
    //Item
    private EditText Name;
    private Spinner Visa;
    private Spinner Nationality;
    private EditText PassportNumber;
    private Spinner Gender;
    private EditText DOB;
    private EditText EntryDate;
    private EditText ExitDate;
    private EditText Mail;
    private EditText Address;
    private EditText Address2;
    private EditText Address3;
    private EditText Postcode;
    private EditText City;
    private Spinner Country;
    private EditText PhoneNumber;
    private ProgressDialog progress;
    private ImageView imageFace;
    private ImageView imagePass;
    private Bitmap mphoto;
    public String camera;
    public String dateselect;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog fromDatePickerDialog2;
    private DatePickerDialog fromDatePickerDialog3;
    private SimpleDateFormat dateFormatter;

    int No;
    String sendImage;
    File destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        camera = "0";
        // Spinner element
        Name = (EditText) findViewById(R.id.Name);
        Nationality = (Spinner) findViewById(R.id.spinner);
        Visa = (Spinner) findViewById(R.id.spinnerType);
        PassportNumber = (EditText) findViewById(R.id.Passport);
        Gender = (Spinner) findViewById(R.id.spinner2);
        DOB = (EditText) findViewById(R.id.DOB);
        DOB.setInputType(InputType.TYPE_NULL);
        DOB.requestFocus();
        EntryDate = (EditText) findViewById(R.id.EntryDate);
        EntryDate.setInputType(InputType.TYPE_NULL);
        EntryDate.requestFocus();
        ExitDate = (EditText) findViewById(R.id.ExitDate);
        ExitDate.setInputType(InputType.TYPE_NULL);
        ExitDate.requestFocus();
        Mail = (EditText) findViewById(R.id.Mail);
        Address = (EditText) findViewById(R.id.Address);
        Address2 = (EditText) findViewById(R.id.Address2);
        Address3 = (EditText) findViewById(R.id.Address3);
        Postcode = (EditText) findViewById(R.id.Postcode);
        City = (EditText) findViewById(R.id.City);
        Country = (Spinner) findViewById(R.id.spinner3);
        PhoneNumber = (EditText) findViewById(R.id.PhoneNum);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        imageFace = (ImageView)findViewById(R.id.imageFace);
        imagePass = (ImageView)findViewById(R.id.imagePass);
        //setDateTimeField();
        DateDOB();
        DateEntry();
        DateExit();

    }

    private void startCamera()
    {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1888 && resultCode == RESULT_OK) {
            mphoto = (Bitmap) data.getExtras().get("data");
            if (camera =="1") {

            if (mphoto != null) {
                mphoto.recycle();
            }
            mphoto = (Bitmap) data.getExtras().get("data");

                imageFace.setImageBitmap(mphoto);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
             // mphoto.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

                destination = new File(Environment.getExternalStorageDirectory(), "/Supp_" + PassportNumber.getText().toString() + ".jpg");
                FileOutputStream fo;
                try {
                    destination.createNewFile();
                    fo = new FileOutputStream(destination);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (camera =="2") {
                bitmap=mphoto;
                imagePass.setImageBitmap(mphoto);
            }
        }


    }

    public void imageClick(View view) {

        if (PassportNumber.getText().toString().isEmpty())
        {   Toast.makeText(Registration.this,"Please insert passport number", Toast.LENGTH_LONG).show();

        }
        else {
            camera = "1";
            startCamera();

        }

    }
    public void imageClick2(View view) {
        if (PassportNumber.getText().toString().isEmpty())
        {   Toast.makeText(Registration.this,"Please insert passport number", Toast.LENGTH_LONG).show();

        }

        else {
            camera = "2";
            startCamera();

        }
    }



    //passport and facial image
    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }


    private void uploadImage(){
        //Showing the progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Uploading...","Please wait...",false,false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Disimissing the progress dialog
                        loading.dismiss();
                        //Showing toast message of the response
                        Toast.makeText(Registration.this, "Response: "+s , Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog
                        loading.dismiss();

                        //Showing toast
                        //Toast.makeText(Registration.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Converting Bitmap to String
                String image = getStringImage(bitmap);

                //Getting Image Name
                String name = Name.getText().toString().trim();

                //Creating parameters
                Map<String,String> params = new Hashtable<String, String>();

                //Adding parameters
                params.put(KEY_IMAGE, image);
                params.put(KEY_NAME, name);
                System.out.println("image: "+image.length());
                System.out.println("name: "+name.length());
                //returning parameters
                return params;
            }
        };

        //Creating a Request Queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }



    public void DateDOB ()
    {DOB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fromDatePickerDialog.show();
        }
    });
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                DOB.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    public void DateEntry()
    {
        EntryDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDatePickerDialog2.show();
            }
        });

        Calendar newCalendar2 = Calendar.getInstance();
        fromDatePickerDialog2 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate2 = Calendar.getInstance();
                newDate2.set(year, monthOfYear, dayOfMonth);
                EntryDate.setText(dateFormatter.format(newDate2.getTime()));
            }

        },newCalendar2.get(Calendar.YEAR), newCalendar2.get(Calendar.MONTH), newCalendar2.get(Calendar.DAY_OF_MONTH));
    }

    public void DateExit()
    {
        ExitDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDatePickerDialog3.show();
            }
        });

        Calendar newCalendar3 = Calendar.getInstance();
        fromDatePickerDialog3 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate3 = Calendar.getInstance();
                newDate3.set(year, monthOfYear, dayOfMonth);
                ExitDate.setText(dateFormatter.format(newDate3.getTime()));
            }

        },newCalendar3.get(Calendar.YEAR), newCalendar3.get(Calendar.MONTH), newCalendar3.get(Calendar.DAY_OF_MONTH));
    }

    public void buttonOnClick (View view)
    {
         progress = ProgressDialog.show(Registration.this, "Waiting", "Sending", true);
         registerUser();
    /*  try {
          File destination2 = new File(Environment.getExternalStorageDirectory(), "/Supp_" + PassportNumber.getText().toString() + ".jpg");
          Toast.makeText(Registration.this,"Path: "+destination2.getPath().toString(), Toast.LENGTH_LONG).show();
          upload(destination2.getPath().toString());
      }
        catch (Exception e)
        {
            Toast.makeText(Registration.this, "Error"+e.toString(), Toast.LENGTH_LONG).show();
            System.out.println("Image error:"+e.toString());
        }*/
    }



    public void uploadMultipart() {
        //getting name for the image
        String name = Name.getText().toString().trim();

        //getting the actual path of the image

        Uri path1 = Uri.parse("android.resource://ken.visa1/" + R.drawable.page2);

        imageFace.setImageURI(path1);
        String imgPath = path1.toString();
        System.out.println("Path face:"+imgPath);


        //String path = getPath(filePath);

        //Uploading code
        try {
            String uploadId = UUID.randomUUID().toString();

            //Creating a multi part request
            new MultipartUploadRequest(this, uploadId, UPLOADIMAGE_URL)
                    .addFileToUpload(imgPath, "image") //Adding file
                    .addParameter("name", name) //Adding text parameter to the request
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setMaxRetries(2)
                    .startUpload(); //Starting the upload

        } catch (Exception exc) {
            Toast.makeText(this, exc.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



    //method to get the file path from uri
    public String getPath(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }



    private void upload(String path) {
        System.out.println("Path : " + path);
        Bitmap bm = BitmapFactory.decodeFile(path);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 50, bao);
        byte[] ba = bao.toByteArray();
        sendImage = Base64.encodeToString(ba, Base64.DEFAULT);

        // Upload image to server
        ImageUpload();

    }

    public void ImageUpload() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Log.w(TAG, "response: " + response);
                       // System.out.println("response: " + response);
                        Toast.makeText(Registration.this,"Please proceed with Payment", Toast.LENGTH_LONG).show();
                        Proceed();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error instanceof TimeoutError) {
                            System.out.println("Error : " + error.getMessage());
                            // Log.d(TAG, error.getMessage());
                        }
                        if (error instanceof NetworkError) {
                            Toast.makeText(getApplicationContext(), "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                        }
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();
                params.put("base64", sendImage);
                params.put("ImageName", "suppdoc/Supp_" + PassportNumber.getText().toString() +".jpg");

                return params;
            }

        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void Proceed()
    {
        Intent i = new Intent(this, Payment.class);
        i.putExtra("name", PassportNumber.getText().toString());
        startActivity(i);
        this.finish();
    }

    public void registerUser()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, byidURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.w(TAG, "response: " + response);
                        Toast.makeText(Registration.this, response , Toast.LENGTH_LONG).show();
                        progress.dismiss();
                        File destination2 = new File(Environment.getExternalStorageDirectory(), "/Supp_" + PassportNumber.getText().toString() + ".jpg");
                        //Toast.makeText(Registration.this,"Path: "+destination2.getPath().toString(), Toast.LENGTH_LONG).show();
                        upload(destination2.getPath().toString());


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
                            progress.dismiss();
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
                params.put("name",Name.getText().toString());
                params.put("nationality",Nationality.getSelectedItem().toString());
                params.put("visa",Visa.getSelectedItem().toString());
                params.put("passportno",PassportNumber.getText().toString());
                params.put("gender",Gender.getSelectedItem().toString());
                params.put("dob",DOB.getText().toString());
                params.put("mail",Mail.getText().toString());
                params.put("add",Address.getText().toString());
                params.put("add2",Address2.getText().toString());
                params.put("add3",Address3.getText().toString());
                params.put("postcode",Postcode.getText().toString());
                params.put("city",City.getText().toString());
                params.put("country",Country.getSelectedItem().toString());
                params.put("phone",PhoneNumber.getText().toString());
                params.put("entry",EntryDate.getText().toString());
                params.put("exit",ExitDate.getText().toString());


                return params;
            }
        };

        //stringRequest.setRetryPolicy(new DefaultRetryPolicy(7000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
