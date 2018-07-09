package harshappsco.com.testilityjira

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabPagerAdapter(fm: FragmentManager?, private val tabCount:Int) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment? {

        when(position){
            0 -> return FragmentTab1()
            1-> return FragmentTab2()
            2 -> return FragmentTab3()
            3 -> return FragmentTab1()
            4 -> return  FragmentTab2()
            5 -> return  FragmentTab3()
            6-> return  FragmentTab1()
            //else -> return null
        }
        return null
    }

    override fun getCount(): Int {
        return tabCount
    }
}