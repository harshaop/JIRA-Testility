package harshappsco.com.testilityjira

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class BoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)
        setSupportActionBar(my_toolbar)

        nav_bottom.setOnNavigationItemSelectedListener{ item ->
            when(item.itemId){
                R.id.nav_issue ->   {
                    startActivity(Intent(this, MainActivity::class.java))
                }
                R.id.nav_board ->   {

                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}
