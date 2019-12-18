package com.example.mytestitunesnew.ui.interfaces

import androidx.fragment.app.Fragment

interface FragmentHandling {
    fun addFromFragment(fragment: Fragment, text : String)
    fun replaceFromFragment(fragment: Fragment)
}