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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.uielements2.models.Song
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var songsQueueArray: MutableList<Song>
    lateinit var songsTableHandler: DatabaseHelper
    lateinit var adapter: ArrayAdapter<Song>
    lateinit var songsQueueListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        songsQueueListView = findViewById<ListView>(R.id.songsQueueListView)

        songsTableHandler = DatabaseHelper(this)
        songsQueueArray = songsTableHandler.read()


        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, songsQueueArray)
        songsQueueListView.adapter = adapter

        registerForContextMenu(songsQueueListView)
        songsQueueListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->  }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.songs_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        val info = item.menuInfo as AdapterContextMenuInfo
        val listPosition = info.position

        return when (item.itemId) {
            R.id.add_to_queue -> {
                true
            }
            R.id.go_to_edit_songs -> {
                val song_id = songsQueueArray[listPosition].id

                val intent = Intent(applicationContext, SongFormEdit::class.java)
                intent.putExtra("song_id", song_id)

                startActivity(intent)
                true
            }
            R.id.go_to_delete_songs -> {
                val song = songsQueueArray[listPosition]
                if(songsTableHandler.delete(song)){
                    songsQueueArray.removeAt(listPosition)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(this,"Song deleted successfully", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Song deletion failed", Toast.LENGTH_SHORT).show()
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
            R.id.go_to_add_songs -> {
                startActivity(Intent(this, SongFormAdd::class.java))
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