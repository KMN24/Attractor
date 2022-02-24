package kg.attractor.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kg.attractor.R
import kg.attractor.databinding.ActivityMainBinding
import kg.attractor.ui.utils.base.BaseActivity
import ru.alefdev.ui.utils.Loadable

class MainActivity : BaseActivity<ActivityMainBinding>(), Loadable {


    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(
            R.id.fragment_container_view
        ) as NavHostFragment
    }

    private val listener =
        NavController.OnDestinationChangedListener { _, dest, _ -> }

    override fun inflateBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavigation()
    }

    private fun setupNavigation() {
        NavigationUI.setupWithNavController(
            binding.bottomNav, navHostFragment.navController
        )
    }

    override fun onResume() {
        super.onResume()
        navHostFragment.navController.addOnDestinationChangedListener(
            listener
        )
    }

    override fun onPause() {
        navHostFragment.navController
            .removeOnDestinationChangedListener(
                listener
            )
        super.onPause()
    }

    override fun onLoadChanged(isLoading: Boolean) {
        binding.inclProgress.clProgressBar.isVisible = isLoading
    }
}