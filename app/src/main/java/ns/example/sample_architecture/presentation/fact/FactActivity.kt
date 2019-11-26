package ns.example.sample_architecture.presentation.fact

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fact.*
import ns.example.sample_architecture.R
import ns.example.sample_architecture.data.remote.CatFactApi

class FactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fact)

        fetchCatFacts()
    }

    private fun fetchCatFacts() {
        val catFactApi = CatFactApi()

        catFactApi.listCatFacts { catFact ->
            // Continue from callback(catFacts)

            tvContent.text = catFact.all.toString()
        }
    }

}