package harshappsco.com.testilityjira

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import harshappsco.com.testilityjira.BoardFragments.*

class TabPagerAdapter(fm: FragmentManager?, private val tabCount:Int) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment? {

        when(position){
            0 -> return FragmentTab1()
            1-> return FragmentTab2()
            2 -> return FragmentTab3()
            3 -> return FragmentTab4()
            4 -> return FragmentTab5()
            5 -> return FragmentTab6()
            6-> return FragmentTab7()
            //else -> return null
        }
        return null
    }

    override fun getCount(): Int {
        return tabCount
    }
}