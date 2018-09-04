package com.tribalscale.mockitolbd.test_02

import org.junit.Test
import org.mockito.Mockito.*
import java.util.*

/**
 * Created by Sayyam on 2018-09-03.
 */
class Stubbing {

    var mockedList = mock(LinkedList::class.java)

    @Test
    fun verifyGetStub() {

        //stubbing mockedListAnySize for get(0) to return string first
        `when`(mockedList[0]).thenReturn("first")

        //following prints "first"
        print(mockedList[0])


        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList)[0]

    }



}