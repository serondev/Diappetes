package com.serkanonder.diappetes

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.loader.content.AsyncTaskLoader
import com.serkanonder.diappetes.RecevingDataActivity.Companion.MY_UUID
import com.serkanonder.diappetes.RecevingDataActivity.Companion.address
import com.serkanonder.diappetes.RecevingDataActivity.Companion.bluetoothAdapter
import com.serkanonder.diappetes.RecevingDataActivity.Companion.bluetoothSocket
import com.serkanonder.diappetes.RecevingDataActivity.Companion.isBluetoothConnected
import com.serkanonder.diappetes.RecevingDataActivity.Companion.progressDialog
import com.serkanonder.diappetes.databinding.ActivityRecevingDataBinding
import kotlinx.android.synthetic.main.activity_receving_data.*
import java.io.IOException
import java.util.*

class RecevingDataActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecevingDataBinding
    companion object {
        var MY_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
        var TAG : String = "BluetoothControl"
        var isBluetoothConnected: Boolean = false
        lateinit var progressDialog: ProgressDialog
        lateinit var bluetoothAdapter: BluetoothAdapter
        var bluetoothSocket: BluetoothSocket? = null
        lateinit var address: String

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecevingDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        BTConnectAsync(this).execute()
        binding.btnGetData.setOnClickListener{
            try {
                getData()
            }catch (IO: Exception){
                IO.printStackTrace()
                tvReceiveddata.text = "Error"
            }
        }
    }
}
    private fun getData(){
        var msg = "1"
        msg += "\n"
        bluetoothSocket!!.outputStream.write(msg.toString().toByteArray())
    }
    private fun beginListenForData(){
        val handler = Handler()
        val stopworker = false
        val delimeter: Byte = 10
        var readBufferPosition : Int = 0
        var readBuffer = ByteArray(1024)
        var workerThread = Thread(Runnable {
            while (!Thread.currentThread().isInterrupted && !stopworker){
                try {
                    val bytesAvailable = bluetoothSocket!!.inputStream.available()
                    if (bytesAvailable > 0){
                        val packetBytes = ByteArray(bytesAvailable)
                        bluetoothSocket!!.inputStream.read(packetBytes)
                        for (i in 0 until bytesAvailable){
                            val b = packetBytes[i]
                            if (b == delimeter){
                                val encodedBytes = ByteArray(readBufferPosition)
                                System.arraycopy(readBuffer, 0, encodedBytes, 0, encodedBytes.size)
                                val data = String(encodedBytes, Charsets.US_ASCII)
                                readBufferPosition = 0
                                handler.post(Runnable {
                                })
                            }else{
                                readBuffer[readBufferPosition++] = b
                            }
                        }
                    }
                }catch (IO: IOException){
                    IO.printStackTrace()
                    Thread.currentThread().interrupt()
                }
            }
        })
        workerThread.start()
}
private class BTConnectAsync(c: Context) : AsyncTask<Void, Void, Void>(){
    private var ConnectSuccess: Boolean = true
    private val context: Context
    init {
        this.context = c
    }
    override fun onPreExecute() {
        super.onPreExecute()
        progressDialog = ProgressDialog.show(context, "Connecting...", "please wait")
    }

    @SuppressLint("MissingPermission")
    override fun doInBackground(vararg p0: Void?): Void {
        try {
            if (bluetoothSocket == null || !isBluetoothConnected){
                bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
                val device = bluetoothAdapter.getRemoteDevice(address)
                bluetoothSocket = device.createInsecureRfcommSocketToServiceRecord(MY_UUID)
                BluetoothAdapter.getDefaultAdapter().cancelDiscovery()
                bluetoothSocket!!.connect()
            }
        }catch (e: IOException){
            ConnectSuccess = false
            e.printStackTrace()
        }
        return null!!
    }
    override fun onPostExecute(aVoid: Void?) {
        super.onPostExecute(aVoid)
        if (!ConnectSuccess){

        }else{
            isBluetoothConnected = true

            beginListenForData()
        }
        progressDialog.dismiss()
    }


}


