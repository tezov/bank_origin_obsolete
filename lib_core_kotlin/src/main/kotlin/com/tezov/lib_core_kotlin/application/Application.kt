/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

package com.tezov.lib_core_kotlin.application

import androidx.core.os.ConfigurationCompat
import androidx.multidex.MultiDexApplication
import com.jakewharton.threetenabp.AndroidThreeTen
import com.tezov.lib_core_java.util.Clock
import java.util.*

open class Application : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        val local: Locale = ConfigurationCompat.getLocales(resources.configuration)[0]!!
        Clock.FormatDate.init(local)
    }
}