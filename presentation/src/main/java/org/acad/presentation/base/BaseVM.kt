package org.acad.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject


/**
 * Created by Acad Bek on 7/30/2025
 */

abstract class BaseVM<State : Any, Event : Any, Effect : Any> : ViewModel() {
    private val stateSubject = BehaviorSubject.createDefault(this.getDefaultState())
    val state: Observable<State>
        get() = stateSubject
            .distinctUntilChanged()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())

    abstract fun getDefaultState() : State

    fun updateState(update: (current: State) -> State) {
        val state = update(stateSubject.blockingFirst())
        stateSubject.onNext(state)
    }

    abstract fun processEvent(event: Event)

    private val effectSubject = PublishSubject.create<Effect>()
    val effects: Observable<Effect> get() = effectSubject

    fun emmitEffect(effect: Effect) {effectSubject.onNext(effect)}
}