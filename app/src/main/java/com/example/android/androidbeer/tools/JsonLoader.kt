package com.example.android.androidbeer.tools

import android.content.Context
import android.util.Log
import java.io.IOException
import java.nio.charset.Charset

class JsonLoader {
    companion object {
        fun openJson(context : Context, path: String) : String? {
            var json : String? = null
            val charset : Charset = Charsets.UTF_8
            json = try {
                val `is` = context.assets.open(path)
                val size = `is`.available()
                val buffer = ByteArray(size)
                `is`.read(buffer)
                `is`.close()
                String(buffer, charset)
            } catch (e : IOException){
                Log.e("JsonLoader", "Failed to load JSON file: ${e.stackTrace}")
                null
            }
            return json
        }
    }
}