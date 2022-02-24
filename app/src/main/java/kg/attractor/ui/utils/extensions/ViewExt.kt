package kg.attractor.ui.utils.extensions

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun ImageView.setImage(url: String?) {
    Glide.with(this.context).load(url).into(this)
}


