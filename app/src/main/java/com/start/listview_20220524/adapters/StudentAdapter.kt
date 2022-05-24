package com.start.listview_20220524.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.start.listview_20220524.datas.StudentData

class StudentAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<StudentData> ) : ArrayAdapter<StudentData>() {
}