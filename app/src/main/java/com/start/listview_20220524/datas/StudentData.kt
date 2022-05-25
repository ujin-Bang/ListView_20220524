package com.start.listview_20220524.datas

import java.io.Serializable

class StudentData(
    val name: String,
    val birthYear: Int,
    val address: String):Serializable {

        fun age(year: Int): Int {

            val myYear = year - this.birthYear +1

            return myYear
        }
}