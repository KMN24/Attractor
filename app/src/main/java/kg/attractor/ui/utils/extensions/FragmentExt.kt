package kg.attractor.ui.utils.extensions

import android.view.View
import androidx.activity.addCallback
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

fun Fragment.snackbar(
    message: String,
    root: View? = view,
    duration: Int = Snackbar.LENGTH_SHORT
) {
    if (root == null) {
        requireActivity().snackbar(
            message = message,
            duration = duration
        )
    } else {
        Snackbar.make(root, message, duration).show()
    }
}

fun Fragment.snackbar(
    @StringRes message: Int,
    view: View? = null,
    duration: Int = Snackbar.LENGTH_SHORT
) {
    snackbar(getString(message), view, duration)
}



