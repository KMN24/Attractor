package kg.attractor.data.utils


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun <T> provideNetworkService(
    clazz: Class<T>,
): T = getRetrofit().create(clazz)

@Suppress("MayBeConstant")
private val currentUrl = BASE_URL

private var retrofit: Retrofit? = null

private fun getRetrofit() = retrofit ?: createRetrofit(currentUrl).also {
    retrofit = it
}

@Suppress("SameParameterValue")
private fun createRetrofit(
    baseUrl: String
): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(getOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

private fun getOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .setTimeout()
    .addInterceptor(getLoggingInterceptor())
    .build()


private fun OkHttpClient.Builder.setTimeout() = apply {
    readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
    connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
    writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
}

private fun getLoggingInterceptor() = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}