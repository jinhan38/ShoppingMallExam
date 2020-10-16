package com.shoppingmallexam.ui.base

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.shoppingmallexam.data.ShoppingRepository


class ParentViewModel @ViewModelInject constructor(
    private val repository : ShoppingRepository,
    @Assisted state : SavedStateHandle
) : ViewModel(){

    private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)

    val result = currentQuery.switchMap { queryString ->
        repository.getResult(queryString).cachedIn(viewModelScope)
    }


    companion object {
        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = "남자"
    }
}
