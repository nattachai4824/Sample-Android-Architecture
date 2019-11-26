package ns.example.sample_architecture.presentation.fact_mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fact.*
import ns.example.sample_architecture.R
import ns.example.sample_architecture.data.entity.CatFact

class FactMvpActivity : AppCompatActivity(), FactView {

    private lateinit var mPresenter: FactPresenterView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fact)

        mPresenter = FactPresenterView()

        mPresenter.init(this)
        mPresenter.fetchCatFact(this, false)
    }

    override fun showFact(catFact: CatFact) {
        tvContent.text = catFact.all.toString()
    }

    override fun showLoadingFact() {
        srlContent.isRefreshing = true
    }

    override fun dismissLoadingFact() {
        srlContent.isRefreshing = false
    }
}