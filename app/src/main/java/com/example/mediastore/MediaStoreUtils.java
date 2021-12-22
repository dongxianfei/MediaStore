package com.example.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;

import androidx.annotation.RequiresApi;

/*
 * 导出media数据库
 * adb pull /data/data/com.android.providers.media.module/databases
*/

public class MediaStoreUtils {
    private static String TAG = "MediaStoreUtils";
    private Context mContext;
    private ContentResolver mResolver;

    public MediaStoreUtils(Context context) {
        mContext = context;
        mResolver = mContext.getContentResolver();
    }

    public void getImageMedia() {
        Cursor c = null;
        //Uri uri1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        //Uri uri2 = MediaStore.Images.Media.getContentUri("external");
        //Uri uri3 = Uri.parse("content://media/external/images/media");
        c = mResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, null, null, null);

        if (c != null) {
            Log.i(TAG, "c.getColumnCount() = " + c.getColumnCount());
            String[] ColumnNames = c.getColumnNames();
            int ColumnNum = ColumnNames.length;
            for (int i = 0; i < ColumnNum; i++) {
                Log.i(TAG, "getColumnNames_" + i + " = " + ColumnNames[i]);
            }

            Log.i(TAG, "c.getCount() = " + c.getCount());
            int indexPhotoPath = c.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            Log.i(TAG, "indexPhotoPath = " + indexPhotoPath);
            while (c.moveToNext()) {
                Log.i(TAG, "indexPhotoPath = " + c.getString(indexPhotoPath));
            }

            int indexPhotoTitle = c.getColumnIndexOrThrow(MediaStore.Images.Media.TITLE);
            Log.i(TAG, "indexPhotoTitle = " + indexPhotoTitle);
            c.moveToPosition(-1);
            while (c.moveToNext()) {
                Log.i(TAG, "indexPhotoTitle = " + c.getString(indexPhotoTitle));
            }

            int indexPhotoDateTaken = c.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_TAKEN);
            Log.i(TAG, "indexPhotoDateTaken = " + indexPhotoDateTaken);
            c.moveToPosition(-1);
            while (c.moveToNext()) {
                Log.i(TAG, "indexPhotoDateTaken = " + c.getString(indexPhotoDateTaken));
            }

            int indexPhotoISO = c.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.ISO);
            Log.i(TAG, "indexPhotoISO = " + indexPhotoISO);
            c.moveToPosition(-1);
            while (c.moveToNext()) {
                Log.i(TAG, "indexPhotoISO = " + c.getString(indexPhotoISO));
            }
        }
        c.close();
    }

    public void getVideoMedia() {
        Cursor c = null;
        //Uri uri1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        //Uri uri2 = MediaStore.Video.Media.getContentUri("external");
        //Uri uri3 = Uri.parse("content://media/external/video/media");
        c = mResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                null, null, null, null);

        if (c != null) {
            Log.i(TAG, "c.getColumnCount() = " + c.getColumnCount());
            String[] ColumnNames = c.getColumnNames();
            int ColumnNum = ColumnNames.length;
            for (int i = 0; i < ColumnNum; i++) {
                Log.i(TAG, "getColumnNames_" + i + " = " + ColumnNames[i]);
            }

            Log.i(TAG, "c.getCount() = " + c.getCount());
            int indexVideoPath = c.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            Log.i(TAG, "indexVideoPath = " + indexVideoPath);
            while (c.moveToNext()) {
                Log.i(TAG, "indexVideoPath = " + c.getString(indexVideoPath));
            }

            int indexVideoTitle = c.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE);
            Log.i(TAG, "indexVideoTitle = " + indexVideoTitle);
            c.moveToPosition(-1);
            while (c.moveToNext()) {
                Log.i(TAG, "indexVideoTitle = " + c.getString(indexVideoTitle));
            }

            int indexVideoDisplayName = c.getColumnIndexOrThrow(MediaStore.Video.VideoColumns.DISPLAY_NAME);
            Log.i(TAG, "indexVideoDisplayName = " + indexVideoDisplayName);
            c.moveToPosition(-1);
            while (c.moveToNext()) {
                Log.i(TAG, "indexVideoDisplayName = " + c.getString(indexVideoDisplayName));
            }
        }
        c.close();
    }

    public void getFileMedia() {
        Cursor c = null;
        //Uri uri1 = MediaStore.Files.getContentUri("external");
        //Uri uri2 = Uri.parse("content://media/external/files");
        c = mResolver.query(MediaStore.Files.getContentUri("external"),
                null, null, null, null);

        if (c != null) {
            Log.i(TAG, "c.getColumnCount() = " + c.getColumnCount());
            String[] ColumnNames = c.getColumnNames();
            int ColumnNum = ColumnNames.length;
            for (int i = 0; i < ColumnNum; i++) {
                Log.i(TAG, "getColumnNames_" + i + " = " + ColumnNames[i]);
            }

            Log.i(TAG, "c.getCount() = " + c.getCount());
            int indexFilePath = c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA);
            Log.i(TAG, "indexFilePath = " + indexFilePath);
            while (c.moveToNext()) {
                Log.i(TAG, "indexFilePath = " + c.getString(indexFilePath));
            }

            int indexFileDisplayName = c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DISPLAY_NAME);
            Log.i(TAG, "indexFileDisplayName = " + indexFileDisplayName);
            c.moveToPosition(-1);
            while (c.moveToNext()) {
                Log.i(TAG, "indexFileDisplayName = " + c.getString(indexFileDisplayName));
            }
        }
        c.close();
    }

    public void getAudioMedia() {
        Cursor c = null;
        //Uri uri1 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        //Uri uri2 = MediaStore.Audio.Media.getContentUri("external");
        //Uri uri3 = Uri.parse("content://media/external/audio/media");
        c = mResolver.query(Uri.parse("content://media/external/audio/media"),
                null, null, null, null);

        if (c != null) {
            Log.i(TAG, "c.getColumnCount() = " + c.getColumnCount());
            String[] ColumnNames = c.getColumnNames();
            int ColumnNum = ColumnNames.length;
            for (int i = 0; i < ColumnNum; i++) {
                Log.i(TAG, "getColumnNames_" + i + " = " + ColumnNames[i]);
            }

            Log.i(TAG, "c.getCount() = " + c.getCount());
            int indexAudioPath = c.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
            Log.i(TAG, "indexAudioPath = " + indexAudioPath);
            while (c.moveToNext()) {
                Log.i(TAG, "indexAudioPath = " + c.getString(indexAudioPath));
            }

            int indexAudioDisplayName = c.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME);
            Log.i(TAG, "indexAudioDisplayName = " + indexAudioDisplayName);
            c.moveToPosition(-1);
            while (c.moveToNext()) {
                Log.i(TAG, "indexAudioDisplayName = " + c.getString(indexAudioDisplayName));
            }
        }
        c.close();
    }


    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void getDownloadMedia() {
        Cursor c = null;
        //Uri uri1 = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
        //Uri uri2 = MediaStore.Downloads.getContentUri("external");
        c = mResolver.query(MediaStore.Downloads.getContentUri("external"),
                null, null, null, null);

        if (c != null) {
            Log.i(TAG, "c.getColumnCount() = " + c.getColumnCount());
            String[] ColumnNames = c.getColumnNames();
            int ColumnNum = ColumnNames.length;
            for (int i = 0; i < ColumnNum; i++) {
                Log.i(TAG, "getColumnNames_" + i + " = " + ColumnNames[i]);
            }

            Log.i(TAG, "c.getCount() = " + c.getCount());
            int indexDownPath = c.getColumnIndexOrThrow(MediaStore.Downloads.DATA);
            Log.i(TAG, "indexDownPath = " + indexDownPath);
            while (c.moveToNext()) {
                Log.i(TAG, "indexDownPath = " + c.getString(indexDownPath));
            }

            int indexDownOwner = c.getColumnIndexOrThrow(MediaStore.Downloads.DURATION);
            Log.i(TAG, "indexDownOwner = " + indexDownOwner);
            c.moveToPosition(-1);
            while (c.moveToNext()) {
                Log.i(TAG, "indexDownOwner = " + c.getString(indexDownOwner));
            }
        }
        c.close();
    }

    public void getImageFromFile() {
        Cursor c = null;
        //Uri uri1 = MediaStore.Files.getContentUri("external");
        //Uri uri2 = Uri.parse("content://media/external/files");
        c = mResolver.query(MediaStore.Files.getContentUri("external"),
                new String[]{MediaStore.Files.FileColumns.DATA, MediaStore.Files.FileColumns.DISPLAY_NAME},
                MediaStore.Files.FileColumns.MIME_TYPE + " = ? ",
                new String[]{"image/jpeg"}, null);

        if (c != null) {
            Log.i(TAG, "c.getCount() = " + c.getCount());
            int indexFilePath = c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA);
            Log.i(TAG, "indexFilePath = " + indexFilePath);
            while (c.moveToNext()) {
                Log.i(TAG, "indexFilePath = " + c.getString(indexFilePath));
            }
        }
        c.close();
    }

    public void getVideoFromFile() {
        Cursor c = null;
        //Uri uri1 = MediaStore.Files.getContentUri("external");
        //Uri uri2 = Uri.parse("content://media/external/files");
        c = mResolver.query(MediaStore.Files.getContentUri("external"),
                new String[]{MediaStore.Files.FileColumns.DATA, MediaStore.Files.FileColumns.DISPLAY_NAME},
                MediaStore.Files.FileColumns.MIME_TYPE + " = ? ",
                new String[]{"video/mp4"}, null);

        if (c != null) {
            Log.i(TAG, "c.getCount() = " + c.getCount());
            int indexFilePath = c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA);
            Log.i(TAG, "indexFilePath = " + indexFilePath);
            while (c.moveToNext()) {
                Log.i(TAG, "indexFilePath = " + c.getString(indexFilePath));
            }
        }
        c.close();
    }

    public void getAudioFromFile() {
        Cursor c = null;
        //Uri uri1 = MediaStore.Files.getContentUri("external");
        //Uri uri2 = Uri.parse("content://media/external/files");
        c = mResolver.query(MediaStore.Files.getContentUri("external"),
                new String[]{MediaStore.Files.FileColumns.DATA, MediaStore.Files.FileColumns.DISPLAY_NAME},
                MediaStore.Files.FileColumns.MIME_TYPE + " = ? ",
                new String[]{"audio/mp4"}, null);

        if (c != null) {
            Log.i(TAG, "c.getCount() = " + c.getCount());
            int indexFilePath = c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA);
            Log.i(TAG, "indexFilePath = " + indexFilePath);
            while (c.moveToNext()) {
                Log.i(TAG, "indexFilePath = " + c.getString(indexFilePath));
            }
        }
        c.close();
    }
}
