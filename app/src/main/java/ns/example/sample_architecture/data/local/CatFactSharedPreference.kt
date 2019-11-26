package ns.example.sample_architecture.data.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import ns.example.sample_architecture.data.entity.CatFact

class CatFactSharedPreference(private val context: Context) {
    private val sharedPreferenceKey = "CatFact"
    private val sharedPreferenceCatFactKey = "AllCatFact"

    fun saveCatFact(catFact: CatFact) {
        val catFactJson = Gson().toJson(catFact)
        with(context.getSharedPreferences(sharedPreferenceKey, Context.MODE_PRIVATE).edit()) {
            putString(sharedPreferenceCatFactKey, catFactJson)
            apply()
        }
    }

    fun retrieveCatFact(): CatFact {
        val catFactJson =
                context.getSharedPreferences(
                    sharedPreferenceKey,
                        Context.MODE_PRIVATE).getString(sharedPreferenceCatFactKey, "")

        val catFact = Gson().fromJson(catFactJson, CatFact::class.java)
        return catFact
    }
}