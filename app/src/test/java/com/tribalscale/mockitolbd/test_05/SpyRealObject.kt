package com.tribalscale.mockitolbd.test_05

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

/**
 * Created by Sayyam on 2018-09-03.
 */
class SpyRealObject {

    //Defining real ArrayList to spy on
    lateinit var realArrayList: ArrayList<String>

    @Before
    fun setup() {
        realArrayList = arrayListOf()
    }

    /**
     * Sometimes we need to spy on real objects to observe the behaviour, for this purpose we use spy
     */
    @Test
    fun spyListWithPartialStubbing() {
        val spy = spy(realArrayList)

        //optionally, you can stub out some methods:
        `when`(spy.size).thenReturn(100)

        //using the spy calls *real* methods
        spy.add("one")
        spy.add("two")

        //prints "one" - the first element of a list
        print("Item at first index: ${spy[0]}")

        //size() method was stubbed - 100 is printed
        print("Size: ${spy.size}")
    }

    /**
     * But there is a Gotcha
     *
     * it's impossible or impractical to use when(Object) for stubbing spies as they are real objects.
     * Therefore when using spies please consider doReturn|Answer|Throw() family of methods for stubbing. Example:
     */
    @Test
    fun spyListWithDoReturn() {

        val spy = spy(realArrayList)

        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
        //`when`(spy[0]).thenReturn("one expected")

        //You have to use doReturn() for stubbing a spy
        doReturn("foo").`when`(spy)[0]
        doThrow(IndexOutOfBoundsException()).`when`(spy)[1]


        print("Should print one expected: ${spy[0]}")
        print("Should Throw IndexOutOfBoundException Exception: ${spy[1]}")

        //(expected = IndexOutOfBoundsException::class)

    }
}