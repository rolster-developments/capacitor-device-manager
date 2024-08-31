export type InformationPlatform = 'web' | 'android' | 'huawei' | 'ios';

export interface InformationResult {
  compilationCode: string;
  platform: InformationPlatform;
}

export interface GoogleServicesResult {
  availability: boolean;
}

export interface HuaweiServicesResult {
  availability: boolean;
}

export interface DeviceManagerPlugin {
  getInformation(): Promise<InformationResult>;

  hasGoogleServices(): Promise<GoogleServicesResult>;

  hasHuaweiServices(): Promise<HuaweiServicesResult>;
}
