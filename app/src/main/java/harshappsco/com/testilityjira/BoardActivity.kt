package harshappsco.com.testilityjira

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Base64
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_board.*
import okhttp3.*
import java.io.IOException
import java.net.URL


class BoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)
        setSupportActionBar(my_toolbar)
        nav_bottom_board.menu.getItem(1).setChecked(true)
        nav_bottom_board.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_issue -> {
                    startActivity(Intent(this, MainActivity::class.java))
                }
                R.id.nav_board -> {

                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
        fetchBoardConfig()
       // configureTabLayout()
    }

    private fun configureTabLayout() {

        val adapter = TabPagerAdapter(supportFragmentManager, tab_layout.tabCount)
        viewpager_container.adapter = adapter
        // viewpager_container.addOnAdapterChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewpager_container.currentItem = tab.position
            }
        })

        viewpager_container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                tab_layout.getTabAt(position)?.select()
            }
        })
    }

    private fun fetchBoardConfig() {
        val urlString = "https://" + "jira.hm.com" + "/rest/agile/1.0/board"+"/940/configuration/"
        val url = URL(urlString)
        val auth = Base64.encodeToString(("tempharop" + ":" + "Start10").toByteArray(charset("UTF-8")), Base64.NO_WRAP)
        val headers = Headers.Builder()
                .set("Authorization", "Basic $auth")
                .set("X-Atlassian-Token", "no-check")
                .build()
        val request = Request.Builder()
                .url(url)
                .headers(headers)
                .build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                println("Request Failed")
            }

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                val body1 = "{\"id\":940,\"name\":\"hm.com - Mobile Scrum Board\",\"type\":\"scrum\",\"self\":\"https://jira.hm.com/rest/agile/1.0/board/940/configuration\",\"filter\":{\"id\":\"36258\",\"self\":\"https://jira.hm.com/rest/api/2/filter/36258\"},\"columnConfig\":{\"columns\":[{\"name\":\"To Do\",\"statuses\":[{\"id\":\"1\",\"self\":\"https://jira.hm.com/rest/api/2/status/1\"},{\"id\":\"4\",\"self\":\"https://jira.hm.com/rest/api/2/status/4\"},{\"id\":\"10050\",\"self\":\"https://jira.hm.com/rest/api/2/status/10050\"},{\"id\":\"10024\",\"self\":\"https://jira.hm.com/rest/api/2/status/10024\"},{\"id\":\"10016\",\"self\":\"https://jira.hm.com/rest/api/2/status/10016\"},{\"id\":\"10036\",\"self\":\"https://jira.hm.com/rest/api/2/status/10036\"}]},{\"name\":\"Development\",\"statuses\":[{\"id\":\"3\",\"self\":\"https://jira.hm.com/rest/api/2/status/3\"},{\"id\":\"10037\",\"self\":\"https://jira.hm.com/rest/api/2/status/10037\"}]},{\"name\":\"Code review\",\"statuses\":[{\"id\":\"10266\",\"self\":\"https://jira.hm.com/rest/api/2/status/10266\"},{\"id\":\"10057\",\"self\":\"https://jira.hm.com/rest/api/2/status/10057\"},{\"id\":\"10031\",\"self\":\"https://jira.hm.com/rest/api/2/status/10031\"}]},{\"name\":\"Ready for Test\",\"statuses\":[{\"id\":\"10015\",\"self\":\"https://jira.hm.com/rest/api/2/status/10015\"},{\"id\":\"10020\",\"self\":\"https://jira.hm.com/rest/api/2/status/10020\"},{\"id\":\"10007\",\"self\":\"https://jira.hm.com/rest/api/2/status/10007\"},{\"id\":\"10025\",\"self\":\"https://jira.hm.com/rest/api/2/status/10025\"},{\"id\":\"10021\",\"self\":\"https://jira.hm.com/rest/api/2/status/10021\"},{\"id\":\"10042\",\"self\":\"https://jira.hm.com/rest/api/2/status/10042\"},{\"id\":\"10041\",\"self\":\"https://jira.hm.com/rest/api/2/status/10041\"},{\"id\":\"10039\",\"self\":\"https://jira.hm.com/rest/api/2/status/10039\"}]},{\"name\":\"Being Tested\",\"statuses\":[{\"id\":\"10033\",\"self\":\"https://jira.hm.com/rest/api/2/status/10033\"},{\"id\":\"10040\",\"self\":\"https://jira.hm.com/rest/api/2/status/10040\"},{\"id\":\"10010\",\"self\":\"https://jira.hm.com/rest/api/2/status/10010\"}]},{\"name\":\"Ready for Acceptance test\",\"statuses\":[{\"id\":\"10366\",\"self\":\"https://jira.hm.com/rest/api/2/status/10366\"},{\"id\":\"10022\",\"self\":\"https://jira.hm.com/rest/api/2/status/10022\"},{\"id\":\"10004\",\"self\":\"https://jira.hm.com/rest/api/2/status/10004\"}]},{\"name\":\"Done\",\"statuses\":[{\"id\":\"5\",\"self\":\"https://jira.hm.com/rest/api/2/status/5\"},{\"id\":\"6\",\"self\":\"https://jira.hm.com/rest/api/2/status/6\"}]}],\"constraintType\":\"none\"},\"estimation\":{\"type\":\"field\",\"field\":{\"fieldId\":\"customfield_10093\",\"displayName\":\"Story Points\"}},\"ranking\":{\"rankCustomFieldId\":16870}}"
                val gson = GsonBuilder().create()

                val boardConfig = gson.fromJson(body1, BoardConfig::class.java)
                runOnUiThread {
                for (name in boardConfig.columnConfig.columns)
                    tab_layout.addTab(tab_layout.newTab().setText(name.name))
                    configureTabLayout()
                }
            }
        })
    }
}