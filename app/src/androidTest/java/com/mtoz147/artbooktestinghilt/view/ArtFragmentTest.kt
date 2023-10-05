package com.mtoz147.artbooktestinghilt.view

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.MediumTest
import com.mtoz147.artbooktestinghilt.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import javax.inject.Inject
import com.mtoz147.artbooktestinghilt.R
import kotlinx.coroutines.ExperimentalCoroutinesApi


@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class ArtFragmentTest {
    @get:Rule
    var hiltRule=HiltAndroidRule(this)

    @Inject
    lateinit var fragmentFactory: ArtFragmentFactory

    @Before
    fun setup(){
        hiltRule.inject()
    }
    @Test
    fun testNavigationFromArtToArtDetails(){
        val navController=Mockito.mock(NavController::class.java)

        launchFragmentInHiltContainer<ArtFragment>(
            factory = fragmentFactory
        ){
            Navigation.setViewNavController(requireView(),navController)
        }
        Espresso.onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click())
        Mockito.verify(navController).navigate(
            ArtFragmentDirections.actionArtFragmentToArtDetailsFragment()
        )
    }

}