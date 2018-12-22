package com.didimstory.appjam17.data

class UserData {
    var name = ""
    var id = ""
    var passwd = ""
    var email = ""
    var phone = ""
    var token = ""
    lateinit var itemList : ArrayList<TokenItem>
    lateinit var punchList : ArrayList<TokenItem>
    var profileImg  = ""
}