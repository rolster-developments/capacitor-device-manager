import Foundation
import Capacitor

@objc(DeviceManagerPlugin)
public class DeviceManagerPlugin: CAPPlugin {
    @objc func requestInformation(_ call: CAPPluginCall) {
        call.resolve([
            "compilationCode": Bundle.main.buildVersionNumber ?? "0.0.1",
            "services": "apple",
            "versionCode": Bundle.main.releaseVersionNumber ?? "0.0.0"
        ])
    }

    @objc func hasGoogleServices(_ call: CAPPluginCall) {
        call.resolve([
            "availability": false
        ])
    }

    @objc func hasHuaweiServices(_ call: CAPPluginCall) {
        call.resolve([
            "availability": false
        ])
    }

    @objc func hasAppleServices(_ call: CAPPluginCall) {
        call.resolve([
            "availability": true
        ])
    }
}

extension Bundle {
    var releaseVersionNumber: String? {
        return infoDictionary?["CFBundleShortVersionString"] as? String
    }

    var buildVersionNumber: String? {
        return infoDictionary?["CFBundleVersion"] as? String
    }
}
