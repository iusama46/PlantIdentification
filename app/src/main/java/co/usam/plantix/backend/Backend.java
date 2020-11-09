package co.usam.plantix.backend;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import co.usam.plantix.MainActivity;
import co.usam.plantix.models.Example;
import co.usam.plantix.models.Plant;
import co.usam.plantix.models.Suggestion;
import co.usam.plantix.models.UsageDetail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Backend {
    private static final String SERVER_URL = ""; //SERVER URL;
    private static final String API_KEY = "" ; //KEY
    public static List<Plant> plantList = new ArrayList<>();
    public static int identificationRequestId;
    @SuppressLint("StaticFieldLeak")
    private static MainActivity mainActivity;
    private final RequestQueue queue;
    private Context context;

    public Backend(MainActivity mainActivity) {
        Backend.mainActivity = mainActivity;
        context = mainActivity;
        queue = Volley.newRequestQueue(context);
        identificationRequestId = 0;
    }

    /* get base64 image data from bitmap */
    private static String getStringImage(Bitmap bitmap) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
        byte[] imageBytes = bos.toByteArray();

        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    /* call identification API endpoint */
    public void identifyPlant(final Bitmap imgBitmap) {
        String url = SERVER_URL + "/identify";
        final StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //Log.d("clima identification", response.toString());
                            getPlantsList(response);
                            JSONObject json = new JSONObject(new JSONTokener(response));
                            Log.d("clima id", String.valueOf(json.getInt("id")));
                            identificationRequestId = json.getInt("id");
                        } catch (JSONException error) {
                            error.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Upload failed", Toast.LENGTH_SHORT).show();
                        Log.e("clima  backedResponse", new String(error.networkResponse.data, StandardCharsets.UTF_8));
                    }
                }
        ) {
            /* define POST parameters */
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                JSONObject data = new JSONObject();
                JSONArray images = new JSONArray();
                images.put(getStringImage(imgBitmap));

                try {
                    data.put("key", API_KEY);
                    data.put("images", images);
                    data.put("wait_for_identification", 15);
                    //data.put("parameters",parameters);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                params.put("data", data.toString());
                return params;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(30 * 1000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }

    private void getPlantsList(String response) {
        plantList.clear();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        // ArrayList list = new ArrayList();
        Example example = gson.fromJson(response, Example.class);

        for (Suggestion predictedValue : example.getSuggestions()) {

            String commonName = (String) predictedValue.getPlantInfo().getCommonName();

            if (commonName == null)
                commonName = "none";

            Plant plant = new Plant(
                    String.valueOf(predictedValue.getId()),
                    predictedValue.getPlantInfo().getName(),
                    //(String) predictedValue.getPlantInfo().getCommonName(),
                    commonName,
                    predictedValue.getConfidence(),
                    predictedValue.getProbability(),
                    predictedValue.getPlantInfo().getUrl()
            );
            plantList.add(plant);
            Log.d("clima" + plant.getName(), String.valueOf(plant.getConfidence()));
        }
        /*example.getSuggestions().get(0).getPlantInfo().getName();
        example.getSuggestions().get(0).getPlantInfo().getCommonName();
        example.getSuggestions().get(0).getPlantInfo().getUrl();
        example.getSuggestions().get(0).getId();
        example.getSuggestions().get(0).getConfidence();
        example.getSuggestions().get(0).getProbability();*/

        StringBuilder str = new StringBuilder();
        for (Plant plant : plantList) {
            Log.d("clima2" + plant.getName(), String.valueOf(plant.getConfidence()));
            str.append(plant.getName());
            str.append(" ");
            str.append(plant.getConfidence());
            str.append("\n");
        }


        // Bundle args = new Bundle();
        //args.putSerializable("plant_list",(Serializable)plantList);
        //intent.putExtra("BUNDLE",args);
        //DecimalFormat df = new DecimalFormat("#.00").format(value);
        MainActivity.cShowProgress.hideProgress();
        final AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
        builder.setTitle("Contact Us");
        builder.setMessage(str);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.show();

    }

    /* check whether identification is completed and retrieve results */
    public void checkIdentification(final int id) {
        String url = SERVER_URL + "/check_identifications";
        StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("clima  check2", response);
                        try {
                            getPlantsList(response);
                        } catch (Exception e) {
                            Toast.makeText(context, "error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                JSONObject data = new JSONObject();
                JSONArray ids = new JSONArray();
                ids.put(id);
                try {
                    data.put("key", API_KEY);
                    data.put("ids", ids);
                } catch (JSONException error) {
                    error.printStackTrace();
                }
                params.put("data", data.toString());
                return params;
            }
        };
        queue.add(request);
    }

    public void getUsage() {
        String url = SERVER_URL + "/usage_info";
        StringRequest request = new StringRequest(com.android.volley.Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("clima identification", response);
                        Gson gson = new GsonBuilder().create();
                        UsageDetail detail = gson.fromJson(response, UsageDetail.class);
                        if (detail.getRemainingTotal() != null) {
                            Toast.makeText(context, "Remaining " + detail.getRemainingTotal(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(context, "Upload failed", Toast.LENGTH_SHORT).show();
                        Log.d("clima", "Data update failed");
                        Log.e("clima  backedResponse", new String(error.networkResponse.data, StandardCharsets.UTF_8));
                    }
                }
        ) {
            /* define POST parameters */
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                JSONObject data = new JSONObject();

                try {
                    data.put("key", API_KEY);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                params.put("data", data.toString());
                return params;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(30 * 1000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }
}
