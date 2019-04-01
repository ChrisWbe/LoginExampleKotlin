package com.g.loginexamplekotlin.Login

import com.g.loginexamplekotlin.User


class LoginModel : InterfaceLoginMVP.model {


    //Modelo se encarga del almacenamiento

    private var presenter: InterfaceLoginMVP.presenter
    private var repository: InterfaceLoginRepository
    private lateinit var user: User


    constructor(presenter: InterfaceLoginMVP.presenter) {
        this.presenter = presenter
        repository = LoginRepository(this)
    }

    override fun sendData(mail: String, pass: String, tel: String) {
        //obtener los datos, crear objeto y enviar los datos a firebase (enviar objeto a repositorio)
        user = User(mail, tel)
        repository.authentication(user, pass)

    }

    override fun userLoginSuccessful() {
        presenter.userLoginSuccesful()

    }

    override fun userNoExist(pass:String) {
        repository.createUser(user, pass)
        presenter.userNoExist()
    }

    override fun userCreate() {
        repository.createUserDataBase(user)
    }



}
