package hz.snow_ui_lib.collapsing_toolbar

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import hz.settingslib.databinding.BaseActivityCollapsingToolbarBinding

fun createBinding(
    layoutInflater: LayoutInflater,
    container: ViewGroup?,
    attachToParent: Boolean
): BaseActivityCollapsingToolbarBinding {
    return BaseActivityCollapsingToolbarBinding.inflate(
        layoutInflater,
        container,
        attachToParent
    ).apply { setupAppBarLayout() }
}

@SuppressLint("RestrictedApi")
fun BaseActivityCollapsingToolbarBinding.setupAppBarLayout() {
    if (Build.VERSION.SDK_INT >= 23) {
        snowUICollapsingToolbarLayout.lineSpacingMultiplier =
            TOOLBAR_LINE_SPACING_MULTIPLIER
    }
    // disables scrolling behaviour for CollapsingToolbarLayout
    val params = snowUIAppBarLayout.layoutParams as CoordinatorLayout.LayoutParams
    val behaviour = AppBarLayout.Behavior()
    behaviour.setDragCallback(object : AppBarLayout.Behavior.DragCallback() {
        override fun canDrag(appBarLayout: AppBarLayout): Boolean = false
    })
    params.behavior = behaviour
}

fun BaseActivityCollapsingToolbarBinding.setupContentView(view: View?) {
    view?.let {
        this.snowUIFrameLayout.removeAllViews()
        this.snowUIFrameLayout.addView(it)
    }

}

const val TOOLBAR_LINE_SPACING_MULTIPLIER = 1.1f

