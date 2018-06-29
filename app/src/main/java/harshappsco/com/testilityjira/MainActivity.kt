package harshappsco.com.testilityjira

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.Menu

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import harshappsco.com.testilityjira.R.id.pager
import harshappsco.com.testilityjira.R.id.tab_layout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)
        setSupportActionBar(my_toolbar)

        setFragment(FragmentTab1())
        nav_bottom.setOnNavigationItemSelectedListener{ item ->
            when(item.itemId){
                R.id.nav_issue ->   {setFragment(FragmentTab1())}
                R.id.nav_board ->   {setFragment(FragmentTab2())}
                R.id.nav_profile -> {setFragment(FragmentTab3())}
            }
            return@setOnNavigationItemSelectedListener true
        }
     //   configureTabLayout()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_toolbar, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search)?.actionView as android.support.v7.widget.SearchView
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(componentName))

        return true
    }

    override fun onSearchRequested(): Boolean {

        return super.onSearchRequested()
    }

    private fun setFragment(frag: android.support.v4.app.Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.main_frame, frag).commit()
    }


    class SearchResultsActivity:Activity(){
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            handleIntent(intent);
        }

        override fun onNewIntent(intent: Intent) {
            super.onNewIntent(intent)
            handleIntent(intent);
        }

        private fun handleIntent(intent: Intent){
            if (Intent.ACTION_SEARCH == intent.action) {
                val query = intent.getStringExtra(SearchManager.QUERY)
                //use the query to search your data somehow
            }
        }
    }

    private fun configureTabLayout() {
        tab_layout.addTab(tab_layout.newTab().setText("Issues"))
        tab_layout.addTab(tab_layout.newTab().setText("Board"))
        tab_layout.addTab(tab_layout.newTab().setText("Profile"))

        val adapter = TabPagerAdapter(supportFragmentManager, tab_layout.tabCount)
        pager.adapter = adapter
      //  pager.addOnAdapterChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

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

