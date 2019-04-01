package com.g.loginexamplekotlin.Login

import com.g.loginexamplekotlin.User
import com.google.firebase.auth.FirebaseAuth
import android.util.Log
import com.google.firebase.database.FirebaseDatabase


class LoginRepository : InterfaceLoginRepository {



    private var model: InterfaceLoginMVP.model
    private var mAuth: FirebaseAuth? = null

    constructor(model: InterfaceLoginMVP.model) {
        this.model = model
    }

    override fun authentication(user: User, pass: String) {
        mAuth = FirebaseAuth.getInstance()
        mAuth!!.signInWithEmailAndPassword(user.mail, pass)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    model.userLoginSuccessful()
                } else {
                    if(it.exception.toString().equals("com.google.firebase.auth.FirebaseAuthInvalidUserException: There is no user record corresponding to this identifier. The user may have been deleted.")){
                        model.userNoExist(pass)
                    }
                    Log.d("Error", it.exception.toString())
                }
            }

    }

    override fun createUser(user: User, pass: String) {
        mAuth = FirebaseAuth.getInstance()
        mAuth!!.createUserWithEmailAndPassword(user.mail, pass).addOnCompleteListener {
            if(it.isSuccessful){
                model.userCreate()
            }else{

            }
        }

    }

    override fun createUserDataBase(user: User) {
        val uid = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")
        ref.setValue(user).addOnCompleteListener {
            if(it.isSuccessful){
                model.userLoginSuccessful()
            }
        }
    }


}