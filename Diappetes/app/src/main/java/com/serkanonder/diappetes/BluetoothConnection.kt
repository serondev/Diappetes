package com.serkanonder.diappetes
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.widget.Toast
import java.io.IOException
import java.util.*

class BluetoothConnection {
    private val bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
    private var bluetoothSocket: BluetoothSocket? = null
    private var bluetoothDevice: BluetoothDevice? = null


    fun connect(deviceAddress: String) {
        bluetoothDevice = bluetoothAdapter.getRemoteDevice(deviceAddress)

        try {
            bluetoothSocket = bluetoothDevice!!.createInsecureRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"))
            bluetoothSocket!!.connect()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun disconnect() {
        try {
            bluetoothSocket!!.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    fun readData(){
        val inputStream = bluetoothSocket!!.inputStream
        val buffer = ByteArray(1024)
        val bytes = inputStream.read(buffer)
        val readMessage = String(buffer, 0, bytes)
        println(readMessage)
    }
}