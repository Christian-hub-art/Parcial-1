package com.example.superheroes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Arranca Hilt; se registra en el Manifest con android:name=".BaseApplication"
@HiltAndroidApp
class BaseApplication : Application()
