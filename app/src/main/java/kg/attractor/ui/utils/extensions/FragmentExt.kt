package kg.attractor.ui.utils.extensions

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.view.View
import androidx.activity.addCallback
import androidx.annotation.StringRes
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kg.attractor.R
import kg.attractor.ui.utils.RQ_READ_EXTERNAL

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

fun Fragment.pickImages() {
    if (ActivityCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            RQ_READ_EXTERNAL
        )
        return
    }
    val intent = Intent()
    intent.type = "image/*"
    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
    intent.action = Intent.ACTION_GET_CONTENT
    startActivityForResult(
        Intent.createChooser(
            intent,
            getString(R.string.select_pictures)
        ), 0
    )
}



