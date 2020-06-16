package org.ericampire.android.demoapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.ericampire.android.demoapp.adapter.ItemAdapter
import org.ericampire.android.demoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}

class HomeFragment : BaseMvRxFragment(R.layout.fragment_home) {

    private val viewModel: FactViewModel by fragmentViewModel()
    private val recyclerAdapter = ItemAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.recyclerView.adapter = recyclerAdapter
    }


    override fun invalidate() = withState(viewModel) {
        recyclerAdapter.submitList(it.users.invoke())
    }
}

