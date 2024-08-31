package com.rolster.capacitor.device;

import android.content.pm.PackageManager;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.google.android.gms.common.GoogleApiAvailability;
import com.huawei.hms.api.HuaweiApiAvailability;

@CapacitorPlugin(name = "DeviceManager")
public class DeviceManagerPlugin extends Plugin {
    @PluginMethod
    public void requestInformation(PluginCall call) {
        JSObject result = new JSObject();

        result.put("compilationCode", String.valueOf(getCompilationCode()));
        result.put("versionCode", getVersionCode());
        
        boolean googleServices = hasGoogleServicesAvailable();
        boolean huaweiServices = hasHuaweiServicesAvailable();

        if (googleServices && huaweiServices) {
            result.put("services", "google&huawei");
        } else if (googleServices) {
            result.put("services", "google");
        } else if (huaweiServices) {
            result.put("services", "huawei");
        } else {
            result.put("services", "none");
        }
        
        call.resolve(result);
    }
    
    @PluginMethod
    public void hasGoogleServices(PluginCall call) {
        JSObject result = new JSObject();
        result.put("availability", hasGoogleServicesAvailable());

        call.resolve(result);
    }
    
    @PluginMethod
    public void hasHuaweiServices(PluginCall call) {
        JSObject result = new JSObject();        
        result.put("availability", hasHuaweiServicesAvailable());
        
        call.resolve(result);
    }
    
    @PluginMethod
    public void hasAppleServices(PluginCall call) {
        JSObject result = new JSObject();        
        result.put("availability", false);
        
        call.resolve(result);
    }

    private boolean hasGoogleServicesAvailable() {
        GoogleApiAvailability services = GoogleApiAvailability.getInstance();
        int status = services.isGooglePlayServicesAvailable(getContext());
        
        return status == com.google.android.gms.common.ConnectionResult.SUCCESS;
    }

    private boolean hasHuaweiServicesAvailable() {
        HuaweiApiAvailability services = HuaweiApiAvailability.getInstance();
        int status = services.isHuaweiMobileServicesAvailable(getContext());
        
        return status == com.huawei.hms.api.ConnectionResult.SUCCESS;
    }
    
    private String getVersionCode()  {
        try {
            var packageManager = getContext().getPackageManager();
            var packageName = getContext().getPackageName();
            
            return packageManager.getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "0.0.0";
        }
    }
    
    private int getCompilationCode()  {
        try {
            var packageManager = getContext().getPackageManager();
            var packageName = getContext().getPackageName();
            
            return packageManager.getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }
}
