package com.codecx.composeui.models

import com.google.firebase.database.Exclude

data class User constructor(   val name: String="",
                               val email: String="",
                               val phone: String="") {

    @Exclude
    @set:Exclude
    @get:Exclude
    var password: String = ""

}