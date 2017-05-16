package org.vtwo.MediaScannerPlugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import android.media.MediaScannerConnection;

import java.io.File;
import android.os.Environment;

/**
 * MediaScannerPlugin.java
 *
 * modified version of Peter Gao MediaScannerPlugin
 *
 * @author sara https://github.com/sarangan
 */
public class MediaScannerPlugin extends CordovaPlugin {
    public static final String ACTION = "scanFile";
    private static final String TAG = "MediaScannerPlugin";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals(ACTION)) {

                     try{
                            // hard code the folder name you can modify should be from javascript
                            File myDir = new File(Environment.getExternalStorageDirectory().toString() ,"APPFOLDER");

                            String fname = args.getString(0);

                            File file = new File ( myDir , fname);

                            Log.e("file===========path", ""+file);

                            if (file.exists ()){
                              Log.e(TAG, "file exits");
                            }
                            else{
                              Log.e(TAG, "file does not exits");
                            }


                            MediaScannerConnection.scanFile( this.cordova.getActivity(), new String[]{file.toString()}, null, new MediaScannerConnection.OnScanCompletedListener() {
                                public void onScanCompleted(String path, Uri uri) {
                                    //System.out.println("SCAN COMPLETED: " + path);
                                    Log.e(TAG , " Scanned " + path + " : " ) ;
                                }
                            });

                    }catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                        Log.e(TAG, "Something went wrong ");
                    }



            callbackContext.success();

            return true;
        } else {
            Log.e(TAG, "Wrong action was provided: "+action);
            return false;
        }
    }
}
