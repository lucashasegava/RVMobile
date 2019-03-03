package com.example.rvmobile.CarBuilder

import android.sax.Element
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.ArrayList

class BuilderViewPageAdapter internal constructor(
    fm: FragmentManager,
    list:ArrayList<Fragment>): FragmentPagerAdapter(fm){

    private val mFragmentList = list

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }


    fun addFragment(fragment: Fragment){
        mFragmentList.add(fragment)
    }

    fun removeFragment(fragment: Fragment){
        mFragmentList.remove(fragment)
    }


}