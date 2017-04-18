/*
 * Copyright (C) 2017, Andrew Chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rx2.telephony.android;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.telephony.TelephonyManager;

import io.reactivex.Observable;
import io.reactivex.annotations.CheckReturnValue;
import rx2.receiver.android.RxReceiver;

import static android.Manifest.permission.READ_PHONE_STATE;

public final class RxTelephony {
    private RxTelephony() {
        throw new AssertionError("no instances");
    }

    /**
     * Usage:
     * <pre>
     * String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
     * String phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
     * </pre>
     *
     * TODO Move PhoneState telephony-models module
     *
     * @param context
     * @return
     */
    @CheckReturnValue
    @NonNull
    @RequiresPermission(READ_PHONE_STATE)
    public static Observable<Intent> phoneStateChanges(@NonNull final Context context) {
        return RxReceiver.receives(context,
                new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED));
    }
}
