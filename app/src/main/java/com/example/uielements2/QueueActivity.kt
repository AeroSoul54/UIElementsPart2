package com.example.uielements2

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog

    class QueueActivity : AppCompatActivity() {
        lateinit var notificationManager: NotificationManager
        lateinit var notificationChannel: NotificationChannel
        lateinit var builder: Notification.Builder
        private val channelId="com.example.uielements2"
        private val description="Notification"
        lateinit var songsQueueArray: MutableList<String>

        @RequiresApi(Build.VERSION_CODES.O)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_queue)

            notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val Intent = Intent(this, QueueActivity::class.java)
            val pendingIntent =
                    PendingIntent.getActivity(this, 0, Intent, PendingIntent.FLAG_UPDATE_CURRENT)

            var list: List<String>? = albumSongs

            if (list.orEmpty().isEmpty() && (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)) {
                notificationChannel =
                        NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.GREEN
                notificationChannel.enableVibration(false)
                notificationManager.createNotificationChannel(notificationChannel)

                builder = Notification.Builder(this, channelId)
                        .setContentTitle("UIElementsPart 2 Notification")
                        .setContentText("The Queue is Empty")
                        .setSmallIcon(R.drawable.ic_launcher_round)
                        .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher))
                        .setContentIntent(pendingIntent)

            } else {
                builder = Notification.Builder(this)
                        .setContentTitle("test")
                        .setContentText("Notification")
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.mipmap.ic_launcher))
                        .setContentIntent(pendingIntent)
            }
            notificationManager.notify(1234, builder.build())

            val adapter =
                    ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, albumSongs)
            val songsList = findViewById<ListView>(R.id.queue_songs)
            songsList.adapter = adapter
            registerForContextMenu(songsList)

        }
        override fun onCreateContextMenu(
                menu: ContextMenu?,
                v: View?,
                menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            super.onCreateContextMenu(menu, v, menuInfo)
            val inflater = menuInflater
            inflater.inflate(R.menu.queue_menu, menu)
        }

        override fun onContextItemSelected(item: MenuItem): Boolean {

            return when (item.itemId) {

                R.id.remove_from_queue -> {
                    val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
                    albumSongs.removeAt(info.position)
                    true
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                    Toast.makeText(getBaseContext(), "Song Removed", Toast.LENGTH_SHORT).show();
                    true
                }
                else -> super.onContextItemSelected(item)

            }
        }
    }