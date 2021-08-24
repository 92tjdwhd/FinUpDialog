package com.doye.finupdialoglib

import android.text.SpannableString
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import java.lang.StringBuilder

/**
 * Builder for generate FinUpDialog
 * @author DoyE
 * @since 2021/07/28
 */
class FinUpDialogBuilder {

    private var textSize: Float? = null

    private var title: String? = null
    private var contentText: String? = null
    private var contentTextSpannableString: SpannableString? = null

    private var enableCancel: Boolean = true
    private var titleIsBold: Boolean = false
    private var contentIsBold: Boolean = false

    private var textTitleAlignment: Int? = null
    private var textContentAlignment: Int? = null

    @ColorRes private var pointColor: Int? = null
    @LayoutRes private var contentRes: Int? = null

    private var positiveButton: FinUpDialogButton? = null
    private var negativeButton: FinUpDialogButton? = null

    /**
     * 다이얼로그를 호출하면 DialogFragment의 FinUpDialog 인스턴스를 얻을 수 있다.
     * 이것을 호출하기 전에 적어도 하나의 속성을 적용해야 합니다.
     */
    fun build(): DialogFragment {

        return FinUpDialog(title,
            contentRes,
            contentText,
            contentTextSpannableString,
            titleIsBold,
            contentIsBold,
            textSize,
            textTitleAlignment,
            textContentAlignment,
            pointColor,
            positiveButton,
            negativeButton,
            enableCancel
        )
    }

    /**
     * 다이얼로그 타이틀 설정한다.
     * @param title 다이얼로그 타이틀
     */
    fun setTitle(title: String): FinUpDialogBuilder {
        this.title = title
        return this
    }


//    /**
//     * Add a content using layout
//     * It will be placed to between title and buttons.
//     * The content layout should be pre-made in xml.
//     * It is recommended that width is "match_parent" and height is "wrap_content".
//     * @param layoutRes Id of content layout. ex) R.layout.....
//     */
//    fun setContentView(@LayoutRes layoutRes: Int): FinUpDialogBuilder {
//        this.contentRes = layoutRes
//        return this
//    }

    /**
     * 내용을 텍스트로 추가합니다.
     * @param contentText 내용
     */
    fun setContentText(contentText: String):FinUpDialogBuilder  {
        this.contentText = contentText
        return this
    }

    /**
     * 내용을 SpannableString 텍스트로 추가합니다.
     * @param contentTextSpannableString 내용
     */
    fun setContentTextSpannableString(contentTextStringBuilder: SpannableString):FinUpDialogBuilder  {
        this.contentTextSpannableString = contentTextStringBuilder
        return this
    }

    /**
     * 내용을 ContentTextAlignment 텍스트 정렬 추가합니다.
     * @param textContentAlignment 내용
     */
    fun setContentTextAlignment(contentTextAlignment: Int):FinUpDialogBuilder  {
        this.textContentAlignment = contentTextAlignment
        return this
    }

    /**
     * 내용을 TitleTextAlignment 텍스트 정렬 추가합니다.
     * @param textContentAlignment 내용
     */
    fun setTitleTextAlignment(titleTextAlignment: Int):FinUpDialogBuilder  {
        this.textTitleAlignment = titleTextAlignment
        return this
    }


    /**
     * 내용 텍스트 bold 타입 추가합니다.
     * @param isBold true bold 처리
     */
    fun setContentISBold(isBold: Boolean):FinUpDialogBuilder  {
        this.contentIsBold = isBold
        return this
    }

    /**
     * 내용 텍스트 bold 타입 추가합니다.
     * @param isBold true bold 처리
     */
    fun setTitleISBold(isBold: Boolean) :FinUpDialogBuilder {
        this.titleIsBold = isBold
        return this
    }

    /**
     * 텍스트 사이즈 설정
     * @param textSize Text size as SP
     */
    fun setTextSize(textSize: Float): FinUpDialogBuilder {
        this.textSize = textSize
        return this
    }

    /**
     * positiveButton 설정
     * @param text 버튼 텍스트
     * @listener 버튼 클릭 리스너 Null == dialog dismiss
     */
    fun positiveButton(text: String, listener:((content:View?) -> Unit)?) :FinUpDialogBuilder{
        if(listener == null){
            this.positiveButton = FinUpDialogButton(text,true,null)
        }else{
            this.positiveButton = FinUpDialogButton(text,true,listener)
        }
        return this
    }

    /**
     * positiveButton 설정
     * @param text 버튼 텍스트
     * @listener 버튼 클릭 리스너 Null == dialog dismiss
     */
    fun negativeButton(text: String, listener:((content:View?) -> Unit)?) :FinUpDialogBuilder {
        if(listener == null){
            this.negativeButton = FinUpDialogButton(text,true,null)
        }else{
            this.negativeButton = FinUpDialogButton(text,true,listener)
        }
        return this
    }

    /**
     * 포인트 컬러 셋상 변경
     * @param colorRes Drawable id of color. ex) R.color....
     */
    fun setPointColor(@ColorRes colorRes: Int) : FinUpDialogBuilder {
        this.pointColor = colorRes
        return this
    }



    /**
     * 대화 상자 외부를 터치하여 대화 상자를 닫고 싶지 않다면 false로 설정하십시오.
     * Default is true
     * @param enableCancel true --> cancelable, false --> not cancelable
     */
    fun enableCancel(enableCancel: Boolean) : FinUpDialogBuilder {
        this.enableCancel = enableCancel
        return this
    }
}