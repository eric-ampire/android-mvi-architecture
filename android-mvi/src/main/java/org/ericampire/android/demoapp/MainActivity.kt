package org.ericampire.android.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import org.ericampire.android.demoapp.adapter.ItemAdapter
import org.ericampire.android.demoapp.architecture.UserIntent
import org.ericampire.android.demoapp.architecture.ViewRender
import org.ericampire.android.demoapp.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(),
    ViewRender<State> {

    private val viewModel by viewModel<FactViewModel>()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val recyclerAdapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.recyclerView.setRecyclerAdapter(recyclerAdapter)

        viewModel.state.observe(this, Observer {
            render(it)
        })

        binding.btnClear.setOnClickListener {
            //viewModel.dispatchIntent(UserIntent.ClearFact)
        }

        binding.btnKick.setOnClickListener {
            viewModel.dispatchIntent(UserIntent.ShowNewFact(
                //binding.spinner.selectedItem as String
            ))
        }
    }

    override fun render(state: State) {
        with(state) {
            // Todo: Submit the state to the view
            binding.progressBar.isVisible = isLoadingFact
            binding.progressBarCategory.isVisible = isLoadingCategories
            binding.btnKick.isEnabled = isKickButtonEnabled
            binding.btnClear.isEnabled = isKickButtonEnabled
            binding.spinner.setData(categories)
            binding.spinner.isEnabled = isSpinnerEnabled
            recyclerAdapter.submitList(facts)
        }
    }
}