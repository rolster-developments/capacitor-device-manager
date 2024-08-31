import { registerPlugin } from '@capacitor/core';
import type { DeviceManagerPlugin } from './definitions';

const DeviceManager = registerPlugin<DeviceManagerPlugin>('DeviceManager', {
  web: () =>
    import('./web').then(({ DeviceManagerWeb }) => new DeviceManagerWeb())
});

export * from './definitions';
export { DeviceManager };
