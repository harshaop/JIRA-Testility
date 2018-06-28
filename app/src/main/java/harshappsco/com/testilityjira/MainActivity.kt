package harshappsco.com.testilityjira

import android.app.PendingIntent.getActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.widget.LinearLayoutManager

import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.view.*
import kotlinx.android.synthetic.main.fragment_tab1.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureTabLayout()
    }

     private fun configureTabLayout() {
        tab_layout.addTab(tab_layout.newTab().setText("Issues"))
        tab_layout.addTab(tab_layout.newTab().setText("Board"))
        tab_layout.addTab(tab_layout.newTab().setText("Profile"))

        val adapter = TabPagerAdapter(supportFragmentManager, tab_layout.tabCount)
        pager.adapter = adapter
        pager.addOnAdapterChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }

        })
    }




}
