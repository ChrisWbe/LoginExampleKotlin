package com.g.loginexamplekotlin.Login

import com.g.loginexamplekotlin.User

interface InterfaceLoginMVP {

    interface view {
        fun getEmail(): String
        fun getPass(): String
        fun getTel(): String
        fun showEmailError()
        fun showPassError()
        fun showTelError()
        fun showWelcomeMessage()
        fun goToMainActivity()
        fun userNoexist()

    }
    interface presenter {
        fun loginButtonClicked()
        fun userLoginSuccesful()
        fun userNoExist()


    }

    interface model {
        fun sendData(mail: String, pass: String, tel: String)
        fun userLoginSuccessful()
        fun userNoExist(pass:String)
        fun userCreate()
    }

}