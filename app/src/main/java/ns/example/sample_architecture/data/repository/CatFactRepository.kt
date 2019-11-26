package ns.example.sample_architecture.data.repository

import android.content.Context
import ns.example.sample_architecture.data.entity.CatFact
import ns.example.sample_architecture.data.local.CatFactSharedPreference
import ns.example.sample_architecture.data.remote.CatFactApi

class CatFactRepository(private val context: Context) {
    fun fetchCatFact(isRemotePreferred: Boolean, callback: (CatFact) -> Unit) {
        if (isRemotePreferred) {
            requestCatFactApi(callback)
        } else {
            if (isCatFactExisted()) {
                val catFactSharedPreference = CatFactSharedPreference(context)
                val catFact = catFactSharedPreference.retrieveCatFact()

                callback(catFact)
            } else {
                requestCatFactApi(callback)
            }
        }
    }

    private fun requestCatFactApi(callback: (CatFact) -> Unit) {
        val catFactApi = CatFactApi()
        catFactApi.listCatFacts { catFact ->
            saveCatFact(catFact)
            callback(catFact)
        }
    }

    fun isCatFactExisted(): Boolean {
        val catFactJson =  context.getSharedPreferences(
                "CatFact",
                Context.MODE_PRIVATE).getString("AllCatFact", "")

        return catFactJson.isNotBlank()
    }

    fun saveCatFact(catFact: CatFact) {
        val catFactSharedPreference = CatFactSharedPreference(context)
        catFactSharedPreference.saveCatFact(catFact)
    }
}