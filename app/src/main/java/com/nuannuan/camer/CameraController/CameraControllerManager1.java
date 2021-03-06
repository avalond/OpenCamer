package com.nuannuan.camer.cameracontroller;

import android.hardware.Camera;
import com.nuannuan.camer.log.Logger;

/**
 * Provides support using Android's original camera API
 * android.hardware.Camera.
 * @author Mark Harman 18 June 2016
 * @author kevin
 */
@SuppressWarnings("deprecation") public class CameraControllerManager1
    extends CameraControllerManager {
  private static final String TAG = CameraControllerManager1.class.getSimpleName();

  public int getNumberOfCameras() {
    return Camera.getNumberOfCameras();
  }

  public boolean isFrontFacing(int cameraId) {
    try {
      Camera.CameraInfo camera_info = new Camera.CameraInfo();
      Camera.getCameraInfo(cameraId,camera_info);
      return (camera_info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT);
    } catch (RuntimeException e) {
      // Had a report of this crashing on Galaxy Nexus - may be device specific issue, see http://stackoverflow.com/questions/22383708/java-lang-runtimeexception-fail-to-get-camera-info
      // but good to catch it anyway

      Logger.d(TAG,"failed to set parameters");
      e.printStackTrace();
      return false;
    }
  }
}
