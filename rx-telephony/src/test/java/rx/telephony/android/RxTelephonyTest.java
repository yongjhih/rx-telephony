package rx.telephony.android;

import android.app.Application;

import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

import android.content.Intent;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import rx.observers.TestSubscriber;

import static android.telephony.TelephonyManager.ACTION_PHONE_STATE_CHANGED;
import static android.telephony.TelephonyManager.EXTRA_INCOMING_NUMBER;
import static android.telephony.TelephonyManager.EXTRA_STATE;
import static android.telephony.TelephonyManager.EXTRA_STATE_IDLE;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RxTelephonyTest {
    @Test
    public void phoneStateChanges() throws Exception {
        Application application = RuntimeEnvironment.application;

        TestSubscriber<Intent> o = new TestSubscriber<>();
        RxTelephony.phoneStateChanges(application).subscribe(o);
        o.assertValues();

        Intent intent1 = new Intent(ACTION_PHONE_STATE_CHANGED) //
                .putExtra(EXTRA_STATE, EXTRA_INCOMING_NUMBER)
                .putExtra(EXTRA_INCOMING_NUMBER, "123-456-7890");
        application.sendBroadcast(intent1);
        o.assertValues(intent1);

        Intent intent2 = new Intent(ACTION_PHONE_STATE_CHANGED).putExtra(EXTRA_STATE, EXTRA_STATE_IDLE);
        application.sendBroadcast(intent2);
        o.assertValues(intent1, intent2);
    }
}
