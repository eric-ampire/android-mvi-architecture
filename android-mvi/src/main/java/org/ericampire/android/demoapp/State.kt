package org.ericampire.android.demoapp

import org.ericampire.android.demoapp.architecture.ViewState

data class State(
    val isLoadingCategories: Boolean,
    val isLoadingFact: Boolean,
    val isSpinnerEnabled: Boolean,
    val facts: List<Fact>,
    val categories: List<String>,
    val isKickButtonEnabled: Boolean,
    val isClearButtonEnabled: Boolean
) : ViewState