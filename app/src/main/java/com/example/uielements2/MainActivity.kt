package com.example.uielements2

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import android.content.Intent as Intent1


class MainActivity : AppCompatActivity() {
//    lateinit var songsArray: Array<String>

    private val songsArray = arrayOf("Pleasure and Pain", "Basement", "Falling Apart", "Resurrection",
            "Stardust", "VILLAIN", "MORE", "THE BADDEST", "DRUM GO DUM",
            "I'LL SHOW YOU", "The Vengeful One", "The Light", "Fire It Up",
            "The Sound of Silence", "Who Taught You How to Hate")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
        val songsQueueListView = findViewById<ListView>(R.id.songsQueueListView)
        songsQueueListView.adapter = adapter

        registerForContextMenu(songsQueueListView)
//        songsQueueListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->  }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.songs_menu, menu)
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

                startActivity(Intent1(this, AlbumActivity::class.java))
                true
            }
            R.id.go_to_queues -> {

                startActivity(Intent1(this, QueueActivity::class.java))
                true

            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {

        return when(item.itemId) {

            R.id.add_to_queue -> {
                val info = item.menuInfo as AdapterContextMenuInfo
                albumSongs.add(songsArray[info.position])
                true
                val snackbar :Snackbar = Snackbar.make(this.findViewById(R.id.songsQueueListView),
                "Navigate to Queue",Snackbar.LENGTH_LONG)
                snackbar.setAction("Go",View.OnClickListener {
                startActivity(Intent1(this, QueueActivity::class.java))
                })
                snackbar.show()
                true
            }

            else-> super.onContextItemSelected(item)

        }
    }

}
val albumSongs = arrayListOf<String>()