export type InformationServices =
  | 'apple'
  | 'google'
  | 'google&huawei'
  | 'huawei'
  | 'web';

export interface InformationResult {
  compilationCode: string;
  services: InformationServices;
  versionCode: string;
}

export interface ServicesResult {
  availability: boolean;
}

export interface HuaweiServicesResult {
  availability: boolean;
}

export interface DeviceManagerPlugin {
  requestInformation(): Promise<InformationResult>;

  hasGoogleServices(): Promise<ServicesResult>;

  hasHuaweiServices(): Promise<ServicesResult>;

  hasAppleServices(): Promise<ServicesResult>;
}
