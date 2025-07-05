package vn.minh_nguyen.vkey.switchcustom

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.FrameLayout
import vn.minh_nguyen.vkey.switchcustom.databinding.CustomSwitchLayoutBinding
import kotlin.time.Duration

@SuppressLint("ClickableViewAccessibility")
class ButtonSwitch @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {
    private var duration: Long = 0
    private var oldChecked = false

    private var onCheckedChangeListener: OnCheckedChangeListener? = null
    private val binding: CustomSwitchLayoutBinding =
        CustomSwitchLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    private var isChecked = false
    private var downX = 0f
    private var thumbStartTranslationX = 0f

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.SwitchCustom, 0, 0).apply {
            try {
                isChecked = getBoolean(R.styleable.SwitchCustom_msw_checked, false)

                val thumbResId = getResourceId(
                    R.styleable.SwitchCustom_msw_thumbDrawable,
                    R.drawable.custom_thumb
                )
                val trackResId = getResourceId(
                    R.styleable.SwitchCustom_msw_trackDrawable,
                    R.drawable.custom_track
                )
                if (thumbResId != 0) setThumbDrawable(thumbResId)
                if (trackResId != 0) setTrackDrawable(trackResId)

                if (hasValue(R.styleable.SwitchCustom_msw_thumbSize)) {
                    val size = getDimensionPixelSize(R.styleable.SwitchCustom_msw_thumbSize, 0)
                    thumbSizePx(size)
                } else {
                    val w = getDimensionPixelSize(R.styleable.SwitchCustom_msw_thumbWidth, 0)
                    if (w > 0) thumbWidthPx(w)
                    val h = getDimensionPixelSize(R.styleable.SwitchCustom_msw_thumbHeight, 0)
                    if (h > 0) thumbHeightPx(h)
                }

                val trackW = getDimensionPixelSize(R.styleable.SwitchCustom_msw_trackWidth, 0)
                if (trackW > 0) trackWidthPx(trackW)

                val trackH = getDimensionPixelSize(R.styleable.SwitchCustom_msw_trackHeight, 0)
                if (trackH > 0) trackHeightPx(trackH)

                val marginTrackH =
                    getDimensionPixelSize(R.styleable.SwitchCustom_msw_trackMarginHorizontal, 0)
                if (marginTrackH > 0) trackMarginHorizontal(marginTrackH)

                val paddingThumb =
                    getDimensionPixelSize(R.styleable.SwitchCustom_msw_thumbPadding, 0)
                if (paddingThumb > 0) thumbPadding(paddingThumb)

                duration = getInt(R.styleable.SwitchCustom_msw_duration_thumb, 200).toLong()
                if (duration < 0){
                    duration = 0
                }
            } finally {
                recycle()
            }
        }

        post { updateUI(shouldNotify = false) }

        binding.iconTrack.setOnClickListener {
            isChecked = !isChecked
            updateUI(withAnimation = true)
        }

        binding.thumbWrapper.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    downX = event.rawX
                    thumbStartTranslationX = binding.thumbWrapper.translationX
                    oldChecked = isChecked
                    true
                }

                MotionEvent.ACTION_MOVE -> {
                    val dx = event.rawX - downX
                    if (kotlin.math.abs(dx) > 10) {
                        val maxX = width - binding.thumbWrapper.width
                        val newX = (thumbStartTranslationX + dx).coerceIn(0f, maxX.toFloat())
                        binding.thumbWrapper.translationX = newX
                    }
                    true
                }

                MotionEvent.ACTION_UP -> {
                    val dx = event.rawX - downX

                    val newState = if (kotlin.math.abs(dx) < 10) {
                        !oldChecked
                    } else {
                        val middle = (width - binding.thumbWrapper.width) / 2
                        binding.thumbWrapper.translationX >= middle
                    }

                    if (newState != oldChecked) {
                        isChecked = newState
                        updateUI(withAnimation = true, shouldNotify = true)
                    } else {
                        isChecked = oldChecked
                        updateUI(withAnimation = true, shouldNotify = false)
                    }

                    true
                }

                else -> false
            }
        }

    }

    private fun updateUI(shouldNotify: Boolean = true, withAnimation: Boolean = false, duration: Long = this.duration) {
        binding.iconTrack.isSelected = isChecked
        binding.iconThumb.isSelected = isChecked

        val targetX = if (isChecked) width - binding.thumbWrapper.width.toFloat() else 0f

        if (withAnimation) {
            binding.thumbWrapper.animate()
                .translationX(targetX)
                .setDuration(duration)
                .setInterpolator(android.view.animation.AccelerateDecelerateInterpolator())
                .start()
        } else {
            binding.thumbWrapper.animate().cancel()
            binding.thumbWrapper.translationX = targetX
        }

        if (shouldNotify) {
            onCheckedChangeListener?.onCheckedChanged(isChecked)
        }
    }

    fun setChecked(checked: Boolean) {
        if (isChecked != checked) {
            isChecked = checked
            updateUI(shouldNotify = false)
        }
    }

    fun isChecked(): Boolean = isChecked

    fun setOnCheckedChangeListener(listener: OnCheckedChangeListener) {
        onCheckedChangeListener = listener
    }

    fun setThumbDrawable(resourceId: Int) {
        binding.iconThumb.setImageResource(resourceId)
    }

    fun setTrackDrawable(resourceId: Int) {
        binding.iconTrack.setImageResource(resourceId)
    }

    fun thumbWidthPx(px: Int) {
        binding.iconThumb.layoutParams = binding.iconThumb.layoutParams.apply { width = px }
        updateUI(false)
    }

    fun thumbHeightPx(px: Int) {
        binding.iconThumb.layoutParams = binding.iconThumb.layoutParams.apply { height = px }
        updateUI(false)
    }

    fun thumbSizePx(px: Int) {
        binding.iconThumb.layoutParams = binding.iconThumb.layoutParams.apply {
            width = px
            height = px
        }
        updateUI(false)
    }

    fun trackWidthPx(px: Int) {
        binding.iconTrack.layoutParams = binding.iconTrack.layoutParams.apply { width = px }
    }

    fun trackHeightPx(px: Int) {
        binding.iconTrack.layoutParams = binding.iconTrack.layoutParams.apply { height = px }
    }

    fun trackMarginHorizontal(px: Int) {
        (binding.iconTrack.layoutParams as? MarginLayoutParams)?.let {
            it.leftMargin = px
            it.rightMargin = px
            binding.iconTrack.layoutParams = it
        }
    }

    fun thumbPadding(px: Int) {
        binding.thumbWrapper.setPadding(px, px, px, px)
    }

    fun interface OnCheckedChangeListener {
        fun onCheckedChanged(isChecked: Boolean)
    }
}


