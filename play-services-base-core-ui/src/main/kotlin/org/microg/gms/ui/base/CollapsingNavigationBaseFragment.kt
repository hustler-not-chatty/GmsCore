package org.microg.gms.ui.base

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import hz.snow_ui_lib.collapsing_toolbar.CollapsingToolbarBaseFragment

open class CollapsingNavigationBaseFragment : CollapsingToolbarBaseFragment {
    constructor(res: Int) : super(res)
    constructor(fragment: Fragment) : super(fragment)
    constructor() : super(0)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        val appBarConfiguration = AppBarConfiguration(controller.graph)
        collapsingToolbarLayout?.let {
            Log.i("BaseShowcaseFragment", "setupWithNavController")
            it.setupWithNavController(
                toolbar!!,
                controller,
                appBarConfiguration
            )
        }
    }
}