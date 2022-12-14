package com.serkanonder.diappetes.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.serkanonder.diappetes.R
import com.serkanonder.diappetes.login.LoginActivity

class OnBoardingActivity : AppCompatActivity() {


    private lateinit var onBoardingItemsAdapter: OnBoardingItemsAdapter
    private lateinit var indicatorsContainer: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        setOnboardingItems()
        setupIndicators()
        setCurrentIndicator(0)
    }

    private fun setOnboardingItems(){
        onBoardingItemsAdapter = OnBoardingItemsAdapter(
            listOf  (
                OnBoardingItem(
                    onBoardingImage = R.drawable.recent_values,
                    title = "Recent Values",
                    description = "See your recent values in a glance"
                ),
                OnBoardingItem(
                    onBoardingImage = R.drawable.medicine,
                    title = "Appoinment System",
                    description = "You can make appointments through the application and transfer your recorded values directly to your doctor."
                ),
                OnBoardingItem(
                    onBoardingImage = R.drawable.calculator,
                    title = "Calculator",
                    description = "Make your bolus calculation by using our calculator. Select your meal type and see the insulin unit you need."
                ),
                OnBoardingItem(
                    onBoardingImage = R.drawable.general_info,
                    title = "General Information",
                    description = "You can find general information about blood glucose measurments."
                )
            )
        )
        val onboardingViewPager = findViewById<ViewPager2>(R.id.onBoardingViewPager)
        onboardingViewPager.adapter = onBoardingItemsAdapter
        onboardingViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (onboardingViewPager.getChildAt(0) as? RecyclerView)?.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        findViewById<ImageView>(R.id.imageNext).setOnClickListener{
            if(onboardingViewPager.currentItem + 1 < onBoardingItemsAdapter.itemCount){
                onboardingViewPager.currentItem += 1
            }else{
                navigateToLoginActivity()
                }
            }
        findViewById<TextView>(R.id.textSkip).setOnClickListener{
            navigateToLoginActivity()
        }
        findViewById<MaterialButton>(R.id.buttonGetStarted).setOnClickListener{
            navigateToLoginActivity()
        }
    }
    private fun navigateToLoginActivity(){
        startActivity(Intent(applicationContext, LoginActivity::class.java))
        finish()
    }
    private fun setupIndicators(){
        indicatorsContainer = findViewById(R.id.indicatorsContainer)
        val indicators = arrayOfNulls<ImageView>(onBoardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams = layoutParams
                indicatorsContainer.addView(it)

            }
        }
    }
    private fun setCurrentIndicator(position: Int){
        val childCount = indicatorsContainer.childCount
        for (i in 0 until childCount){
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if(i == position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }
}