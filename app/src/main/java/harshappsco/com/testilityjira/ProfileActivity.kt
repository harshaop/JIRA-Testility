package harshappsco.com.testilityjira

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        nav_bottom_prof.menu.getItem(2).setChecked(true)

        nav_bottom_prof.setOnNavigationItemSelectedListener{ item ->
            when(item.itemId){
                R.id.nav_issue ->   {
                    startActivity(Intent(this, MainActivity::class.java))

                }
                R.id.nav_board ->   {
                    startActivity(Intent(this, BoardActivity::class.java))
                }
                R.id.nav_profile -> {
                    //Do Nothing
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}

