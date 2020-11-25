package com.example.uielements2

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.util.Log
import android.widget.*

class AlbumDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        var albumItems: AlbumItem = intent.getSerializableExtra("data") as AlbumItem
        var viewImage = findViewById<ImageView>(R.id.icon_details)
        var viewText = findViewById<TextView>(R.id.icon_name)

        if (albumItems.icons == R.drawable.disturbed) {
            viewImage.setImageResource(albumItems.icons!!)

            val songsQueueArray = arrayOf("The Vengeful One", "The Light", "Fire It Up",
                    "The Sound of Silence", "Who Taught You How to Hate")
            val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsQueueArray)
            val albumSongs = findViewById<ListView>(R.id.album_songs)
            albumSongs.adapter = adapter

            albumSongs.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                val dialogAlert = AlertDialog.Builder(this)
                dialogAlert.setMessage("Do you want to remove this song from list?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", DialogInterface.OnClickListener() { dialog, which ->
                            val removeSong = songsQueueArray[position]
                            songsQueueArray.remove(removeSong)
                            adapter.notifyDataSetChanged()

                        })
                        .setNegativeButton("No", DialogInterface.OnClickListener {
                            dialog, which ->
                            dialog.cancel()
                        })
                val alert = dialogAlert.create()
                alert.setTitle("Alert! Deleting Song")
                alert.show()
            }// item listener

        } else if (albumItems.icons == R.drawable.kda) {
            viewImage.setImageResource(albumItems.icons!!)
            viewText.text = "ALL OUT"

            val songsQueueArray = arrayOf("VILLAIN", "MORE", "THE BADDEST", "DRUM GO DUM",
                    "I'LL SHOW YOU")
            val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsQueueArray)
            val albumSongs = findViewById<ListView>(R.id.album_songs)
            albumSongs.adapter = adapter

            albumSongs.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                val dialogAlert = AlertDialog.Builder(this)
                dialogAlert.setMessage("Do you want to remove this song from list?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", DialogInterface.OnClickListener() { dialog, which ->
                            val removeSong = songsQueueArray[position]
                            songsQueueArray.remove(removeSong)
                            adapter.notifyDataSetChanged()

                        })
                        .setNegativeButton("No", DialogInterface.OnClickListener {
                            dialog, which ->
                            dialog.cancel()
                        })
                val alert = dialogAlert.create()
                alert.setTitle("Alert! Deleting Song")
                alert.show()
            }// item listener

        } else if (albumItems.icons == R.drawable.lux) {
            viewImage.setImageResource(albumItems.icons!!)
            viewText.text = "Lux"

            val songsQueueArray = arrayOf("Pleasure and Pain", "Basement", "Falling Apart", "Resurrection",
                    "Stardust")
            val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsQueueArray)
            val albumSongs = findViewById<ListView>(R.id.album_songs)
            albumSongs.adapter = adapter

            albumSongs.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                val dialogAlert = AlertDialog.Builder(this)
                dialogAlert.setMessage("Do you want to remove this song from list?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", DialogInterface.OnClickListener() { dialog, which ->
                            val removeSong = songsQueueArray[position]
                            songsQueueArray.remove(removeSong)
                            adapter.notifyDataSetChanged()

                        })
                        .setNegativeButton("No", DialogInterface.OnClickListener {
                            dialog, which ->
                            dialog.cancel()
                        })
                val alert = dialogAlert.create()
                alert.setTitle("Alert! Deleting Song")
                alert.show()
            }// item listener
        }
    }
}
