package com.example.muhammad_usman.redirectmessage;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by Muhammad_Usman on 4/28/2016.
 */
public class MyService  extends Service {
    String userID;
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       userID = intent.getStringExtra("Phone");
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.provider.Telephony.SMS_RECEIVED");
        filter.addAction(android.telephony.TelephonyManager.ACTION_PHONE_STATE_CHANGED);
        registerReceiver(receiver, filter);
        Toast.makeText(this, "Message Redirect Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
        Toast.makeText(this, "Message Redirect Destroyed", Toast.LENGTH_LONG).show();
    }
    private final BroadcastReceiver receiver;

    {
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle bundle = intent.getExtras();
                SmsMessage smsMessage;
                try {
                    if ( bundle != null) {
                        if (Build.VERSION.SDK_INT >= 19 )
                        {
                            SmsMessage[] msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
                            smsMessage = msgs[0];
                        }
                        else
                        {
                            Object[] objPdus = (Object[]) bundle.get("pdus");
                            smsMessage =SmsMessage.createFromPdu((byte[])objPdus[0]);
                        }
                        String phoneNumber = 		smsMessage.getDisplayOriginatingAddress();
                        String message = 	smsMessage.getMessageBody();
                        String sms="SenderNum: \n " + phoneNumber + "; message: \n "+message;
                        MainActivity d=new MainActivity();
                        send(sms);
                        Toast.makeText(context, 	"Redirected " , Toast.LENGTH_LONG).show();
                    } }catch (Exception e) { e.printStackTrace();
                } }

        };
    }
    public void send(String msg)
    {
        SmsManager sm=SmsManager.getDefault();

        sm.sendTextMessage(userID,null,msg,null,null);

    }
}
