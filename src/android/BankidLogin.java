package se.strativ.bankidlogin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * This class echoes a string called from JavaScript.
 */
public class BankidLogin extends CordovaPlugin {
    public static final String TAG = "Bankid Plugin";
    private CallbackContext callbackContext;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException, JSONException {
        if (action.equals("loginWithBankId")) {
            String auth_token = args.getString(0);
            this.openBankId(auth_token, callbackContext);
            return true;
        }
        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(this.callbackContext != null) {
            JSONObject result = new JSONObject();

            try {
                result.put("_ACTION_requestCode_", requestCode);
                result.put("_ACTION_resultCode_", resultCode);

                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    for (String key : bundle.keySet()) {
                        result.put(key, bundle.get(key));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, result);
            pluginResult.setKeepCallback(true);

            this.callbackContext.sendPluginResult(pluginResult);
        }
    }
    private void openBankId(String auth_token, CallbackContext callback) {
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
        pluginResult.setKeepCallback(true);
        this.callbackContext = callback;

        if (auth_token != null && auth_token.length() > 0) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://app.bankid.com/?autostarttoken="+auth_token+"&redirect=null ")) ;
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // startActivity(intent);
            cordova.getActivity().startActivity(intent);

            callback.sendPluginResult(pluginResult);

        } else {
            callback.error("Invalid token.");
        }
    }

}