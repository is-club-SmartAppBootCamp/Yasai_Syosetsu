package com.example.syosetsu

import android.util.Log
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import java.lang.Exception

class SyosetsuReader {

    fun urlRequest() {

        val url = "https://api.syosetu.com/novelapi/api/?out=json&order=weeklypoint"

        url.httpGet().responseJson { request, response, result ->

            when(result) {

                is Result.Success -> {
                    val json = result.value.array()

                    for(i in 1..json.length()-1) {
                        val title = json.getJSONObject(i).getString("title")
                        val ncode = json.getJSONObject(i).getString("ncode")
                        val writer = json.getJSONObject(i).getString("writer")

                        println("タイトル: " + title)
                        println("Nコード: " + ncode)
                        println("作者名: " + writer)
                        println("")
                    }
                }

                is Result.Failure -> {
                    println("通信失敗")
                }

            }

        }
    }
}
