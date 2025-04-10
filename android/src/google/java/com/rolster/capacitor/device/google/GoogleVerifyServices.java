package com.rolster.capacitor.device.google;

import android.content.Context;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.rolster.capacitor.device.StoreVerifyServices;

public class GoogleVerifyServices implements StoreVerifyServices {
    private final Context context;

    public GoogleVerifyServices(Context context) {
        this.context = context;
    }

    @Override()
    public boolean hasGoogle() {
        GoogleApiAvailability services = GoogleApiAvailability.getInstance();
        int status = services.isGooglePlayServicesAvailable(this.context);
        
        return status == ConnectionResult.SUCCESS;
    }

    @Override()
    public boolean hasHuawei() {
        return false;
    }
}
