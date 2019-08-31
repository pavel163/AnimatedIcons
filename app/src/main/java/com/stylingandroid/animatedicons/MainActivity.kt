package com.stylingandroid.animatedicons

import android.graphics.drawable.Animatable2
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        activity_main.children().filterIsInstance<ImageView>().forEach { it.start() }
    }

    private fun ViewGroup.children() =
        (0 until childCount).map { getChildAt(it) }

    private fun ImageView.start() {
        (drawable as? Animatable2)?.start()
    }

    override fun onPause() {
        super.onPause()

        activity_main.children().filterIsInstance<ImageView>().forEach { it.stop() }
    }

    private fun ImageView.stop() {
        (drawable as? Animatable2)?.stop()
    }
}
