package com.codecx.composeui.utils

import com.codecx.composeui.models.User

object UserDataHolder {
    var user: User? = null
        get() {
            return if (field == null) {
                User("Ivan Kácerík - Zilina", "holder@gmail.com", "+1423590807")
            } else
                field
        }

}