package com.example.uielementspart2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        // use arrayadapter and define an array
        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf(
            "Pleasure and Pain","Basement", "Falling Apart", "Resurrection", "Stardust",
        "VILLAIN","MORE","THE BADDEST","DRUM GO DUM","I'LL SHOW YOU"
        )

        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.lvSongs)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, users)
        mListView.adapter = arrayAdapter
    }
}