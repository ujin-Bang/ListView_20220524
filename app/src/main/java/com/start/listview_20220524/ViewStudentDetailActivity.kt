package com.start.listview_20220524

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.listview_20220524.databinding.ActivityMainBinding
import com.start.listview_20220524.databinding.ActivityViewStudentDetailBinding

class ViewStudentDetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityViewStudentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_student_detail)

        val name = intent.getStringExtra("name")
        binding.txtName.text = name

        val address = intent.getStringExtra("address")
        binding.txtAddress.text = address

        val birthYear = intent.getIntExtra("birthYear", 0)
        val age = 2022 - birthYear + 1
//        binding.txtAge.text = birthYear.toString()
        binding.txtAge.text = "${age}세 입니다."
    }
}