package com.github.commons.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.commons.di.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseFragment<VM : ViewModel, Binding : ViewDataBinding>(
    private val clazz: KClass<VM>
) : Fragment(), BaseFragmentType<VM, Binding> {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    override val viewModel by lazy { ViewModelProvider(this, viewModelFactory).get(clazz.java) }
    override lateinit var binding: Binding

    private val job = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + job)

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

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

    fun requireCompatActivity(): AppCompatActivity {
        val activity = requireActivity()
        return if (activity is AppCompatActivity)
            activity
        else
            throw TypeCastException("Main activity should extend from 'AppCompatActivity'")
    }
}
