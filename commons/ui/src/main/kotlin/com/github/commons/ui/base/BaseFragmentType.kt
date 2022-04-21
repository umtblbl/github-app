package com.github.commons.ui.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

interface BaseFragmentType<VM : ViewModel, Binding : ViewDataBinding> {

    val binding: Binding
    val viewModel: VM
    val layoutResId: Int

    fun setupView()
}
