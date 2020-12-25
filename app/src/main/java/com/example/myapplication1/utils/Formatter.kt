package com.example.myapplication1.utils

import java.text.NumberFormat
import java.util.*

class Formatter(){

    fun rupiahFormatter(price : String): String {
        val modelprice = price.toDouble()
        val localeID =  Locale("in", "ID")
        val numberFormat = NumberFormat.getCurrencyInstance(localeID)
        return numberFormat.format(modelprice).toString()
    }
}