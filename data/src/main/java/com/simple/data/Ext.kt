package com.simple.data

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import kotlinx.serialization.*
import kotlinx.serialization.json.Json

/**
 * Created by Rim Gazzah on 8/19/20.
 **/

fun SharedPreferences.edit(
    action: SharedPreferences.Editor.() -> Unit
) {
    val editor = edit()
    action(editor)
    editor.apply()
}

fun Context.sp(): SharedPreferences =
    getSharedPreferences(packageName, Context.MODE_PRIVATE)

fun Activity.sp(): SharedPreferences =
    getSharedPreferences(packageName, Context.MODE_PRIVATE)

fun Context.clearPrefs() {sp().edit { clear() }}

/**
 * Set a [T] value in the preferences editor, to be written back once
 * apply() are called.
 *
 * @param key The name of the preference to modify
 * @param value The new value for the preference
 * @param name Desired preferences file. Default value is the packageName
 */
inline fun <reified T> Context.putSpValue(key: String, value: T) = sp().edit {
    when (value) {
        is Long -> putLong(key, value)
        is String -> putString(key, value)
        is Int -> putInt(key, value)
        is Boolean -> putBoolean(key, value)
        is Float -> putFloat(key, value)
        else -> putString(key, serializeObject(value))
    }
}

inline fun <reified T> serializeObject(value: T): String {
    return Json.encodeToString(value)
}

inline fun <reified T> deserializeObject(string: String): T {
    return Json.decodeFromString(string)
}

