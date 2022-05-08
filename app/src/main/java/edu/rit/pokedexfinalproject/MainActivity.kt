package edu.rit.pokedexfinalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val viewModel: PokemonViewModel by inject()
    private val recyclerViewAdapter = PokemonRecyclerViewAdapter(ArrayList())
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        var navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_gen1 -> Toast.makeText(applicationContext, "Clicked Gen 1", Toast.LENGTH_SHORT).show()
                R.id.nav_gen2 -> Toast.makeText(applicationContext, "Clicked Gen 2", Toast.LENGTH_SHORT).show()
                R.id.nav_about -> Toast.makeText(applicationContext, "Clicked About", Toast.LENGTH_SHORT).show()
            }
            true
        }

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = recyclerViewAdapter

        observeFromViewModal()
        viewModel.fetchPokemon(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun observeFromViewModal() {
        viewModel.pokemons.observe(this, { pokemons ->
            recyclerViewAdapter.loadData(pokemons)
        })
    }
}