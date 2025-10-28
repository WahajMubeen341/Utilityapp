package com.example.image_preview.utils


import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.widget.Toast

object NetworkMonitor {

    private var connectivityManager: ConnectivityManager? = null
    private var isConnected: Boolean = false

    fun startMonitoring(context: Context) {
        connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        isConnected = isCurrentlyConnected(context)

        connectivityManager?.registerNetworkCallback(
            request,
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    if (!isConnected) {
                        isConnected = true
                        Toast.makeText(context, "Back online 🌐", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onLost(network: Network) {
                    if (isConnected) {
                        isConnected = false
                        Toast.makeText(context, "No internet connection 🚫", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        )
    }

    private fun isCurrentlyConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetwork ?: return false
        val capabilities = cm.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    fun stopMonitoring() {
        connectivityManager?.unregisterNetworkCallback(ConnectivityManager.NetworkCallback())
        connectivityManager = null
    }
}
