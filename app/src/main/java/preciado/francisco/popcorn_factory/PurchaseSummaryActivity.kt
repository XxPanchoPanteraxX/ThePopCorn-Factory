package preciado.franncisco.popcorn_factory

import android.content.Intent
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_purchase_summary.*
import preciado.francisco.popcorn_factory.R

class PurchaseSummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_summary)

        val bundle=intent.extras
        var lstMovies = ArrayList<Media>()
        var movie : Media = Media()
        var indexMovie : Int = 0
        var selectedSeat : Int = 0

        if(bundle!=null){
            indexMovie=bundle.getInt("indexMovie")
            lstMovies=bundle.getParcelableArrayList("movies")!!
            selectedSeat=bundle.getInt("selectedSeat")
        }

        if(!lstMovies.isEmpty()){
            movie=lstMovies.get(indexMovie)
        }

        tvMovieName.setText("You will watch ${movie.title}")

        tvSeatNumber.setText(selectedSeat.toString())

        spPaymentMethod.adapter=ArrayAdapter(this, android.R.layout.simple_spinner_item, PaymentMethod.values())

        btnPurchase.setOnClickListener {
            var customer=Customer(etName.text.toString(),
                spPaymentMethod.selectedItem as PaymentMethod, selectedSeat)

            var seats : ArrayList<Customer>

            if(movie.seats.isEmpty()) seats= ArrayList() else seats=movie.seats as ArrayList

            seats.add(customer)

            movie.seats=seats
            lstMovies.set(indexMovie, movie)

            var intent = Intent(this, CatalogActivity::class.java)
            intent.putParcelableArrayListExtra("movies",lstMovies)

            startActivity(intent)

            finishAffinity()
        }
    }
}