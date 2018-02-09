package com.wardellbagby.fixedqueue

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test
import kotlin.reflect.KClass

class FixedQueueTest {

    @Test
    fun testInit() {
        expectException(IllegalArgumentException::class) { FixedQueue<Int>(-1) }
        expectException(IllegalArgumentException::class) { FixedQueue<Int>(Int.MIN_VALUE) }
        expectException(IllegalArgumentException::class) { FixedQueue<Int>(-654365525) }
        expectException(IllegalArgumentException::class) { FixedQueue<Int>(-4) }
        FixedQueue<Int>(-0)
        FixedQueue<Int>(0)
        FixedQueue<Int>(1)
        FixedQueue<Int>(Int.MAX_VALUE)
        FixedQueue<Int>(643543566)

    }

    @Test
    fun testMaxSizeOfZero() {
        val queue = FixedQueue<Int>(0)
        (-100..100).forEach {
            assertFalse(queue.offer(it))
        }
        assertEquals(0, queue.size)
        assertEquals(0, queue.maxSize)
    }

    @Test
    fun testFixedQueue() {
        val halfCap = 1_000_000
        val queue = FixedQueue<Int>(halfCap)
        assertEquals(halfCap, queue.maxSize)
        assertEquals(0, queue.size)

        (0 until halfCap).forEach {
            assertEquals(it, queue.size)
            assertTrue(queue.offer(it))
            assertEquals(it + 1, queue.size)
            assertEquals(halfCap, queue.maxSize)
        }

        assertEquals(halfCap, queue.size)

        (halfCap + 1 until halfCap * 2).forEach {
            assertEquals(halfCap, queue.size)

            assertTrue(queue.offer(it))
            assertEquals(halfCap, queue.size)

            assertEquals(it - halfCap, queue.peek())
            assertEquals(halfCap, queue.size)
        }

        assertEquals(halfCap, queue.size)

        (halfCap downTo 1).forEach {
            assertEquals(halfCap, queue.maxSize)
            assertNotNull(queue.poll())
            assertEquals(it - 1, queue.size)
        }

        assertEquals(halfCap, queue.maxSize)
    }

    private fun <T : Exception> expectException(expectedException: KClass<T>, block: () -> Unit) {
        try {
            block()
            fail("${expectedException.simpleName} was not thrown.")
        } catch (exception: Exception) {
            if (!expectedException.isInstance(exception)) {
                fail("${expectedException.simpleName} was not thrown. Instead a ${exception::class.java.simpleName} was thrown. Message: ${exception.message}")
            }
        }
    }
}