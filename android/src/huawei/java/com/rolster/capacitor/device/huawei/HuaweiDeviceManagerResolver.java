package com.rolster.capacitor.device.huawei;

import android.content.Context;

import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.rolster.capacitor.device.DeviceManagerResolver;

public class HuaweiDeviceManagerResolver implements DeviceManagerResolver {
    private final Context context;

    public HuaweiDeviceManagerResolver(Context context) {
        this.context = context;
    }

    @Override()
    public boolean hasGoogle() {
        return false;
    }

    @Override()
    public boolean hasHuawei() {
        HuaweiApiAvailability services = HuaweiApiAvailability.getInstance();
        int status = services.isHuaweiMobileServicesAvailable(this.context);
        
        return status == ConnectionResult.SUCCESS;
    }
}
