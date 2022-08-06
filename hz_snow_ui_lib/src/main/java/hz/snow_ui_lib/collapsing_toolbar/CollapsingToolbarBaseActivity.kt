package hz.snow_ui_lib.collapsing_toolbar

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.MaterialToolbar
import hz.settingslib.databinding.BaseActivityCollapsingToolbarBinding

open class CollapsingToolbarBaseActivity: BaseActivity() {
    private var binding: BaseActivityCollapsingToolbarBinding? = null
    private var customLayoutResId = 0
    var collapsingToolbarLayout: CollapsingToolbarLayout?
        get() = binding?.snowUICollapsingToolbarLayout
        private set(_) {}
    var appBarLayout: AppBarLayout?
        get() = binding?.snowUIAppBarLayout
        private set(_) {}
    var materialToolbar: MaterialToolbar?
        get() = binding?.snowUIToolbar
        private set(_) {}
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (customLayoutResId > 0) {
            super.setContentView(customLayoutResId)
            return
        }
        binding = BaseActivityCollapsingToolbarBinding.inflate(layoutInflater).apply {
            super.setContentView(root)
            setSupportActionBar(snowUIToolbar)
            if (Build.VERSION.SDK_INT >= 23) {
                this.snowUICollapsingToolbarLayout.lineSpacingMultiplier = TOOLBAR_LINE_SPACING_MULTIPLIER
            }

            // disables scrolling behaviour for CollapsingToolbarLayout
            val params = snowUIAppBarLayout.layoutParams as CoordinatorLayout.LayoutParams
            val behaviour = AppBarLayout.Behavior()
            behaviour.setDragCallback(object: AppBarLayout.Behavior.DragCallback() {
                override fun canDrag(appBarLayout: AppBarLayout): Boolean = false
            })
            params.behavior = behaviour
        }
    }

    override fun setContentView(layoutResID: Int) {
        binding?.let { b ->
            b.snowUIFrameLayout.let {
                it.removeAllViews()
                layoutInflater.inflate(layoutResID, it)
            }
        }
    }

    override fun setContentView(view: View?) {
        binding?.snowUIFrameLayout?.addView(view)
    }

    override fun setContentView(view: View?, params: ViewGroup.LayoutParams?) {
        binding?.snowUIFrameLayout?.addView(view, params)
    }

    protected fun setCustomizeContentView(layoutResID: Int) {
        customLayoutResId = layoutResID
    }

    override fun onNavigateUp(): Boolean {
        if (!super.onNavigateUp()) {
            supportFinishAfterTransition()
        }
        return true
    }

    companion object {
        const val TOOLBAR_LINE_SPACING_MULTIPLIER = 1.1f
    }
}