package com.daniel.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.daniel.myapplication.databinding.ActivityMainBinding
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSupportActionBar()?.setDisplayShowHomeEnabled(true);

        val adapterHewan = AdapterHewan()

        val list = ArrayList<Hewan>()
        list.add(Hewan(1,getString(R.string.ayam),getString(R.string.desc_ayam),R.drawable.ayam))
        list.add(Hewan(2,getString(R.string.babi),getString(R.string.desc_babi),R.drawable.babi))
        list.add(Hewan(3,getString(R.string.monyet),getString(R.string.desc_monyet),R.drawable.monyet))
        list.add(Hewan(4,getString(R.string.kuda),getString(R.string.desc_kuda),R.drawable.kuda))
        list.add(Hewan(5,getString(R.string.ikan),getString(R.string.desc_ikan),R.drawable.ikan))
        list.add(Hewan(6,getString(R.string.sapi),getString(R.string.desc_sapi),R.drawable.sapi))
        list.add(Hewan(7,getString(R.string.kucing),getString(R.string.desc_kucing),R.drawable.kucing))
        list.add(Hewan(8,getString(R.string.anjing),getString(R.string.desc_anjing),R.drawable.anjing))
        list.add(Hewan(9,getString(R.string.singa),getString(R.string.desc_singa),R.drawable.singa))
        list.add(Hewan(10,getString(R.string.jerapah),getString(R.string.desc_jerapah),R.drawable.jerapah))

        adapterHewan.setData(list)

        with(binding.rv){
            layoutManager = LinearLayoutManager(context,    LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = adapterHewan
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.profile) {
            startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}