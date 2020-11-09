package co.usam.plantix;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.xpkian.plantix.R;

import co.usam.plantix.backend.Backend;
import co.usam.plantix.constants.Utils;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static CShowProgress cShowProgress = CShowProgress.getInstance();
    //final String cacheFileName="temp.jpg";
    final String TEMP_DIRECTORY = "temp";
    Button scanBtn;
    Backend backend;
    File tempDir;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        backend = new Backend(MainActivity.this);
        tempDir = new File(Utils.getRootDirPath(MainActivity.this) + "/" + TEMP_DIRECTORY);


        //final File file= new File(this.getCacheDir(), "UploadImage");
        /*try {
            File.createTempFile(cacheFileName, null, this.getCacheDir());
            Log.d("clima e","e.getMessage()");
        } catch (IOException e) {
            Log.d("clima e",e.getMessage());
            e.printStackTrace();

        }*/

        //tempFile = new File(Utils.getRootDirPath(this),cacheFileName);
        //cacheFile.deleteOnExit();
        Log.d("clima e", "e.getMessage()" + getCacheDir());

        scanBtn = findViewById(R.id.scan_plant);

        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Your'e not authorized", Toast.LENGTH_SHORT).show();
//                ImagePicker.Companion.with(MainActivity.this)
//                        .crop()
//                        .galleryOnly()
//                        //.cropSquare()//Crop image(Optional), Check Customization for more option
//                        .compress(512) //// Final image size will be less than 1 MB(Optional)
//                        //.saveDir(Utils.getRootDirPath(MainActivity.this))
//                        .saveDir(tempDir)
//                        .maxResultSize(512, 512)    //Final image resolution will be less than 1080 x 1080(Optional)
//                        .start();


            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {

            if (data != null) {
                Uri imgUri = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imgUri);
                    cShowProgress.showProgress(MainActivity.this);
                    backend.identifyPlant(bitmap);
                    backend.getUsage();




                    /*runnable = new Runnable() {
                        @Override
                        public void run() {
                            Log.d("clima non idplant", String.valueOf(Backend.identificationRequestId));
                            while (Backend.identificationRequestId != 0) {
                                Log.d("clima idplant", String.valueOf(Backend.identificationRequestId));
                                backend.checkIdentification(Backend.identificationRequestId);
                            }
                        }
                    };
                    handler = new Handler();
                    handler.postDelayed(runnable, 3000);*/
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, "ImagePicker.getError(data)", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //TODO ENABLE LATER
        //Utils.deleteRecursive(tempDir);
    }
}
