package com.example.shopping.util

//Context: needed to locate your app’s internal data directory.
//File: for navigating the filesystem.
//Properties: Java class that holds key–value pairs (like a .properties file).
import android.content.Context
import java.io.File
import java.util.Properties


object LocalProps {
    fun load(context: Context): Properties {
        val props = Properties()
        try {
            context.assets.open("stripe.properties").use { inputStream ->
                props.load(inputStream)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return props
    }
}


//object LocalProps {
//    fun load(context: Context): Properties {
//        val props = Properties() //empty Properties object to hold the loaded values.
//        try {
//            // Go 2 levels up from /data/data/... to find project root
//            val file = File(context.applicationInfo.dataDir)
//                .parentFile?.parentFile
//                ?.resolve("local.properties")
//
//            if (file != null && file.exists()) {
//                props.load(file.inputStream())
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//        return props
//    }
//}
//


























