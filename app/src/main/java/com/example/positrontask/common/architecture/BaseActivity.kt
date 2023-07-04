package com.example.positrontask.common.architecture

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.positrontask.R
import com.example.positrontask.app.App
import com.example.positrontask.data.di.DataComponent


open class BaseActivity : AppCompatActivity() {
    val app: App by lazy {
        application as App
    }
    private var once: Boolean = false

    val component: DataComponent by lazy {
        app.dataComponent
    }

    private val appPermissions = arrayOf(
        Manifest.permission.INTERNET,
        Manifest.permission.ACCESS_NETWORK_STATE
    )

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { }
    override fun onResume() {
        super.onResume()

        checkPermissions()
        if (!once) {
            onceOnResume()
            once = true
        }
    }
    private fun checkPermissions() {
        appPermissions.map {
            val isGranted = ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
            it to isGranted
        }.filterNot { it.second }.map { it.first }.let { permissions ->
            println("PSG $permissions")
            if (permissions.isNotEmpty()) AlertDialog.Builder(this)
                .setTitle(R.string.permissionsAlertTitle)
                .setMessage(R.string.permissionsText)
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    requestPermissions(permissions)
                }
                .setNegativeButton(android.R.string.cancel) { _, _ ->
                    finish()
                }
                .create().show()
        }
    }

    private fun requestPermissions(permissions: List<String>) {
        requestPermissionLauncher.launch(permissions.toTypedArray())
    }

    open fun onceOnResume() {}

}