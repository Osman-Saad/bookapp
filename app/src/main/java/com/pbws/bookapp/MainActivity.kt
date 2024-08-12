package com.pbws.bookapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pbws.bookapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()
        setAppBarIconClicked()
        openDrawer()
        setNavigationDrawerItemClicked()

    }

    private fun openDrawer() {
        binding.appbarLayout.topAppBar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }
    }

    private fun setNavigationDrawerItemClicked() {
        binding.navigationDrawer.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.review -> {
                    showToast(getString(R.string.review_clicked))
                }
                R.id.favorite -> {
                    showToast(getString(R.string.favorite_clicked))                }
                R.id.search -> {
                    showToast(getString(R.string.search_clicked))
                }
                R.id.profile -> {
                    showToast(getString(R.string.profile_clicked))
                }
                R.id.setting -> {
                    showToast(getString(R.string.setting_clicked))
                }
            }
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        binding.drawerLayout.close()
    }

    private fun setAdapter(){
        val adapter = BookAdapter(BOOK_LIST)
        binding.bookRecyclerview.adapter = adapter
    }

    private fun setAppBarIconClicked(){
        binding.appbarLayout.topAppBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.notification -> {
                    showToast(getString(R.string.notification_clicked))
                }
            }
            true
        }
    }

}