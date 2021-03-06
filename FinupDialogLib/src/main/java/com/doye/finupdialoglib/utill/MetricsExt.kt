package com.doye.finupdialoglib.utill

internal fun Int.toDP(): Int {
    return MetricsUtil.convertPixelsToDp(this.toFloat(), null).toInt()
}

internal fun Int.toPixel() : Int {
    return MetricsUtil.convertDpToPixel(this.toFloat(), null).toInt()
}