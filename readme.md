# Rolster Capacitor DeviceManager

Plugin for device manager information in mobile Android, Huawei and iOS.

## Installation

Package only supports Capacitor 6

```
npm i @rolster/capacitor-device-manager
```

### Android configuration

And register the plugin by adding it to you MainActivity's onCreate:

```java
import com.rolster.capacitor.device.DeviceManagerPlugin;

public class MainActivity extends BridgeActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    registerPlugin(DeviceManagerPlugin.class);
    // Others register plugins

    super.onCreate(savedInstanceState);
  }
}
```
