package dsc.weatherapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class WeatherRecyclerAdapter(val weatherList: ArrayList<WeatherListModel.WeatherList>): RecyclerView.Adapter<WeatherRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(weatherList[position])
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v){
        fun bindView(data: WeatherListModel.WeatherList){
            val cityName: TextView = itemView.findViewById(R.id.city_name_id)
            val imageWeather: ImageView = itemView.findViewById(R.id.weather_img_id)
            val suhu: TextView = itemView.findViewById(R.id.derajat_id)

            cityName.text = data.mNameCity
            imageWeather.setImageResource(data.mImage)
            suhu.text = ""+data.mSuhu+"°"
        }
    }
}