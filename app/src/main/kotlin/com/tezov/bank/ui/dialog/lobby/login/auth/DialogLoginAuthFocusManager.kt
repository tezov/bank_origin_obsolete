/*
 *  *********************************************************************************
 *  Created by Tezov on 31/01/2023 20:43
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 31/01/2023 20:41
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.lobby.login.auth

import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//todo modifier lenght control par une validation login / password au niveau du state comme le credential valid

@OptIn(ExperimentalComposeUiApi::class)
class DialogLoginAuthFocusManager(private val login: State<String>, private val password: State<String>){

    var keyboardController: SoftwareKeyboardController? = null
    lateinit var coroutine: CoroutineScope
    lateinit var focusManager: FocusManager
    lateinit var focusOwner: MutableState<FocusRequester?>
    lateinit var focusLogin: FocusRequester
    lateinit var focusPassword: FocusRequester

    @Composable
    fun compose() {
        coroutine = rememberCoroutineScope()
        keyboardController = LocalSoftwareKeyboardController.current
        focusManager = LocalFocusManager.current
        focusLogin = remember {
            FocusRequester()
        }
        focusPassword = remember {
            FocusRequester()
        }
        focusOwner = remember {
            mutableStateOf(null)
        }
    }

    fun showKeyBoard(){
        coroutine.launch {
            delay(150)
            keyboardController?.show()
        }
    }

    fun hideKeyBoard(){
        keyboardController?.hide()
    }

    fun requestClearFocus(){
        focusOwner.value = null
        focusManager.clearFocus(true)
        hideKeyBoard()
    }

    //START - Login
    fun requestLoginFocus(){
        if(focusOwner.value != focusLogin){
            focusLogin.requestFocus()
        }
    }

    fun isLoginHasFocus() = focusOwner.value == focusLogin

    fun onLoginFocus(){
        focusOwner.value = focusLogin
        showKeyBoard()
    }

    fun onLoginChange() {
        if (login.value.length >= DialogLoginAuthState.LOGIN_LENGTH) {
            if (password.value.length < DialogLoginAuthState.PASSWORD_LENGTH) {
                focusPassword.requestFocus()
            } else {
                requestClearFocus()
            }
        }
    }
    //END - Login

    //START - Password
    fun requestPasswordFocus(){
        if(focusOwner.value != focusPassword){
            focusPassword.requestFocus()
        }
    }

    fun isPasswordHasFocus() = focusOwner.value == focusPassword

    fun onPasswordFocus() {
        focusOwner.value = focusPassword
        hideKeyBoard()
    }

    fun onPasswordChange() {
        if(password.value.length < DialogLoginAuthState.PASSWORD_LENGTH){
            requestPasswordFocus()
        }
        else if (login.value.length < DialogLoginAuthState.LOGIN_LENGTH) {
            focusLogin.requestFocus()
        } else {
            requestClearFocus()
        }
    }
    //END - Password


}