package com.example.farhikhtegan.controller


import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.farhikhtegan.databinding.ActivityMainBinding
import android.view.Menu
import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.res.Configuration
import android.os.Build
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.menu.MenuBuilder
import com.example.farhikhtegan.Adapter.SpinnerLanguageAdapter
import com.example.farhikhtegan.R
import com.example.farhikhtegan.services.DataSource
import java.util.*
import android.net.Uri

import android.content.Intent




private lateinit var binding: ActivityMainBinding
private lateinit var adapterLanguage: SpinnerLanguageAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
/************************************************/
   //  loadLocale()
/*************************************************/
        binding.fab.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "05147242211"))
            startActivity(intent)
        }
/************************************************/
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
/**************************************************/
        val list_Language= DataSource()
        adapterLanguage = SpinnerLanguageAdapter(this, list_Language.Setting_language)
        binding.spinnerSettingLanguage.adapter = adapterLanguage
        binding.spinnerSettingLanguage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long) {

                var itemselected = parent?.getItemAtPosition(position).toString()
                if(itemselected =="فارسی"){
                    setLocate("fa",binding.spinnerSettingLanguage.selectedItemPosition )
                }
                else if(itemselected =="English"){
                    setLocate("en" ,binding.spinnerSettingLanguage.selectedItemPosition)
                }


            }

        }
/************************************************/
        val navView: BottomNavigationView = binding.navView
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main)
//        val appBarConfiguration =AppBarConfiguration(
//            setOf(
//                R.id.homeFragment,R.id.acuuntingFragment,R.id.computerFragment,R.id.kidFragment
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)
        binding.navView.background = null
        binding.navView.menu.getItem(2).isEnabled = false


/********************************************************/
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation_draw_menu, menu)

        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        return true
    }
/************************************************/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.language_setting -> {

                val dialog = AlertDialog.Builder(this)
                val layoutDialog =
                    layoutInflater.inflate(R.layout.custom_dialog_setting_language, null)



                dialog.setView(layoutDialog)
                dialog.setCancelable(false)

                dialog.setPositiveButton(resources.getString(R.string.ok)) { _: DialogInterface, _: Int -> }


                val customDialog = dialog.create()
                customDialog.show()

                customDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                    loadLocale()
                    customDialog.dismiss()


                }

                customDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener {
                    customDialog.dismiss()
                }
            }

        }
        return true
    }
/************************************************/
    private fun setLocate(item: String,selectedItem:Int) {

        val locale = Locale(item)
        Locale.setDefault(locale)
        val configuration = Configuration()

        configuration.setLocale(locale)

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            applicationContext.createConfigurationContext(configuration)
        } else {
            resources.updateConfiguration(configuration, baseContext.resources.displayMetrics)
        }


        val editor = getSharedPreferences("setting", Context.MODE_PRIVATE).edit()
          editor.putInt("Language", selectedItem)

        editor.apply()
    }
    /************************************************/
    private fun loadLocale() {
        val sharedPreferences = getSharedPreferences("setting", 0)
        if (sharedPreferences.contains("Language")) {
            val language :Int= sharedPreferences.getInt("Language", 0)
           // Toast.makeText(this,language.toString(),Toast.LENGTH_SHORT).show()
            if(language==0){
                setLocate("fa",0)
            }
            else{
                setLocate("en",1)
            }
            binding.spinnerSettingLanguage.setSelection(sharedPreferences.getInt("Language",0));



        }
    }
    /************************************************/

}