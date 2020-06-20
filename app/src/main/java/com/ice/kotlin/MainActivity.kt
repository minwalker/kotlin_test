package com.ice.kotlin

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.Observable
import io.reactivex.Observer

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initRecycleView()


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }

    fun initRecycleView() {

        recycle_list.adapter = CustomerAdapter(this@MainActivity)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycle_list.layoutManager = linearLayoutManager
        val itemData = mutableListOf<ItemData>()
        var data:ItemData? = null
        for(i in 0..10) {
            Log.i("logtest", "position: $i")
            data = ItemData("position: $i", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587894816526&di=02553d2c2255a09f1c27b164d108106b&imgtype=0&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1656629194%2C3980400682%26fm%3D214%26gp%3D0.jpg")
            itemData.add(data)
        }
        (recycle_list.adapter as CustomerAdapter).setListData(itemData)
        (recycle_list.adapter as CustomerAdapter).notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun execRetrofit() {
    }
}
