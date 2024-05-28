package com.example.jkt48

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvIdols: RecyclerView
    private val list = ArrayList<Idol>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.apply {
            title = getString(R.string.home_page)
        }

        rvIdols = findViewById(R.id.ls_idol)
        rvIdols.setHasFixedSize(true)

        list.addAll(getListIdols())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListIdols(): ArrayList<Idol> {
        val data_names = resources.getStringArray(R.array.data_names)
        val desc_jiko = resources.getStringArray(R.array.desc_jiko)
        val info = resources.getStringArray(R.array.info)
        val jiko = resources.getStringArray(R.array.jiko)
        val data_photos = resources.obtainTypedArray(R.array.data_photos)
        val listIdol = ArrayList<Idol>()

        for (i in data_names.indices) {
            val idol = Idol(data_names[i], desc_jiko[i], data_photos.getResourceId(i, -1), info[i], jiko[i])
            listIdol.add(idol)
        }

        return listIdol
    }

    private fun showRecyclerList() {
        rvIdols.layoutManager = LinearLayoutManager(this)
        val adapter = Idol_Info(list)
        rvIdols.adapter = adapter
    }
}