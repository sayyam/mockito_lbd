package com.tribalscale.mockitolbd.test_03

import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import java.util.*


/**
 * Created by Sayyam on 2018-09-03.
 */
class ArgumentMatcher {

    var mockedListAnySize = Mockito.mock(LinkedList::class.java)
    var mockedListSingleItem = Mockito.mock(LinkedList::class.java)

    @Test
    fun verifyAnyArgumentTest() {

        `when`(mockedListAnySize[anyInt()]).thenReturn("any")

        //following prints "any"
        print(mockedListAnySize[999])

        //you can also verify using an argument matcher
        verify(mockedListAnySize)[anyInt()]

    }

    @Test
    fun verifyMatchedArgumentTest() {

        `when`(mockedListSingleItem[0]).thenReturn("0")

        //following prints "any"
        print(mockedListSingleItem[0])

        //you can also verify using an argument matcher
        verify(mockedListSingleItem)[0]

    }
}