package com.didimstory.appjam17.utils

import android.content.Context
import ninja.sakib.pultusorm.core.PultusORM

class ORMUtils(context: Context) {
    val appPath: String = context.filesDir.absolutePath
    var userORM = PultusORM("user.db" , appPath)
    var tokenORM = PultusORM("token.db" , appPath)
}