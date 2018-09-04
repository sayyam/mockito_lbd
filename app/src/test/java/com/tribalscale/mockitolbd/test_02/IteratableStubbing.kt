package com.tribalscale.mockitolbd.test_02

import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import java.util.*

/**
 * Created by Sayyam on 2018-09-03.
 */
class IteratableStubbing {

    var mockedList = Mockito.mock(LinkedList::class.java)

    @Test
    fun verifyIterateablStub() {

        `when`(mockedList[ArgumentMatchers.anyInt()])
                .thenReturn("one", "two", "three")

        System.out.println(mockedList[0])
        System.out.println(mockedList[0])
        System.out.println(mockedList[0])

    }
}