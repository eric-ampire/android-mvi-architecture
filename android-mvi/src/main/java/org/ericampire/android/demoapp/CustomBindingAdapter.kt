package org.ericampire.android.demoapp

import android.R
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("setSpinnerData")
fun Spinner.setData(data: List<String>) {
    val dataAdapter = ArrayAdapter(context, R.layout.simple_spinner_item, data)
    dataAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
    adapter = dataAdapter
}

@BindingAdapter("setRecyclerAdapter")
fun RecyclerView.setRecyclerAdapter(customAdapter: RecyclerView.Adapter<*>) {
    setHasFixedSize(true)
    adapter = customAdapter
}