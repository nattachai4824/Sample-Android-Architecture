package ns.example.sample_architecture.presentation.fact_mvp

import android.content.Context

interface FactPresenter {
    fun fetchCatFact(context: Context,isRemotePreferred: Boolean)
}