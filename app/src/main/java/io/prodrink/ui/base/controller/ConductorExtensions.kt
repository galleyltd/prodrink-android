package io.prodrink.ui.base.controller

import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Build
import android.support.v4.content.ContextCompat
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router

fun Router.popControllerWithTag(tag: String): Boolean {
    val controller = getControllerWithTag(tag)
    if (controller != null) {
        popController(controller)
        return true
    }
    return false
}

fun Controller.requestPermissionsSafe(permissions: Array<String>, requestCode: Int) {
    val activity = activity ?: return
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        permissions.forEach { permission ->
            if (ContextCompat.checkSelfPermission(activity, permission) != PERMISSION_GRANTED) {
                requestPermissions(arrayOf(permission), requestCode)
            }
        }
    }
}