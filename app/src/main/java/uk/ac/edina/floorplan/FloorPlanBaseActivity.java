package uk.ac.edina.floorplan;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;

/**
 * Created by murrayking on 07/08/2015.
 */
public abstract class FloorPlanBaseActivity extends Activity {

    protected FloorPlanApplication floorPlanApplication;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        floorPlanApplication = (FloorPlanApplication) this.getApplicationContext();
    }

    protected void onResume() {
        super.onResume();
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.enable();
        }
        floorPlanApplication.setCurrentActivity(this);
    }

    protected void onPause() {
        clearReferences();
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter.isEnabled()) {
            //bluetoothAdapter.disable();
        }
        super.onPause();
    }

    protected void onDestroy() {
        clearReferences();
        super.onDestroy();
    }

    private void clearReferences() {
        Activity currActivity = floorPlanApplication.getCurrentActivity();
        if (currActivity != null && currActivity.equals(this))
            floorPlanApplication.setCurrentActivity(null);
    }

    public abstract boolean acceptBeaconNotifications();


    public abstract boolean removeNavigationHistory();
}