package kg.attractor.ui.utils.extensions

import android.app.Activity
import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar


val fragmentsToHideBottomNavOn = hashSetOf(
-1
)

fun Activity.snackbar(
    message: String,
    view: View = window.decorView.rootView,
    duration: Int = Snackbar.LENGTH_SHORT
) {
    Snackbar.make(
        view,
        message,
        duration
    ).show()
}

fun Activity.snackbar(
    @StringRes message: Int,
    view: View = window.decorView.rootView,
    duration: Int = Snackbar.LENGTH_SHORT
) {
    snackbar(getString(message), view, duration)
}