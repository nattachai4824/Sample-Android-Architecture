package ns.example.sample_architecture.data.remote

import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import ns.example.sample_architecture.data.entity.CatFact

class CatFactApi {
    fun listCatFacts(callback: (CatFact) -> Unit) {
        "https://cat-fact.herokuapp.com/facts"
            .httpGet()
            .responseString { request, response, result ->
                // Here is the code for continuing after the data have been retrieved

                if (response.statusCode == 200) {
                    val catFact = Gson().fromJson(result.component1() ?: "", CatFact::class.java)
                    callback(catFact)
                }
            }
    }
}