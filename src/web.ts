import { WebPlugin } from '@capacitor/core';
import {
  DeviceManagerPlugin,
  GoogleServicesResult,
  HuaweiServicesResult,
  InformationResult
} from './definitions';

export class DeviceManagerWeb extends WebPlugin implements DeviceManagerPlugin {
  public getInformation(): Promise<InformationResult> {
    return Promise.resolve({ compilationCode: '1054', platform: 'web' });
  }

  public hasGoogleServices(): Promise<GoogleServicesResult> {
    return Promise.resolve({ availability: false });
  }

  public hasHuaweiServices(): Promise<HuaweiServicesResult> {
    return Promise.resolve({ availability: false });
  }
}
