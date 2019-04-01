package com.g.loginexamplekotlin.Login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.g.loginexamplekotlin.Main.MainActivity
import com.g.loginexamplekotlin.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), InterfaceLoginMVP.view {



    //var-> para variables, val-> para constantes

    private lateinit var presenter: InterfaceLoginMVP.presenter

    //private lateinit var nombre:String, para variables que no se vana  inicializar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter=LoginPresenter(this)

        button.setOnClickListener{
            presenter.loginButtonClicked()
        }
    }
    override fun getEmail(): String {
        return eEmail.text.toString()
    }
    override fun getPass(): String = ePass.text.toString() //otra catacteristica de Kotlin, si hay una sola linea return, se puede omitir esta misma
    override fun getTel(): String  = eTelefono.text.toString()

    override fun showEmailError() {
        eEmail.error="Debe digitar un correo Electrónico."
    }

    override fun showPassError() {
        ePass.error="Debe digitar una Contraseña."
    }

    override fun showTelError() {
        eTelefono.error="Debe digitar un Teléfono."
    }

    override fun showWelcomeMessage() {
        Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show()
    }

    override fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun userNoexist() {
        Toast.makeText(this, "Creando usuario",Toast.LENGTH_LONG).show()
    }


}
