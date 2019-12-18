package com.example.mytestitunesnew.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mytestitunesnew.R
import com.example.mytestitunesnew.ui.fragment.SongFragment
import com.example.mytestitunesnew.ui.interfaces.FragmentHandling
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), FragmentHandling {

    private var fragmentsong: SongFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            fragmentsong = SongFragment.newInstance()
            addFragment(fragmentsong!!, "Song")



    }

    override fun addFromFragment(fragment: Fragment, text: String) {
        addFragmentToBackStack(fragment, text)
    }

    override fun replaceFromFragment(fragment: Fragment) {
        replaceFragment(fragment)
    }
    private fun replaceFragment(fragment: Fragment) {
//        fm.beginTransaction().hide(active).show(fragment).commit()
//        active = fragment
    }
}
