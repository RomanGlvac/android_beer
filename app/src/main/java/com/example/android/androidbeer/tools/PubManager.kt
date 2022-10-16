package com.example.android.androidbeer.tools

import android.content.Context
import com.example.android.androidbeer.models.PubHolder
import com.google.gson.Gson

object PubManager {
    private var pubHolder : PubHolder? = null
    private const val PUB_FILE_NAME = "pubs.json"

    fun getPubHolder(context : Context) : PubHolder? {
        if(pubHolder == null){
            val json = JsonLoader.openJson(context, PUB_FILE_NAME)
            pubHolder = Gson().fromJson(json, PubHolder::class.java)
        }
        return pubHolder
    }
}