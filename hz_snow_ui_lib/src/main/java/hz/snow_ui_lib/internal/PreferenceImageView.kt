package hz.snow_ui_lib.internal

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

// Mimic work of https://androidx.de/androidx/preference/internal/PreferenceImageView.html
@SuppressLint("PrivateResource")
class PreferenceImageView(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) :
    AppCompatImageView(context, attributeSet, defStyleAttr) {
    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)

    private var mMaxWidth = Int.MAX_VALUE
    private var mMaxHeight = Int.MAX_VALUE

    init {
        val typedArr = context.obtainStyledAttributes(
            attributeSet,
            androidx.preference.R.styleable.PreferenceImageView,
            defStyleAttr,
            0
        )
        maxHeight = typedArr.getDimensionPixelSize(
            androidx.preference.R.styleable.PreferenceImageView_maxHeight,
            Int.MAX_VALUE
        )
        maxWidth = typedArr.getDimensionPixelSize(
            androidx.preference.R.styleable.PreferenceImageView_maxWidth,
            Int.MAX_VALUE
        )
        typedArr.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var newWidthMeasureSpec = widthMeasureSpec
        var newHeightMeasureSpec = heightMeasureSpec
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        if (widthMode == MeasureSpec.AT_MOST || widthMode == MeasureSpec.UNSPECIFIED) {
            val widthSize = MeasureSpec.getSize(widthMeasureSpec)
            if (maxWidth != Int.MAX_VALUE && (maxWidth < widthSize || widthMode == MeasureSpec.UNSPECIFIED)) {
                newWidthMeasureSpec = MeasureSpec.makeMeasureSpec(maxWidth, MeasureSpec.AT_MOST)
            }
        }
        val heightMode = MeasureSpec.getMode(widthMeasureSpec)
        if (heightMode == MeasureSpec.AT_MOST || heightMode == MeasureSpec.UNSPECIFIED) {
            val heightSize = MeasureSpec.getSize(heightMeasureSpec)
            if (maxHeight != Int.MAX_VALUE && (maxHeight < heightSize || heightMode == MeasureSpec.UNSPECIFIED)) {
                newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST)
            }
        }
        super.onMeasure(newWidthMeasureSpec, newHeightMeasureSpec)
    }

    override fun getMaxHeight() = mMaxHeight
    override fun getMaxWidth() = mMaxWidth
    override fun setMaxHeight(maxHeight: Int) {
        mMaxHeight = maxHeight
        super.setMaxHeight(maxHeight)
    }

    override fun setMaxWidth(maxWidth: Int) {
        mMaxWidth = maxWidth
        super.setMaxWidth(maxWidth)
    }
}