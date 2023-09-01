package com.example.testovoe23

import android.animation.AnimatorInflater
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide
import kotlin.random.Random

class PlayActivity : AppCompatActivity() {

    private lateinit var buttonMore: AppCompatButton
    private lateinit var buttonLess: AppCompatButton
    private lateinit var imageCard: ImageView
    private lateinit var imageViewFon2: ImageView
    private lateinit var winAnimationImageView: ImageView
    private lateinit var lossAnimationImageView: ImageView
    private lateinit var editTextValue: EditText
    private lateinit var textViewScore: TextView
    private lateinit var sharedPreferences: SharedPreferences

    var score = 0
    var stavka = 0
    var current_card = 0
    var next_card = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        buttonMore = findViewById(R.id.buttonMore)
        buttonLess = findViewById(R.id.buttonLess)
        imageCard = findViewById(R.id.imageCard)
        imageViewFon2 = findViewById(R.id.imageViewFon2)
        winAnimationImageView = findViewById(R.id.winAnimationImageView)
        lossAnimationImageView = findViewById(R.id.lossAnimationImageView)
        editTextValue = findViewById(R.id.editTextValue)
        textViewScore = findViewById(R.id.textViewScore)
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        score = sharedPreferences.getInt("score", 5)
        textViewScore.text = score.toString()

        Glide.with(this)
            .load("http://135.181.248.237/23/fon2.png")
            .into(imageViewFon2)

        Glide.with(this).load(R.raw.salut).into(winAnimationImageView)
        Glide.with(this).load(R.raw.loss).into(lossAnimationImageView)

        imageCard.setImageResource(R.drawable._8_of_clubs)
        current_card = 8
        next_card = 8

        buttonMore.setOnClickListener {
            buttonMore.isClickable = false
            buttonLess.isClickable = false
            current_card = next_card
            val flipAnimator = AnimatorInflater.loadAnimator(this, R.animator.card_flip)
            flipAnimator.setTarget(imageCard)
            flipAnimator.start()
            generateNext()
            if (TextUtils.isEmpty(editTextValue.text)){
                stavka = 1
            } else {
                stavka = editTextValue.text.toString().toInt()
            }
            if (stavka<=50&&stavka>score){
                stavka = score
            }
            if (stavka>50&&stavka<=score){
                stavka = 50
            }
            if (stavka>50&&stavka>score){
                if (score>50) {
                    stavka = 50
                } else {
                    stavka = score
                }
            }
            editTextValue.setText(stavka.toString())
            if (current_card<next_card) {
                winAnimationImageView.visibility = View.VISIBLE
                score +=stavka
            } else {
                lossAnimationImageView.visibility = View.VISIBLE
                score -=stavka
            }

            textViewScore.text = score.toString()
            sharedPreferences.edit().putInt("score", score).apply()

            Handler().postDelayed({
                buttonMore.isClickable = true
                buttonLess.isClickable = true
                winAnimationImageView.visibility = View.GONE
                lossAnimationImageView.visibility = View.GONE
            }, 3000)
        }
        buttonLess.setOnClickListener {
            buttonMore.isClickable = false
            buttonLess.isClickable = false
            current_card = next_card
            val flipAnimator = AnimatorInflater.loadAnimator(this, R.animator.card_flip)
            flipAnimator.setTarget(imageCard)
            flipAnimator.start()
            generateNext()
            if (TextUtils.isEmpty(editTextValue.text)){
                stavka = 1
            } else {
                stavka = editTextValue.text.toString().toInt()
            }
            if (stavka<=50&&stavka>score){
                stavka = score
            }
            if (stavka>50&&stavka<=score){
                stavka = 50
            }
            if (stavka>50&&stavka>score){
                if (score>50) {
                    stavka = 50
                } else {
                    stavka = score
                }
            }
            editTextValue.setText(stavka.toString())
            if (current_card>next_card) {
                winAnimationImageView.visibility = View.VISIBLE
                score +=stavka
            } else {
                lossAnimationImageView.visibility = View.VISIBLE
                score -=stavka
            }

            textViewScore.text = score.toString()
            sharedPreferences.edit().putInt("score", score).apply()

            Handler().postDelayed({
                buttonMore.isClickable = true
                buttonLess.isClickable = true
                winAnimationImageView.visibility = View.GONE
                lossAnimationImageView.visibility = View.GONE
            }, 3000)
        }
    }

    private fun generateNext() {
        next_card = Random.nextInt(2, 15)
        var type = Random.nextInt(1, 5)
        if (next_card == 2){
            if (type == 1) {
                imageCard.setImageResource(R.drawable._2_of_clubs)
                return
            }
            if (type == 2) {
                imageCard.setImageResource(R.drawable._2_of_diamonds)
                return
            }
            if (type == 3) {
                imageCard.setImageResource(R.drawable._2_of_hearts)
                return
            }
            if (type == 4) {
                imageCard.setImageResource(R.drawable._2_of_spades)
                return
            }
        }
        if (next_card == 3){
            if (type == 1) {
                imageCard.setImageResource(R.drawable._3_of_clubs)
                return
            }
            if (type == 2) {
                imageCard.setImageResource(R.drawable._3_of_diamonds)
                return
            }
            if (type == 3) {
                imageCard.setImageResource(R.drawable._3_of_hearts)
                return
            }
            if (type == 4) {
                imageCard.setImageResource(R.drawable._3_of_spades)
                return
            }
        }
        if (next_card == 4){
            if (type == 1) {
                imageCard.setImageResource(R.drawable._4_of_clubs)
                return
            }
            if (type == 2) {
                imageCard.setImageResource(R.drawable._4_of_diamonds)
                return
            }
            if (type == 3) {
                imageCard.setImageResource(R.drawable._4_of_hearts)
                return
            }
            if (type == 4) {
                imageCard.setImageResource(R.drawable._4_of_spades)
                return
            }
        }
        if (next_card == 5){
            if (type == 1) {
                imageCard.setImageResource(R.drawable._5_of_clubs)
                return
            }
            if (type == 2) {
                imageCard.setImageResource(R.drawable._5_of_diamonds)
                return
            }
            if (type == 3) {
                imageCard.setImageResource(R.drawable._5_of_hearts)
                return
            }
            if (type == 4) {
                imageCard.setImageResource(R.drawable._5_of_spades)
                return
            }
        }
        if (next_card == 6){
            if (type == 1) {
                imageCard.setImageResource(R.drawable._6_of_clubs)
                return
            }
            if (type == 2) {
                imageCard.setImageResource(R.drawable._6_of_diamonds)
                return
            }
            if (type == 3) {
                imageCard.setImageResource(R.drawable._6_of_hearts)
                return
            }
            if (type == 4) {
                imageCard.setImageResource(R.drawable._6_of_spades)
                return
            }
        }
        if (next_card == 7){
            if (type == 1) {
                imageCard.setImageResource(R.drawable._7_of_clubs)
                return
            }
            if (type == 2) {
                imageCard.setImageResource(R.drawable._7_of_diamonds)
                return
            }
            if (type == 3) {
                imageCard.setImageResource(R.drawable._7_of_hearts)
                return
            }
            if (type == 4) {
                imageCard.setImageResource(R.drawable._7_of_spades)
                return
            }
        }
        if (next_card == 8){
            if (type == 1) {
                imageCard.setImageResource(R.drawable._8_of_clubs)
                return
            }
            if (type == 2) {
                imageCard.setImageResource(R.drawable._8_of_diamonds)
                return
            }
            if (type == 3) {
                imageCard.setImageResource(R.drawable._8_of_hearts)
                return
            }
            if (type == 4) {
                imageCard.setImageResource(R.drawable._8_of_spades)
                return
            }
        }
        if (next_card == 9){
            if (type == 1) {
                imageCard.setImageResource(R.drawable._9_of_clubs)
                return
            }
            if (type == 2) {
                imageCard.setImageResource(R.drawable._9_of_diamonds)
                return
            }
            if (type == 3) {
                imageCard.setImageResource(R.drawable._9_of_hearts)
                return
            }
            if (type == 4) {
                imageCard.setImageResource(R.drawable._9_of_spades)
                return
            }
        }
        if (next_card == 10){
            if (type == 1) {
                imageCard.setImageResource(R.drawable._10_of_clubs)
                return
            }
            if (type == 2) {
                imageCard.setImageResource(R.drawable._10_of_diamonds)
                return
            }
            if (type == 3) {
                imageCard.setImageResource(R.drawable._10_of_hearts)
                return
            }
            if (type == 4) {
                imageCard.setImageResource(R.drawable._10_of_spades)
                return
            }
        }
        if (next_card == 11){
            if (type == 1) {
                imageCard.setImageResource(R.drawable.jack_of_clubs2)
                return
            }
            if (type == 2) {
                imageCard.setImageResource(R.drawable.jack_of_diamonds2)
                return
            }
            if (type == 3) {
                imageCard.setImageResource(R.drawable.jack_of_hearts2)
                return
            }
            if (type == 4) {
                imageCard.setImageResource(R.drawable.jack_of_spades2)
                return
            }
        }
        if (next_card == 12){
            if (type == 1) {
                imageCard.setImageResource(R.drawable.queen_of_clubs2)
                return
            }
            if (type == 2) {
                imageCard.setImageResource(R.drawable.queen_of_diamonds2)
                return
            }
            if (type == 3) {
                imageCard.setImageResource(R.drawable.queen_of_hearts2)
                return
            }
            if (type == 4) {
                imageCard.setImageResource(R.drawable.queen_of_spades2)
                return
            }
        }
        if (next_card == 13){
            if (type == 1) {
                imageCard.setImageResource(R.drawable.king_of_clubs2)
                return
            }
            if (type == 2) {
                imageCard.setImageResource(R.drawable.king_of_diamonds2)
                return
            }
            if (type == 3) {
                imageCard.setImageResource(R.drawable.king_of_hearts2)
                return
            }
            if (type == 4) {
                imageCard.setImageResource(R.drawable.king_of_spades2)
                return
            }
        }
        if (next_card == 14){
            if (type == 1) {
                imageCard.setImageResource(R.drawable.ace_of_clubs)
                return
            }
            if (type == 2) {
                imageCard.setImageResource(R.drawable.ace_of_diamonds)
                return
            }
            if (type == 3) {
                imageCard.setImageResource(R.drawable.ace_of_hearts)
                return
            }
            if (type == 4) {
                imageCard.setImageResource(R.drawable.ace_of_spades2)
                return
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        startActivity(Intent(this, MenuActivity::class.java))
        finish()
        return super.onKeyDown(keyCode, event)
    }
}