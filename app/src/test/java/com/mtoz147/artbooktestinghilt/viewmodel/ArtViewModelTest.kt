package com.mtoz147.artbooktestinghilt.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.mtoz147.artbooktestinghilt.util.Status
import com.mtoz147.artbooktestinghilt.getOrAwaitValueTest
import com.mtoz147.artbooktestinghilt.repo.FakeArtRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArtViewModelTest {

    @get:Rule
    var instantTaskExecutorRule=InstantTaskExecutorRule()



    @get:Rule
    var mainCoroutineRule=MainCoroutineRule()

    private lateinit var viewModel: ArtViewModel

    @Before
    fun setup(){
        //Test Doubles

        viewModel= ArtViewModel(FakeArtRepository())
    }
    @Test
    fun `insert art without year returns error`(){
        viewModel.makeArt("Mona Lisa","Da Vinci", "")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
       assertThat(value.status).isEqualTo(Status.ERROR)

    }
    @Test
    fun `insert art without name returns error`(){
        viewModel.makeArt("","Da Vinci", "1900")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)
    }
    @Test
    fun `insert art without artistName returns error`(){
        viewModel.makeArt("Mona Lisa","", "1900")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)
    }
}