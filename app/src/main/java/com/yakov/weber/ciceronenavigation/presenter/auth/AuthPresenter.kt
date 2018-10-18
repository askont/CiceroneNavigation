package com.yakov.weber.ciceronenavigation.presenter.auth

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.yakov.weber.ciceronenavigation.R
import com.yakov.weber.ciceronenavigation.model.flow.FlowRouter
import com.yakov.weber.ciceronenavigation.toothpick.system.ResManager
import com.yakov.weber.ciceronenavigation.ui.Screens
import javax.inject.Inject
import kotlin.math.log

/**
 * Created on 18.10.18
 * @author YWeber
 * project CiceroneNavigation */

@InjectViewState
class AuthPresenter @Inject constructor(private val router: FlowRouter,
                                        private val resourceManager: ResManager) : MvpPresenter<AuthView>() {

    fun nextFlow(){
        router.navigateTo(Screens.Auth)
    }

    fun connectMock(login:String,password:String){
        when {
            password.isBlank() -> viewState.showError(resourceManager.getString(R.string.password_incorrect))
            login.isEmpty() -> viewState.showError(resourceManager.getString(R.string.login_incorrect))
            else -> viewState.showError("Hello $login")
        }
    }

    fun onBackPressed() = router.exit()
}