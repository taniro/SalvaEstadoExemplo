package tads.eaj.ufrn.salvaestadoexemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.salvaestadoexemplo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener {
            binding.apply {
                textView.text = editText.text.toString()
                editText.text.clear()
            }
        }

        if (savedInstanceState == null){
            Log.i("AULA", "Não havia estado")
        }else{
            Log.i("AULA", "Possui estado e o dado no bundle é ${savedInstanceState.getString("valor_textview")}")
        }

        Log.i("AULA", "OnCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.i("AULA", "OnStart()")

        val preferences = getSharedPreferences("MY_PREFS", MODE_PRIVATE)
        binding.textView.text = preferences.getString("dados_textview", "padrão")
    }

    override fun onResume() {
        super.onResume()
        Log.i("AULA", "OnResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("AULA", "OnPause()")

    }

    override fun onStop() {
        super.onStop()
        Log.i("AULA", "OnStop()")

        val preferences = getSharedPreferences("MY_PREFS", MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("dados_textview", binding.textView.text.toString())
        editor.apply()
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("AULA", "OnRestart()")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("AULA", "OnDestroy()")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.textView.text = savedInstanceState.getString("valor_textview")
        Log.i("AULA", "onRestoreInstanceState()")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("valor_textview", binding.textView.text.toString())
        Log.i("AULA", "onSaveInstanceState()")

    }
}