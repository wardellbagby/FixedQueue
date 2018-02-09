package com.wardellbagby.fixedqueue

import java.util.AbstractQueue
import java.util.Deque
import java.util.LinkedList

/**
 * A [java.util.Queue] that will pop its oldest added item when a new item is offered that would put its size
 * above [maxSize]
 *
 * @author Wardell Bagby
 */
open class FixedQueue<T>(val maxSize: Int) : AbstractQueue<T>() {
    private val values: Deque<T> = LinkedList()

    init {
        if (maxSize < 0) throw IllegalArgumentException("maxSize cannot be less than 0. maxSize = $maxSize")
    }

    override val size: Int
        get() = values.size

    override fun iterator() = values.iterator()

    override fun poll(): T = values.poll()

    override fun peek(): T = values.peek()

    /**
     * Offer an item to be added to the queue. This method will always return true unless the queue
     * has a max size of zero. If the queue has reached its max size, it will remove the oldest
     * added item in order to make room for the item being offered.
     *
     * @return true unless max size is zero, then it'll return false.
     */
    override fun offer(item: T): Boolean {
        if (maxSize == 0) return false

        if (size == maxSize) {
            values.pop()
        }

        return values.offer(item)
    }
}