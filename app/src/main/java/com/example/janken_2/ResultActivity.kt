package com.example.janken_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.janken_2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    //じゃんけんの手の定数
    val gu = 0
    val choki = 1
    val pa = 2
    //onCreate内で初期化する
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //MainActivityより選択した手の画像を取得
        val id = intent.getIntExtra("MY_HAND", 0)

        val myHand: Int

        //idに格納されている画像に応じて、myHandImageにセット＆手の定数をリターン
        myHand = when(id){
            R.id.gu -> {
                binding.myHandImage.setImageResource(R.drawable.gu)
                gu
            }
            R.id.choki -> {
                binding.myHandImage.setImageResource(R.drawable.choki)
                choki
            }
            R.id.pa -> {
                binding.myHandImage.setImageResource(R.drawable.pa)
                pa
            }
            else -> {
                gu
            }
        }

        //コンピュータの手を決める
        val comHand = (Math.random() * 3).toInt()
        when(comHand) {
            gu -> binding.comHandImage.setImageResource(R.drawable.com_gu)
            choki -> binding.comHandImage.setImageResource(R.drawable.com_choki)
            pa -> binding.comHandImage.setImageResource(R.drawable.com_pa)
        }

        //勝敗の判定
        val gameResult = (comHand - myHand + 3) % 3
        when(gameResult){
            0 -> binding.resultLabel.setText(R.string.result_draw)
            1 -> binding.resultLabel.setText(R.string.result_win)
            2 -> binding.resultLabel.setText(R.string.result_lose)
        }
    }


}