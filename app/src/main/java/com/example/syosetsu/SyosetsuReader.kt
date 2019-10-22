package com.example.syosetsu

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.FuelJson
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result

class SyosetsuReader {

    fun urlRequest() {

        val url = "https://api.syosetu.com/novelapi/api/?out=json&order=weeklypoint"

        url.httpGet().responseJson { request, response, result ->

            when(result) {

                is Result.Success -> {
                    println("通信成功")
                }

                is Result.Failure -> {
                    println("通信失敗")
                }

            }

        }
    }

}