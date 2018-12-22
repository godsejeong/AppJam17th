package com.didimstory.appjam17.data


data class login( val name: String, val password: String)
data class User(val name:String, val id:String, val password:String, val email:String, val phone:String
,val token: token, val itemList : ArrayList<token>, val punchList : ArrayList<token>, val profileImg : String)


