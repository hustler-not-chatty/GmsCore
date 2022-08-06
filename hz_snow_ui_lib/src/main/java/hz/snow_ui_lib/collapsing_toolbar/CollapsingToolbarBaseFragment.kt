package hz.snow_ui_lib.collapsing_toolbar

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.appbar.AppBarLayout
import hz.settingslib.databinding.BaseActivityCollapsingToolbarBinding

open class CollapsingToolbarBaseFragment: Fragment() {
    private var binding: BaseActivityCollapsingToolbarBinding? = null

    var toolbar
        get() = binding?.snowUIToolbar
        private set(_) {}
    var coordinatorLayout
        get() = binding?.snowUICoordinatorLayout
        private set(_) {}
    var collapsingToolbarLayout
        get() = binding?.snowUICollapsingToolbarLayout
        private set(_) {}
    var contentFrameLayout
        get() = binding?.snowUIFrameLayout
        private set(_) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BaseActivityCollapsingToolbarBinding.inflate(inflater, container, false)
        // disables scrolling behaviour for CollapsingToolbarLayout
        val params = binding!!.snowUIAppBarLayout.layoutParams as CoordinatorLayout.LayoutParams
        val behaviour = AppBarLayout.Behavior()
        behaviour.setDragCallback(object: AppBarLayout.Behavior.DragCallback() {
            override fun canDrag(appBarLayout: AppBarLayout): Boolean = false
        })
        params.behavior = behaviour
        val clientView = this.onCreateContentView(inflater, binding!!.snowUIFrameLayout, savedInstanceState)
        if (clientView != null) binding!!.snowUIFrameLayout.addView(clientView)
        return binding!!.root
    }

    open fun onCreateContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let {
            (requireActivity() as AppCompatActivity).setSupportActionBar(it.snowUIToolbar)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}