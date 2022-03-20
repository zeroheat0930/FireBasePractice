package com.zeroheat.firebasepractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.zeroheat.firebasepractice.fragment.ChatFragment
import com.zeroheat.firebasepractice.fragment.HomeFragment
import com.zeroheat.firebasepractice.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    lateinit var binding: com.zeroheat.firebasepractice.databinding.ActivityMainBinding


    lateinit var auth: FirebaseAuth
    lateinit var homeFragment : HomeFragment
    lateinit var chatFragment: ChatFragment
    lateinit var profileFragment: ProfileFragment


   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        auth = Firebase.auth


       bottom_nav.setOnNavigationItemSelectedListener(BottomNavItemSelectedListener)

       homeFragment = HomeFragment.newInstance()
       supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()

   }
    private val BottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{
        when(it.itemId){
            R.id.menu_home -> {
                homeFragment = HomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
            }
            R.id.menu_chat -> {
                chatFragment = ChatFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, chatFragment).commit()
            }
            R.id.menu_profile -> {
                profileFragment = ProfileFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, profileFragment).commit()
            }
        }
        true
    }


}