import { WebPlugin } from '@capacitor/core';
import {
  DeviceManagerPlugin,
  ServicesResult,
  HuaweiServicesResult,
  InformationResult
} from './definitions';

export class DeviceManagerWeb extends WebPlugin implements DeviceManagerPlugin {
  public requestInformation(): Promise<InformationResult> {
    return Promise.resolve({
      compilationCode: '1054',
      services: 'web',
      versionCode: '1.0.0'
    });
  }

  public hasGoogleServices(): Promise<ServicesResult> {
    return Promise.resolve({ availability: false });
  }

  public hasHuaweiServices(): Promise<HuaweiServicesResult> {
    return Promise.resolve({ availability: false });
  }

  public hasAppleServices(): Promise<HuaweiServicesResult> {
    return Promise.resolve({ availability: false });
  }
}
