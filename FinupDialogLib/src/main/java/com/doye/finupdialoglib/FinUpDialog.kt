package com.doye.finupdialoglib


import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.SpannableString
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment

internal class FinUpDialog(
    private val title: String?, // 제목
    @LayoutRes private val contentViewRes: Int?,// 내용 레이아웃
    private val contentText: String?, // 내용 문구
    private val contentTextSpannableString: SpannableString?, // 내용 StringBuilder
    private val titleTextBold: Boolean, // 제목
    private val contentTextBold: Boolean, // 내용 문구 스타일
    private var fontSize: Float?, // 존체 폰트 사이즈
    @ColorRes private val pointColor: Int?,
    private val positiveButton: FinUpDialogButton?,
    private val negativeButton: FinUpDialogButton?,
    private val enableCancel: Boolean
) : DialogFragment() {
    companion object {
        private const val TAG = "LTDialog"
        private const val DIALOG_WITH_RATIO = 0.8
    }
    private var deviceSizeX: Int? = null

    override fun onResume() {
        super.onResume()
        if (deviceSizeX == null) {
            if (context == null) {
                return
            }
            val size = Point()
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                context!!.display
            } else {
                (context!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
            }?.getRealSize(size)
            deviceSizeX = size.x
        }

        if (deviceSizeX == null) {
            return
        }

        val params = dialog?.window?.attributes
        params?.width = (deviceSizeX!! * DIALOG_WITH_RATIO).toInt()
        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        checkIsIllegalAttribute()

        val view = if (negativeButton != null) {
            inflater.inflate(R.layout.dialog_finup_style2, container,false)
        } else {
            inflater.inflate(R.layout.dialog_finup_style1, container,false)
        }

        initView(view as ViewGroup)

        if (dialog != null) {
            val window: Window? = dialog!!.window
            if (window != null) {
                //다이얼로그의 윤곽선을 둥글게 깎기
                window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                window.requestFeature(Window.FEATURE_NO_TITLE)
            } else {
                Log.e(TAG, "Window is null.")
            }
        } else {
            Log.e(TAG, "Dialog is null.")
        }

        if (!enableCancel) {
            isCancelable = false
        }

        return view
    }

    private fun checkIsIllegalAttribute() {
        if (positiveButton == null) {
            throw IllegalArgumentException("버튼 설정이 없습니다.")
        }
    }

    private fun initView(rootView: ViewGroup) {
        val tvTitle = rootView.findViewById<TextView>(R.id.tvTitle)
        if (title.isNullOrEmpty()) {
            tvTitle.visibility = View.VISIBLE
        } else {
            tvTitle.text = title
        }
        tvTitle.textAlignment = View.TEXT_ALIGNMENT_CENTER
        if(titleTextBold) tvTitle.typeface = Typeface.DEFAULT_BOLD


        val tvContent = rootView.findViewById<TextView>(R.id.tvContent)
        tvContent.textAlignment = View.TEXT_ALIGNMENT_CENTER
        if(contentTextSpannableString != null){
            tvContent.text = contentTextSpannableString
        }else{
            tvContent.text = contentText
            if(contentTextBold) tvContent.typeface = Typeface.DEFAULT_BOLD
        }


        if (negativeButton != null) {
            val btnPositiveButton = rootView.findViewById<Button>(R.id.btnConfirm)

            btnPositiveButton.text = positiveButton!!.text
            btnPositiveButton.setOnClickListener { view ->
                positiveButton.listener?.let {it(view)
                    if (positiveButton.canDismiss) dismiss()
                }
            }

            val btnNegativeButton = rootView.findViewById<Button>(R.id.btnCancel)

            btnNegativeButton.text = negativeButton!!.text
            btnNegativeButton.setOnClickListener { view ->
                negativeButton.listener?.let {it(view)
                    if (negativeButton.canDismiss) dismiss()
                }
            }

        } else {
            val btnPositiveButton = rootView.findViewById<Button>(R.id.btnCheck)
            btnPositiveButton.text = positiveButton!!.text
            btnPositiveButton.setOnClickListener { view ->
                positiveButton.listener?.let { it(view)
                    if (positiveButton.canDismiss) dismiss()
                }
            }
        }


    }


}