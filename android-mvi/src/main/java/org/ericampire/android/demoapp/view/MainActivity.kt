package org.ericampire.android.demoapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import org.ericampire.android.demoapp.R
import org.ericampire.android.demoapp.UserIntent
import org.ericampire.android.demoapp.UserState
import org.ericampire.android.demoapp.adapter.ItemAdapter
import org.ericampire.android.demoapp.app.arch.IView
import org.ericampire.android.demoapp.viewmodel.UserViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), IView<UserState> {

    private val mAdapter = ItemAdapter()
    private val mViewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = mAdapter

        // Observing the state
        mViewModel.state.observe(this, Observer {
            render(it)
        })

        // Fetching data when the application launched
        lifecycleScope.launch {
            mViewModel.intents.send(UserIntent.FetchUsers)
        }

        // Refresh data
        btnRefresh.setOnClickListener {
            lifecycleScope.launch {
                mViewModel.intents.send(UserIntent.RefreshUsers)
            }
        }
    }

    override fun render(state: UserState) {
        with(state) {
            progressBar.isVisible = isLoading
            btnRefresh.isEnabled = !isLoading
            mAdapter.submitList(users)

            if (errorMessage != null) {
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

