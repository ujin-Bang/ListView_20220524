package com.start.listview_20220524

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.listview_20220524.adapters.StudentAdapter
import com.start.listview_20220524.databinding.ActivityMainBinding
import com.start.listview_20220524.datas.StudentData

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    val mStudentList = ArrayList<StudentData>()
    lateinit var mStudentAdapter : StudentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        mStudentList.add( StudentData("조경진",1988, "서울시 동대문구") )
        mStudentList.add( StudentData("김민성", 1998, "서울시 종로구"))
        mStudentList.add( StudentData("김준기", 1996,  "경기도 남양주시"))
        mStudentList.add( StudentData("방우진", 1983,  "경기도 고양시"))
        mStudentList.add( StudentData("이아현", 1996,  "서울시 동대문구"))
        mStudentList.add( StudentData("이지원", 1993,  "서울시 관악구"))
        mStudentList.add( StudentData("차수나", 1977,  "서울시 성북구"))
        mStudentList.add( StudentData("김경식", 1992,  "서울시 중랑구"))

        mStudentAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)
        binding.studentListView.adapter = mStudentAdapter


    }
}