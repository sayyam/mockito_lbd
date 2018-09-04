package com.tribalscale.mockitolbd.test_01

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by Sayyam on 2018-09-03.
 *
 * This class utilizes kotlin ArrayList add() method to verify behaviour,
 * because most people are familiar with the interface (such as the add(), get(), clear() methods).
 * In reality, please don't mock the List class. Use a real instance instead.
 */
class BehaviourVerification {

    @Mock
    lateinit var mockedList: ArrayList<Any>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun verifyAdd() {

        //using mock object
        mockedList.add("one")

        //verification
        verify(mockedList).add("one")
    }

}