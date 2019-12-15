package com.chhaichivon.pushnotification;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * @author Chhai Chivon on 12/16/2019
 * Mobile App Developer
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    public void  showNotification(String title, String message){
        NotificationCompat.Builder  builder = new NotificationCompat.Builder(this,"Notification")
                .setContentText(title)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(true)
                .setContentText(message);
        NotificationManagerCompat manager  = NotificationManagerCompat.from(this);
        manager.notify(999,builder.build());
    }
}
