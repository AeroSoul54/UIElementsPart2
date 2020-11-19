package com.example.uielements2

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    lateinit var songsplaylist: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songsplaylist = arrayOf(
                "Pleasure and Pain", "Basement", "Falling Apart", "Resurrection",
                "Stardust", "VILLAIN", "MORE", "THE BADDEST", "DRUM GO DUM",
                "I'LL SHOW YOU", "The Vengeful One", "The Light", "Fire It Up",
                "The Sound of Silence", "Who Taught You How to Hate"
        )
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsplaylist)
        val songqueue = findViewById<ListView>(R.id.songqueue)
        songqueue.adapter = adapter

        registerForContextMenu(songqueue)
        songqueue.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->  }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.songs_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_to_queue -> {
                val selectedItemOrder = item!!.order
                val selectedItemTitle = item.title

                val info = item.menuInfo as AdapterContextMenuInfo
                val listPosition = info.position
                if(listPosition == 0) {
                    val songname = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname", songname)
                    editor.apply()
                }
                else if(listPosition == 1){
                    val songname2 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname2", songname2)
                    editor.apply()
                }
                else if(listPosition == 2){
                    val songname3 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname3", songname3)
                    editor.apply()
                }
                else if(listPosition == 3){
                    val songname4 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname4", songname4)
                    editor.apply()
                }
                else if(listPosition == 4){
                    val songname5 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname5", songname5)
                    editor.apply()
                }
                else if(listPosition == 5){
                    val songname6 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname6", songname6)
                    editor.apply()
                }
                else if(listPosition == 6){
                    val songname7 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname7", songname7)
                    editor.apply()
                }
                else if(listPosition == 7){
                    val songname8 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname8", songname8)
                    editor.apply()
                }
                else if(listPosition == 8){
                    val songname9 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname9", songname9)
                    editor.apply()
                }
                else if(listPosition == 9){
                    val songname10 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname10", songname10)
                    editor.apply()
                }
                else if(listPosition == 10){
                    val songname11 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname11", songname11)
                    editor.apply()
                }
                else if(listPosition == 11){
                    val songname12 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname12", songname12)
                    editor.apply()
                }
                else if(listPosition == 12){
                    val songname13 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname13", songname13)
                    editor.apply()
                }
                else if(listPosition == 13){
                    val songname14 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname14", songname14)
                    editor.apply()
                }
                else if(listPosition == 14){
                    val songname15 = songsplaylist[listPosition]
                    val preferences = getSharedPreferences("sharedPrefs", 0)
                    val editor = preferences.edit()
                    editor.putString("songname15", songname15)
                    editor.apply()
                }

                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.go_to_songs -> {
                true
            }
            R.id.go_to_albums -> {
                startActivity(Intent(this, AlbumActivity::class.java))
                true
            }
            R.id.go_to_queues -> {
                startActivity(Intent(this, QueueActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}