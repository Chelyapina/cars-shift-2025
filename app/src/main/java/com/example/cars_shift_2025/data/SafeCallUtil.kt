package com.example.cars_shift_2025.data

import java.io.IOException

inline fun <T , R> safeCall(
    request : () -> T ,
    isSuccess : (T) -> Boolean ,
    onSuccess : (T) -> R
) : Result<R> = try {
    val response = request()
    if (!isSuccess(response)) {
        Result.failure(Exception("Ошибка сервера"))
    } else {
        Result.success(onSuccess(response))
    }
} catch (e : IOException) {
    Result.failure(Exception("Ошибка сети"))
} catch (e : Exception) {
    Result.failure(Exception("Неизвестная ошибка"))
}