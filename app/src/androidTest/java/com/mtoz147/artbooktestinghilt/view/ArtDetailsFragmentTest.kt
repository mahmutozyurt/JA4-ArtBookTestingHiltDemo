package com.mtoz147.artbooktestinghilt.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth.assertThat
import com.mtoz147.artbooktestinghilt.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import javax.inject.Inject
import com.mtoz147.artbooktestinghilt.R
import com.mtoz147.artbooktestinghilt.getOrAwaitValue
import com.mtoz147.artbooktestinghilt.repo.FakeArtRepositoryTest
import com.mtoz147.artbooktestinghilt.roomdb.Art
import com.mtoz147.artbooktestinghilt.viewmodel.ArtViewModel
import org.mockito.Mockito.verify


@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class ArtDetailsFragmentTest {

    @get:Rule
    var hiltRule=HiltAndroidRule(this)

    @get:Rule
    val instantTaskExecutorRule=InstantTaskExecutorRule()

    @Inject
    lateinit var fragmentFactory: ArtFragmentFactory

    @Before
    fun setup(){
        hiltRule.inject()
    }

    @Test
    fun testNavigationFromArtDetailsToImageAPI(){
        val navController=Mockito.mock(NavController::class.java)

        launchFragmentInHiltContainer<ArtDetailsFragment>(
            factory = fragmentFactory
        ){
            Navigation.setViewNavController(requireView(),navController)
        }
        Espresso.onView(ViewMatchers.withId(R.id.artImageView)).perform(ViewActions.click())
        Mockito.verify(navController).navigate(
            ArtDetailsFragmentDirections.actionArtDetailsFragmentToImageApiFragment()
        )

    }
    @Test
    fun testOnBackPressed() {
        val navController = Mockito.mock(NavController::class.java)
        launchFragmentInHiltContainer<ArtDetailsFragment>(
            factory = fragmentFactory
        ) {
            Navigation.setViewNavController(requireView(),navController)
        }

        Espresso.pressBack()
        verify(navController).popBackStack()
    }

    @Test
    fun testSave() {
        val testViewModel = ArtViewModel(FakeArtRepositoryTest())
        launchFragmentInHiltContainer<ArtDetailsFragment>(
            factory = fragmentFactory
        ) {
            viewModel = testViewModel
        }

        onView(withId(R.id.nameText)).perform(replaceText("Mona Lisa"))
        onView(withId(R.id.artistText)).perform(replaceText("Da Vinci"))
        onView(withId(R.id.yearText)).perform(replaceText("1700"))
        onView(withId(R.id.btnSave)).perform(click())

        assertThat(testViewModel.artList.getOrAwaitValue()).contains(
            Art(
                "Mona Lisa",
                "Da Vinci",
                1700,"")
        )

    }

}