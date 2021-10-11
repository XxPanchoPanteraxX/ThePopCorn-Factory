package preciado.francisco.popcorn_factory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val bundle=intent.extras

        if (bundle!=null){
            movie_header.setImageResource(bundle.getInt("header"))
            movie_title_detail.setText(bundle.getString("titulo"))
            movie_summary.setText(bundle.getString("sinopsis"))
        }
    }
}