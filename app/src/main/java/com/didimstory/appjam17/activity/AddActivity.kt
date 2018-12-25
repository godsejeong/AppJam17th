package com.didimstory.appjam17.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.didimstory.appjam17.R
import com.didimstory.appjam17.data.BasicData
import com.didimstory.appjam17.data.User
import com.didimstory.appjam17.data.UserData
import com.didimstory.appjam17.utils.ORMUtils
import com.didimstory.appjam17.utils.Utils
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddActivity : AppCompatActivity() {
    var spnnierdata = ArrayList<String>()
    var spinnerdata : String = ""
    var name : String = ""
    var token : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setTitle("아이디어")
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        token = pref.getString("token",null)
        name = pref.getString("name",null)

        spnnierdata.add("분야")
        spnnierdata.add("IT")
        spnnierdata.add("스포츠")
        spnnierdata.add("유통 및 판매")
        spnnierdata.add("쇼핑")
        spnnierdata.add("외식 및 요리")
        spnnierdata.add("대여 및 배달")
        spnnierdata.add("기타")

        var adatper = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, spnnierdata)

        addSpinner.adapter = adatper


        addSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                var name = addSpinner.getItemAtPosition(position) as String
                if(name != "분야"){
                    spinnerdata = name
                }else{
                    Toast.makeText(applicationContext,"도시를 선택해 주세요",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.itemId){

            R.id.finish-> {
                add()
            }

            R.id.home -> finish()
        }

        return super.onContextItemSelected(item)
    }

    fun add(){
        if(spinnerdata != "" && addContent.text.toString().isNotEmpty() && addTitle.text.toString().isNotEmpty()){
            var res: Call<BasicData> = Utils.postService.newIdea("",spinnerdata,name,addTitle.text.toString(),addContent.text.toString(),token)
            res.enqueue(object : Callback<BasicData>{
                override fun onFailure(call: Call<BasicData>, t: Throwable) {
                    Log.e("addError",t.message)
                    Toast.makeText(applicationContext, "서버에서 에러가 발생하였습니다.", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<BasicData>, response: Response<BasicData>) {

                    if(response.code() == 200){
                        Toast.makeText(applicationContext, "게시글이 등록되었습니다.", Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        Toast.makeText(applicationContext, "게시글이 등록되지 않았습니다.", Toast.LENGTH_SHORT).show()
                        Log.e("code", response.code().toString())
                    }
                }

            })
        }else{
            Toast.makeText(applicationContext, "항목을 모두 기입해주세요", Toast.LENGTH_SHORT).show()

        }
    }

}
