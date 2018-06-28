package harshappsco.com.testilityjira

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabPagerAdapter(fm: FragmentManager?, val tabCount:Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return FragmentTab1()
            1-> return FragmentTab2()
            2 -> return FragmentTab3()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}