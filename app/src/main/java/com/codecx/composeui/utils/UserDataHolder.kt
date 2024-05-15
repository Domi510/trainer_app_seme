package com.codecx.composeui.utils

import com.codecx.composeui.models.User
/**
 * Objekt, ktorý si uchováva informácie o aktuálnom prihlásenom
 * */
object UserDataHolder {
    var user: User? = null
        get() {
            return if (field == null) {
                User("Ivan Kácerík - Zilina", "holder@gmail.com", "+1423590807")
            } else
                field
        }

}