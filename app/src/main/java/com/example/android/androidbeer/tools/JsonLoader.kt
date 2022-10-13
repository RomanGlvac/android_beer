package com.example.android.androidbeer.tools

import android.content.Context
import android.util.Log
import java.io.IOException

object JsonLoader {
    fun openJson(context : Context, path: String) : String? {
        var json : String? = null
        json = try {
            val inputStream = context.assets.open(path)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (e : IOException){
            Log.e("JsonLoader", "Failed to load JSON file: ${e.stackTrace}")
            null
        }
        return json
    }
}