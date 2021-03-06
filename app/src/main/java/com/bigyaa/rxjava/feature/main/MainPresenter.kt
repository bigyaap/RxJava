package com.bigyaa.rxjava.feature.main

import com.bigyaa.rxjava.feature.Interactor
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

class MainPresenter(var view: MainView) : MvpBasePresenter<MainView>() {

    var mainInteractor = Interactor()

    fun zip() {
        val r = mainInteractor.getZipResults(this)
    }


}