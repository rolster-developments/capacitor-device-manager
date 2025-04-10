package com.rolster.capacitor.device;

import android.content.Context;
import android.content.pm.PackageManager;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "DeviceManager")
public class DeviceManagerPlugin extends Plugin {
    private StoreVerifyServices storeVerifyServices;

    @Override
    public void load() {
        try {
            String storeVerifyServicesDef = BuildConfig.IS_HMS ?
                "com.rolster.capacitor.device.huawei.HuaweiVerifyServices" :
                "com.rolster.capacitor.device.google.GoogleVerifyServices";
            
            storeVerifyServices = (StoreVerifyServices) Class.forName(storeVerifyServicesDef)
                    .getConstructor(Context.class)
                    .newInstance(getContext());
        } catch (Exception e) {
            throw new RuntimeException("Error inicializando StoreVerifyServices", e);
        }
    }

    @PluginMethod
    public void requestInformation(PluginCall call) {
        JSObject result = new JSObject();

        result.put("compilationCode", String.valueOf(getCompilationCode()));
        result.put("versionCode", getVersionCode());
        
        boolean googleServices = hasGoogleServicesAvailable();
        boolean huaweiServices = hasHuaweiServicesAvailable();

        if (googleServices) {
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
        return storeVerifyServices.hasGoogle();
    }

    private boolean hasHuaweiServicesAvailable() {
        return storeVerifyServices.hasHuawei();
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
