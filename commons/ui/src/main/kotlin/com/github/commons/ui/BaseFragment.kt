package com.github.commons.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.commons.di.ViewModelFactory
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseFragment<VM : ViewModel, Binding : ViewDataBinding>(
    private val clazz: KClass<VM>
) : Fragment(), FragmentType<VM, Binding> {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    override val viewModel by lazy { ViewModelProvider(this, viewModelFactory).get(clazz.java) }
    override lateinit var binding: Binding

    abstract fun initDI()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        initDI()
        setupView()
        return binding.root
    }
}