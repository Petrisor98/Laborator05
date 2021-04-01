package ro.pub.cs.systems.eim.lab05.boundedserviceactivity.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

import ro.pub.cs.systems.eim.lab05.boundedserviceactivity.general.Constants;

public class BoundedService extends Service {

    final private IBinder boundedServiceBinder = new BoundedServiceBinder();
    final private Random random = new Random();

    // TODO: exercise 10a - implement a IBinder public class to provide a reference
    // to the service instance through a getService() public method
    public class BoundedServiceBinder extends Binder {
        public BoundedService getService() {
            return BoundedService.this;
        }
    }

    // TODO: exercise 10f - override the lifecycle callback method and log a message
    // of the moment they are invoked
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constants.TAG, "onCreate() method was invoked");
    }

    @Override
    // TODO: exercise 10a
    public IBinder onBind(Intent intent) {
        Log.d(Constants.TAG, "onBind() method was invoked");
        return boundedServiceBinder;
    }

    // TODO 10f
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(Constants.TAG, "onUnbind() method was invoked");
        return super.onUnbind(intent);
    }

    // TODO 10f
    @Override
    public void onRebind(Intent intent) {
        Log.d(Constants.TAG, "onRebind() method was invoked");
        super.onRebind(intent);
    }

    public String getMessage() {
        // TODO: exercise 10b - return a random value from the Constants.MESSAGES array list
        String msg = null;
        int idx = random.nextInt(Constants.MESSAGES.size());
        msg = Constants.MESSAGES.get(idx);
        return msg;
    }

    // TODO 10f
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Constants.TAG, "onDestroy() method was invoked");
    }
}
