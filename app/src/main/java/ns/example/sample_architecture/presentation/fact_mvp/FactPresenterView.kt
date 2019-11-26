package ns.example.sample_architecture.presentation.fact_mvp

import android.content.Context
import ns.example.sample_architecture.data.repository.CatFactRepository

class FactPresenterView : FactPresenter {

    private lateinit var mView: FactView

    fun init(view: FactView) {
        mView = view
    }

    override fun fetchCatFact(context: Context, isRemotePreferred: Boolean) {
        mView.showLoadingFact()
        val catFactRepository = CatFactRepository(context)

        catFactRepository.fetchCatFact(isRemotePreferred) { catFact ->
            mView.dismissLoadingFact()
            mView.showFact(catFact)
        }
    }
}