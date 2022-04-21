package com.github.commons.ui

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

interface FragmentType<VM : ViewModel, Binding : ViewDataBinding> {

    val binding: Binding
    val viewModel: VM
    val layoutResId: Int

    fun setupView()
}
