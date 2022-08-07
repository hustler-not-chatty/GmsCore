package hz.snow_ui_lib.collapsing_toolbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import hz.settingslib.R
import hz.settingslib.databinding.BaseActivityCollapsingToolbarBinding

open class CollapsingToolbarBaseFragment(private val resInt: Int) : Fragment() {
    constructor(content: Fragment) : this(0) {
        contentFragment = content
    }

    constructor() : this(0)

    private var contentFragment: Fragment? = null
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
        binding = createBinding(inflater, container, false).apply {
            if (contentFragment == null) {
                setupContentView(onCreateContentView(inflater, container, savedInstanceState))
            }
        }
        return binding!!.root
    }

    open fun onCreateContentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (resInt == 0) {
            throw IllegalArgumentException("Either overload onCreateContentView(), or provide content fragment / resId.")
        } else {
            layoutInflater.inflate(resInt, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let {
            (requireActivity() as AppCompatActivity).setSupportActionBar(it.snowUIToolbar)
        }
        contentFragment?.let {
            val fragmentManager = childFragmentManager
            fragmentManager.beginTransaction().replace(R.id.snowUIFrameLayout, it, "content")
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        @JvmStatic
        fun asFragmentContainer(fragment: Fragment): CollapsingToolbarBaseFragment =
            CollapsingToolbarBaseFragment(fragment)
    }
}