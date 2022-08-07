package hz.snow_ui_lib.preferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceFragmentCompat
import hz.snow_ui_lib.collapsing_toolbar.createBinding
import hz.snow_ui_lib.collapsing_toolbar.setupContentView

abstract class CollapsingPreferenceFragmentCompat : PreferenceFragmentCompat() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = createBinding(inflater, container, false).apply {
            setupContentView(super.onCreateView(inflater, container, savedInstanceState))
        }
        return binding.root
    }
}