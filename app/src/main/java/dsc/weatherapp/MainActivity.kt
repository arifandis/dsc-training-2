package dsc.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val recyclerView: RecyclerView = findViewById(R.id.weather_recycler_id)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)

        val weatherList = ArrayList<WeatherListModel.WeatherList>()

        weatherList.add(WeatherListModel.WeatherList("London, United Kingdom",R.mipmap.ic_cloudly,14))
        weatherList.add(WeatherListModel.WeatherList("Stockholm, Sweden",R.mipmap.ic_sunrise,8))
        weatherList.add(WeatherListModel.WeatherList("San Fransisco, United States",R.mipmap.ic_rain,19))

        val adapter = WeatherRecyclerAdapter(weatherList)
        recyclerView.adapter = adapter
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
            R.id.action_search ->{
                Toast.makeText(this,R.string.action_searchs,Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this,R.string.action_settings,Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_edit -> {
                Toast.makeText(this,R.string.action_edits,Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_delete -> {
                Toast.makeText(this,R.string.action_deletes,Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
