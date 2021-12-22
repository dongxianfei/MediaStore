package com.example.mediastore;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "MainActivity";
    private Button mMediaStore_Image_Btn;
    private Button mMediaStore_Video_Btn;
    private Button mMediaStore_File_Btn;
    private Button mMediaStore_Audio_Btn;
    private Button mMediaStore_Down_Btn;
    private Button Image_From_File_Btn;
    private Button Video_From_File_Btn;
    private Button Audio_From_File_Btn;
    private MediaStoreUtils mMediaStoreUtil;

    private String[] permissions = new String[]{Permission.MANAGE_EXTERNAL_STORAGE,
            Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPermission();

        mMediaStore_Image_Btn = findViewById(R.id.mediastore_image);
        mMediaStore_Image_Btn.setOnClickListener(this);

        mMediaStore_Video_Btn = findViewById(R.id.mediastore_video);
        mMediaStore_Video_Btn.setOnClickListener(this);

        mMediaStore_File_Btn = findViewById(R.id.mediastore_files);
        mMediaStore_File_Btn.setOnClickListener(this);

        mMediaStore_Audio_Btn = findViewById(R.id.mediastore_audio);
        mMediaStore_Audio_Btn.setOnClickListener(this);

        mMediaStore_Down_Btn = findViewById(R.id.mediastore_download);
        mMediaStore_Down_Btn.setOnClickListener(this);

        Image_From_File_Btn = findViewById(R.id.mediastore_image_from_file);
        Image_From_File_Btn.setOnClickListener(this);

        Video_From_File_Btn = findViewById(R.id.mediastore_video_from_file);
        Video_From_File_Btn.setOnClickListener(this);

        Audio_From_File_Btn = findViewById(R.id.mediastore_audio_from_file);
        Audio_From_File_Btn.setOnClickListener(this);

        mMediaStoreUtil = new MediaStoreUtils(this);
    }

    private void getPermission() {
        if (XXPermissions.hasPermission(this, Permission.MANAGE_EXTERNAL_STORAGE)) {
            Log.i(TAG, "XXPermissions.hasPermission");
        } else {
            XXPermissions.with(this).permission(Permission.MANAGE_EXTERNAL_STORAGE).request(new OnPermission() {
                @Override
                public void hasPermission(List<String> granted, boolean all) {
                    if (all) {
                        Log.i(TAG, "XXPermissions.all Permission");
                    } else {
                        Log.i(TAG, "XXPermissions.part Permission");
                    }
                }

                @Override
                public void noPermission(List<String> denied, boolean never) {
                    if (never) {
                        Log.i(TAG, "XXPermissions.never Permission");
                    } else {
                        Log.i(TAG, "XXPermissions.fail Permission");
                    }
                    XXPermissions.startPermissionActivity(MainActivity.this, denied);
                }
            });
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mediastore_image:
                mMediaStoreUtil.getImageMedia();
                break;
            case R.id.mediastore_video:
                mMediaStoreUtil.getVideoMedia();
                break;
            case R.id.mediastore_files:
                mMediaStoreUtil.getFileMedia();
                break;
            case R.id.mediastore_audio:
                mMediaStoreUtil.getAudioMedia();
                break;
            case R.id.mediastore_download:
                mMediaStoreUtil.getDownloadMedia();
                break;
            case R.id.mediastore_image_from_file:
                mMediaStoreUtil.getImageFromFile();
                break;
            case R.id.mediastore_video_from_file:
                mMediaStoreUtil.getVideoFromFile();
                break;
            case R.id.mediastore_audio_from_file:
                mMediaStoreUtil.getAudioFromFile();
                break;
        }
    }
}