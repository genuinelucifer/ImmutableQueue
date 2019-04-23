package com.github.genuinelucifer.queue.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import com.github.genuinelucifer.queue.ImmutableQueue;

class ImmutableQueueTests {
	
	private static java.util.Queue<String> getBasicQueue() {
		java.util.Queue<String> q = new java.util.LinkedList<>();
		q.add("London");
		q.add("Paris");
		return q;
	}

	@Test
	void testQueueConstructor() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		assertFalse(immutableQueue.isEmpty(), "Queue not created properly!");
		assertEquals(q.size(), immutableQueue.size(), "All the elements are not pressent in immutable queue!");
	}

	@Test
	void testQueueEnQueue() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		ImmutableQueue<String> immutableQueueEnQueued = (ImmutableQueue<String>) immutableQueue.enQueue("New York");
		assertEquals(q.size(), immutableQueue.size(), "Enqueue changed queue size!");
		assertEquals(q.size() + 1, immutableQueueEnQueued.size(), "Enqueued queue does not have all the elements!");
	}

	@Test
	void testQueueDeQueue() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		ImmutableQueue<String> immutableQueueDeQueued = (ImmutableQueue<String>) immutableQueue.deQueue();
		assertEquals(q.size(), immutableQueue.size(), "Dequeue changed queue size!");
		assertEquals(q.size() - 1, immutableQueueDeQueued.size(), "Dequeued queue does not have proper elements!");
	}

	@Test
	void testQueueHead() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		assertEquals(q.peek(), immutableQueue.head(), "Value at head is wrong!");
	}

	@Test
	void testQueueContains() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		assertEquals(q.contains("London"), immutableQueue.contains("London"), "Contains gives wrong result!");
		assertEquals(q.contains("Berlin"), immutableQueue.contains("Berlin"), "Contains gives wrong result!");
	}

	@Test
	void testQueueGetMutableQueue() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		java.util.Queue<String> mutableQueue = immutableQueue.getMutableQueue();
		// Changes in mutable queue should not affect immutable queue
		mutableQueue.poll();
		assertEquals(q.size(), immutableQueue.size(), "Changes in mutable queue changed immutable queue size!");
		mutableQueue.add("New York");
		mutableQueue.add("Berlin");
		assertEquals(q.size(), immutableQueue.size(), "Changes in mutable queue changed immutable queue size!");
	}

	@Test
	void testQueueIterator() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		Iterator<String> iter = immutableQueue.iterator();
		iter.next();
		iter.remove();
		assertEquals(q.size(), immutableQueue.size(), "Changes in iterator changed immutable queue size!");
	}

}
