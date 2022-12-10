package com.serkanonder.diappetes

import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import com.serkanonder.diappetes.databinding.ActivityBluetoothMainBinding
import kotlinx.android.synthetic.main.activity_bluetooth_main.*

class BluetoothMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityBluetoothMainBinding

    private var bluetoothAdapter: BluetoothAdapter? = null
    private lateinit var pairedDevices: Set<BluetoothDevice>
    private val REQUEST_ENABLE_BLUETOOTH = 1
    companion object {
        var EXTRA_ADDRESS: String = "device_address"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBluetoothMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        if (bluetoothAdapter == null){
            Toast.makeText(this,"This device doesn't support Bluetooth", Toast.LENGTH_SHORT).show()
            return
        }
        binding.btnPairDevices.setOnClickListener{pairedDeviceList()}
    }
    @SuppressLint("MissingPermission")
    private fun pairedDeviceList(){
        pairedDevices = bluetoothAdapter!!.bondedDevices
        val list : ArrayList<BluetoothDevice> = ArrayList()
        if(!pairedDevices.isEmpty()){
            for(device: BluetoothDevice in pairedDevices){
                list.add(device)
                Toast.makeText(this,"Showing Paired Devices", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this,"No Paired Bluetooth Devices Found.", Toast.LENGTH_SHORT).show()
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        lwPairedList.adapter = adapter
        lwPairedList.onItemClickListener = AdapterView.OnItemClickListener(){_, _, position, _ ->
            val device: BluetoothDevice = list[position]
            val address: String = device.address
            val intent = Intent(this, RecevingDataActivity::class.java)
            intent.putExtra(EXTRA_ADDRESS, address)
            startActivity(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ENABLE_BLUETOOTH) {
            if (resultCode == Activity.RESULT_OK) {
                if (bluetoothAdapter!!.isEnabled) {
                    Toast.makeText(this, "Bluetooth has been enabled", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Bluetooth has been disabled", Toast.LENGTH_SHORT).show()
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Bluetooth enabling has been canceled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}