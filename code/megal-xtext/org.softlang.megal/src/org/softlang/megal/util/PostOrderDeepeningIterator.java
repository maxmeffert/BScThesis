package org.softlang.megal.util;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.newLinkedList;

import java.util.Deque;
import java.util.List;
import java.util.ListIterator;

import com.google.common.collect.AbstractIterator;

public abstract class PostOrderDeepeningIterator<E> extends AbstractIterator<E> {
	private final List<E> tier;

	private final Deque<E> sequence;

	public PostOrderDeepeningIterator(Iterable<? extends E> initial) {
		tier = newArrayList(initial);
		sequence = newLinkedList(initial);
	}

	protected abstract Iterable<? extends E> getNext(E e);

	@Override
	protected E computeNext() {
		if (!sequence.isEmpty())
			return sequence.poll();

		for (ListIterator<E> it = tier.listIterator(); it.hasNext();) {
			E v = it.next();

			it.remove();

			for (E s : getNext(v)) {
				it.add(s);
				sequence.offer(s);
			}
		}

		if (sequence.isEmpty())
			return endOfData();

		return sequence.poll();
	}
}