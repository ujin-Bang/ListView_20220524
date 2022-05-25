package com.start.listview_20220524

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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

//        리스트뷰의 각 줄이 눌린 이벤트처리
        binding.studentListView.setOnItemClickListener { parent, view, position, id ->
//            position : 몇번 줄리 눌렸는가? 알려주는 역할.
            Log.d("리스트뷰클릭됨","${position}번줄 클릭됨")

//            눌린 위치에 맞는 학생 데이터 변수에 저장
            val clickedStudent = mStudentList[ position ]

//            ex. 클릭된 학생의 이름을 토스트로 출력
//            Toast.makeText(this, "${clickedStudent.name} 학생 클릭됨", Toast.LENGTH_SHORT).show()

//            상세보기 화면으로 이동
            val myIntent = Intent(this, ViewStudentDetailActivity::class.java)
            myIntent.putExtra("name",clickedStudent.name)
            myIntent.putExtra("birthYear",clickedStudent.birthYear)
            myIntent.putExtra("address",clickedStudent.address)
            startActivity(myIntent)

        }

        binding.studentListView.setOnItemLongClickListener { parent, view, position, id ->

            val longClickedStudent = mStudentList [position]

            Toast.makeText(this, "${longClickedStudent.name}학생이 길게 눌림", Toast.LENGTH_SHORT).show()

//          Boolean(true / false)을 결과로 지정해줘야함.
            return@setOnItemLongClickListener true
        }

    }
}