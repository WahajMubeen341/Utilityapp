package com.example.image_preview.utils

import android.content.Context
import androidx.compose.runtime.*
import kotlinx.coroutines.flow.collectLatest

@Composable
fun rememberNetworkStatus(context: Context): Boolean {
//    val monitor = remember { NetworkMonitor(context.applicationContext) }
//    var isConnected by remember { mutableStateOf(true) }
//
//    LaunchedEffect(Unit) {
//        monitor.isConnected.collectLatest {
//            isConnected = it
//        }
//    }
//
//    DisposableEffect(Unit) {
//        onDispose { monitor.unregister() }
//    }
//
//    return isConnected
    return true
}
