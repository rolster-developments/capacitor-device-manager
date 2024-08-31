import { registerPlugin } from '@capacitor/core';
import type { DeviceManagerPlugin } from './definitions';

const DeviceManager = registerPlugin<DeviceManagerPlugin>('DeviceManager', {
  web: () => import('./web').then((m) => new m.DeviceManagerWeb())
});

export * from './definitions';
export { DeviceManager };
