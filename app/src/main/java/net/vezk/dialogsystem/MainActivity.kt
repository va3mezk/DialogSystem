package net.vezk.dialogsystem


import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import net.vezk.dialogsystem.databinding.AceptDialogBinding
import net.vezk.dialogsystem.databinding.ActivityMainBinding
import net.vezk.dialogsystem.databinding.FailDialogBinding
import net.vezk.dialogsystem.databinding.WarningDialogBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var _binding_custom: WarningDialogBinding? = null
    private var _binding_acept: AceptDialogBinding? = null
    private var _binding_fail: FailDialogBinding? = null
    private val binding_custom get() = _binding_custom!!
    private val binding_acept get() = _binding_acept!!
    private val binding_fail get() = _binding_fail!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bvCuidado.setOnClickListener { showDialogWarning()}
        binding.bvAcept.setOnClickListener { showDialogAcept() }
        binding.bvFail.setOnClickListener { showDialogFail() }
    }

    private fun showDialogWarning() {
        _binding_custom = WarningDialogBinding.inflate(LayoutInflater.from(this))
        val customDialog = AlertDialog.Builder(this).setView(binding_custom.root).create()
        customDialog.apply {
            setView(_binding_custom?.root)
            setCancelable(false)
        }.show()
        _binding_custom?.apply {
            bvCancel.setOnClickListener  {customDialog.dismiss()}
            bvExit.setOnClickListener{ customDialog.dismiss() }
        }
    }
    private fun showDialogAcept() {
        _binding_acept = AceptDialogBinding.inflate(LayoutInflater.from(this))
        val customDialog = AlertDialog.Builder(this).setView(binding_acept.root).create()
        customDialog.apply {
            setView(_binding_acept?.root)
            setCancelable(false)
        }.show()
        _binding_acept?.apply {
            bvExit.setOnClickListener{ customDialog.dismiss()}
            bvAcept.setOnClickListener{customDialog.dismiss()}
        }
    }
    private fun showDialogFail() {
        _binding_fail = FailDialogBinding.inflate(LayoutInflater.from(this))
        val customDialog = AlertDialog.Builder(this).setView(binding_fail.root).create()
        customDialog.apply {
            setView(_binding_fail?.root)
            setCancelable(false)
        }.show()
        _binding_fail?.apply {
            bvExit.setOnClickListener{ customDialog.dismiss()}
        }
    }
}