package com.doye.finupdialoglib

import android.view.View

internal data class FinUpDialogButton(
    val text: String,
    val canDismiss: Boolean,
    val listener: ((content: View?) -> Unit)?
)
