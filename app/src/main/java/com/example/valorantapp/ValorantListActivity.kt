package com.example.valorantapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantapp.databinding.ActivityValorantListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Collections


class ValorantListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityValorantListBinding
    private lateinit var valSkins: Data
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValorantListBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val inputStream = resources.openRawResource(R.raw.skins)
//        val jsonString = inputStream.bufferedReader().use {
//            it.readText()
//        }
//        Log.d(TAG, "OnCreate: jsonString $jsonString")
//        val gson = Gson()
//        val type = object: TypeToken<Data>() {
//        }.type
//        valSkins = gson.fromJson(jsonString, type)
//
//        Log.d(TAG,"LoadSkins $valSkins")


        val retrofit = RetrofitHelper.getInstance()
        val valorantService = retrofit.create(ValorantService::class.java)
        val valorantCall = valorantService.getValoSkin()
        valorantCall.enqueue(object: Callback<Data> {
            override fun onResponse(
                call: Call<Data>,
                response: Response<Data>
            ) {
                // this is where you get your data.
                // this is where you will set up your adapter for recyclerview
                // don't forget a null check before trying to use the data
                // response.body() contains the object in the<> after Response
                valSkins = response.body()!!

                if (response.body() == null) {
                    Log.d(TAG, "onResponse: Failed")
                }

                valSkins.data = valSkins.data
                    ?.filterNot{it?.contentTierUuid == null}
                    ?.filterNot{it?.displayIcon == null}
                Collections.shuffle(valSkins.data)
             //   valSkins.data = valSkins.data?.subList(0,8)
                refreshList()
                Log.d(ContentValues.TAG, "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d(ContentValues.TAG, "OnFailure ${t.message}")
            }
        })
    }
    fun refreshList() {
        val adapter = ValorantAdapter(valSkins)
        val recyclerView: RecyclerView = binding.recyclerViewValorantList
        binding.recyclerViewValorantList.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewValorantList.adapter = adapter
    }
}