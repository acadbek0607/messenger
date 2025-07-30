package org.acad.presentation.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Acad Bek on 7/30/2025
 */

abstract class BaseFragment<VB: ViewBinding> (
    private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {
    protected var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    @SuppressLint("CheckResult")
    fun <T: Any, R: Any> Observable<T>.observe(observer: (R) -> Unit, mapper: (T) -> R) {
        map(mapper).distinctUntilChanged().doOnNext(observer)
    }
}