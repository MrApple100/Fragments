package ru.mrapple100.fragments1212

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import ru.mrapple100.fragments1212.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , CreateListFragment.IChangeRVList{

    var state:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this,R.layout.activity_main)
        setContentView(binding.root)

        val fragment = BlankFragment2()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.FrameLayout,fragment)
            .commit()

        binding.Button.setOnClickListener{
            when(state){
                0 ->{
                    //supportFragmentManager - управление фрагментами
                    val fragment = BlankFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.FrameLayout,fragment)
                        .commit()
                }
                1 ->{
                    val fragment = BlankFragment2.newInstance("Math",5)
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.FrameLayout,fragment)
                        .commit()
                }
                2 ->{
                    val fragment = SettingsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.FrameLayout,fragment)
                        .commit()

                }
                else ->{

                }
            }
            state = (state + 1) % 3// 0 1 2
        }


    }

    override fun changeList(string: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.FrameRV,RVFragment.newInstance(string))
            .commit()
    }
}