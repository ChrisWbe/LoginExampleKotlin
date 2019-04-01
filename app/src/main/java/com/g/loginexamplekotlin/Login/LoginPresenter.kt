package com.g.loginexamplekotlin.Login

class LoginPresenter() : InterfaceLoginMVP.presenter {


    //Presentador gestiona

    private lateinit var view: InterfaceLoginMVP.view
    private lateinit var model: InterfaceLoginMVP.model

    constructor(view: InterfaceLoginMVP.view) : this() { //constructor secundario
        this.view = view
        model = LoginModel(this)
    }

    override fun loginButtonClicked() {
        var mail = view.getEmail()
        var pass = view.getPass()
        var tel = view.getTel()

        if(mail.equals(""))
            view.showEmailError()
        else
            if(pass.equals(""))
                view.showPassError()
            else
                if(tel.equals(""))
                    view.showTelError()
                else
                    model.sendData(mail,pass,tel)
    }

    override fun userLoginSuccesful() {
        view.showWelcomeMessage()
        view.goToMainActivity()
    }

    override fun userNoExist() {
        view.userNoexist()
    }


}