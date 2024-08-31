package com.avaldigitallabs.mbocc.device;

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
  public void getInformation(PluginCall call) {
    JSObject result = new JSObject();

    result.put("compilationCode", getCompilationCode());

    if (isHuaweiAvailable()) {
      result.put("platform", "huawei");
    } else {
      result.put("platform", "android");
    }

    call.resolve(result);
  }

  @PluginMethod
  public void hasGoogleServices(PluginCall call) {
    JSObject result = new JSObject();

    int status = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getContext());
    result.put("availability", status == com.google.android.gms.common.ConnectionResult.SUCCESS);

    call.resolve(result);
  }

  @PluginMethod
  public void hasHuaweiServices(PluginCall call) {
    JSObject result = new JSObject();

    result.put("availability", isHuaweiAvailable());

    call.resolve(result);
  }

  private boolean isHuaweiAvailable() {
    int status = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(getContext());
    return status == com.huawei.hms.api.ConnectionResult.SUCCESS;
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
