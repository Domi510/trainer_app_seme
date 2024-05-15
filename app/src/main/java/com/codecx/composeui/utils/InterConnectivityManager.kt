package com.codecx.composeui.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
/**
 * Trieda poskytujúca sieťové prepojenie
 * aplikačný kontext slúži na to, aby to fungovalo po
 * celú dobu životnosti aplikácie
 * ConnectivityManager umožňuje aplikácii získavať informácie
 * o stave siete a spravovať sieťové pripojenia
 * */
@Singleton
class InterConnectivityManager @Inject constructor(
    @ApplicationContext context: Context,
    private val connectivityManager: ConnectivityManager
) {

    fun isInternetConnected(): Boolean {
        connectivityManager.activeNetwork ?: return false
        val networkCapabilities = networkCapabilities()
        return networkCapabilities != null &&
                (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET))
    }
/**
 * Funkcia má za úlohu sledovať aktíne sieťové pripojenia
 * V prípade, že neexistuje sieťové prípojenie vráti sa NULL
 * */
    private fun networkCapabilities(): NetworkCapabilities? {
        val network = connectivityManager.activeNetwork
        return connectivityManager.getNetworkCapabilities(network)
    }

    fun isCellular(): Boolean {
        val networkCapabilities = networkCapabilities()
        return networkCapabilities != null && networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
    }

    fun isWifi(): Boolean {
        val networkCapabilities = networkCapabilities()
        return networkCapabilities != null && networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
    }
}