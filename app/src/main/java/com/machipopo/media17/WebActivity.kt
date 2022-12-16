package com.machipopo.media17

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.machipopo.media17.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebBinding

    private var listURL = listOf("http://192.168.0.116:8000/pag/assets/fire_phoenix.pag", "http://192.168.0.116:8000/pag/assets/healfarm.pag")
    private var listAssets = listOf("2205_tw_artemis.pag", "gift_vip_newking.pag", "fire_phoenix.pag", "healfarm.pag")

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {

//            binding.web.executeAnimation(listURL[index])
//            index++
//            if(index >= listURL.size){
//                index = 0
//            }

            binding.web.readPagFile(listAssets[index])
            index++
            if(index >= listAssets.size){
                index = 0
            }
        }
    }

}