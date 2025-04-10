package com.rolster.capacitor.device.huawei;

import android.content.Context;

import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.rolster.capacitor.device.StoreVerifyServices;

public class HuaweiVerifyServices implements StoreVerifyServices {
    private final Context context;

    public HuaweiVerifyServices(Context context) {
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
