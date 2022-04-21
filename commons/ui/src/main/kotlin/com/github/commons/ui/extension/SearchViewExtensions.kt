package com.github.commons.ui.extension

import androidx.appcompat.widget.SearchView
import com.github.commons.ui.model.SearchItem
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalCoroutinesApi::class)
fun SearchView.changes(): StateFlow<SearchItem?> {
    val queryFlow = MutableStateFlow<SearchItem?>(null)
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            queryFlow.value = SearchItem(text = query, isSubmit = true)
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            queryFlow.value = SearchItem(text = newText)
            return true
        }
    })
    return queryFlow
}
