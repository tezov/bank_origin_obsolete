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

package com.tezov.lib_core_kotlin.extension

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred

object ExtensionCompletable {

    fun <T> CompletableDeferred<T>.notifyComplete(value: T) {
        complete(value)
    }

    fun CompletableDeferred<Unit>.notifyComplete() {
        complete(Unit)
    }

    fun CompletableDeferred<*>.notifyException(e: Throwable) {
        completeExceptionally(e)
    }

    inline fun <T, D : Deferred<T>> D.onComplete(
        crossinline succeed: (T) -> Unit,
        crossinline failed: (Throwable) -> Unit
    ) {
        this.invokeOnCompletion {
            it?.let {
                failed.invoke(it)
            } ?: let {
                succeed.invoke(getCompleted())
            }
        }
    }

    fun <T, D : Deferred<T>> D.onComplete(succeed: (T) -> Unit) {
        this.invokeOnCompletion {
            succeed.invoke(getCompleted())
        }
    }

    fun <T> notifyComplete(t: T): CompletableDeferred<T> {
        val deferred: CompletableDeferred<T> = CompletableDeferred()
        deferred.notifyComplete(t)
        return deferred
    }

    fun notifyComplete(): CompletableDeferred<Unit> {
        val deferred: CompletableDeferred<Unit> = CompletableDeferred()
        deferred.notifyComplete(Unit)
        return deferred
    }

    fun <T> notifyException(e: Exception): CompletableDeferred<T> {
        val deferred: CompletableDeferred<T> = CompletableDeferred()
        deferred.notifyException(e)
        return deferred
    }

}