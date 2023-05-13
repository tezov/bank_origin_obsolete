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

package com.tezov.lib_core_kotlin.cipher

import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.*
import javax.crypto.*

object SecureProvider {
    val ANDROID: String? = null
    const val BOUNCY_CASTLE = "BC"
    const val DEFAULT_SECURE_RANDOM_ALGO = "SHA1PRNG"
    private var provider = ANDROID

    fun init(provider: String) {
        if (BOUNCY_CASTLE == provider) {
            Security.removeProvider(BOUNCY_CASTLE)
            Security.insertProviderAt(BouncyCastleProvider(), 1)
        }
        SecureProvider.provider = provider
    }

    @Throws(NoSuchAlgorithmException::class)
    fun randomGenerator(algo: String = DEFAULT_SECURE_RANDOM_ALGO) = SecureRandom.getInstance(algo)

    @Throws(NoSuchAlgorithmException::class, NoSuchProviderException::class)
    fun keyFactory(algo: String) = provider?.let { SecretKeyFactory.getInstance(algo, it) }
        ?: let { SecretKeyFactory.getInstance(algo) }


    @Throws(NoSuchAlgorithmException::class, NoSuchProviderException::class)
    fun keyPairFactory(algo: String) = provider?.let { KeyFactory.getInstance(algo, it) }
        ?: let { KeyFactory.getInstance(algo) }


    @Throws(NoSuchAlgorithmException::class, NoSuchProviderException::class)
    fun keyPairGenerator(algo: String) = provider?.let { KeyPairGenerator.getInstance(algo, it) }
        ?: let { KeyPairGenerator.getInstance(algo) }

    @Throws(NoSuchAlgorithmException::class, NoSuchProviderException::class)
    fun keyAgreement(algo: String) = provider?.let { KeyAgreement.getInstance(algo, it) }
        ?: let { KeyAgreement.getInstance(algo) }

    @Throws(
        NoSuchPaddingException::class,
        NoSuchAlgorithmException::class,
        NoSuchProviderException::class
    )
    fun cipher(algo: String) = provider?.let { Cipher.getInstance(algo, it) }
        ?: let { Cipher.getInstance(algo) }

    @Throws(NoSuchAlgorithmException::class, NoSuchProviderException::class)
    fun mac(algo: String) = provider?.let { Mac.getInstance(algo, it) }
        ?: let { Mac.getInstance(algo) }


    @Throws(NoSuchAlgorithmException::class, NoSuchProviderException::class)
    fun messageDigest(algo: String) = provider?.let { MessageDigest.getInstance(algo, it) }
        ?: let { MessageDigest.getInstance(algo) }

}