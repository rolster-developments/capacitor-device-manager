#import <Foundation/Foundation.h>
#import <Capacitor/Capacitor.h>

// Define the plugin using the CAP_PLUGIN Macro, and
// each method the plugin supports using the CAP_PLUGIN_METHOD macro.
CAP_PLUGIN(DeviceManagerPlugin, "DeviceManager",
  CAP_PLUGIN_METHOD(requestInformation, CAPPluginReturnPromise);
  CAP_PLUGIN_METHOD(hasGoogleServices, CAPPluginReturnPromise);
  CAP_PLUGIN_METHOD(hasHuaweiServices, CAPPluginReturnPromise);
  CAP_PLUGIN_METHOD(hasAppleServices, CAPPluginReturnPromise);
)
