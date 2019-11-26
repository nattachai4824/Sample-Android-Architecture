package ns.example.sample_architecture.presentation.fact_mvp

import ns.example.sample_architecture.data.entity.CatFact

interface FactView {
    fun showFact(catFact: CatFact)
    fun showLoadingFact()
    fun dismissLoadingFact()
}