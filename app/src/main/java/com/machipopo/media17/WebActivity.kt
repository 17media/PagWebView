package com.machipopo.media17

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.machipopo.media17.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebBinding

    private var listAssets = listOf("2205_tw_artemis.pag", "gift_vip_newking.pag", "fire_phoenix.pag", "healfarm.pag")

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            binding.web.readPagFile(listAssets[index])
            index++
            if(index >= listAssets.size){
                index = 0
            }
        }
    }

}