package com.cyanandroid.permission

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cyanandroid.permission_library.PermissionCallBack
import com.cyanandroid.permission_library.runWithPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAskPermission.setOnClickListener {
            runWithPermission(PermissionCallBack {


                withPermission {
                    //permission granted, do permission related stuff
                }
                onCancel {
                    //cancel by user
                }
                onPartiallyGranted { grantedPermission, deniedPermission ->
                    //partially permission granted
                }
                onPermissionDenied {
                    //permission denied
                }
                onPermissionsArePermanentlyDenied {
                    // permission denied
                }
                onShowRational {
                    //need to show rational
                }


            }, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
    }
}
