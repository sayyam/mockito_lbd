package com.tribalscale.mockitolbd.test_04

import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import java.util.*

/**
 * Created by Sayyam on 2018-09-03.
 */
class CountInvocations {

    @Mock
    lateinit var mockedList: ArrayList<Any>

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun exactOneInvocationTest() {

        mockedList.add("one")

        verify(mockedList, times(1)).add("one")
        verify(mockedList, times(1)).add(ArgumentMatchers.anyString())
    }

    @Test
    fun atLeastOneInvocationTest() {

        mockedList.add("one")
        mockedList.add("two")

        verify(mockedList, atLeast(1)).add(ArgumentMatchers.anyString())
    }

    @Test
    fun atMostTwoInvocationTest() {

        mockedList.add("one")
        mockedList.add("two")
        mockedList.add("three")

        verify(mockedList, atMost(3)).add(ArgumentMatchers.anyString())
    }

    @Test
    fun neverInvokedTest() {

        mockedList.add("one")
        mockedList.add("two")

        verify(mockedList, never()).remove(ArgumentMatchers.anyString())
    }


}