package org.softlang.megal.util;

import java.util.Iterator;

public abstract class PostOrderDeepeningIterable<E> implements Iterable<E> {
	private final Iterable<? extends E> initial;

	public PostOrderDeepeningIterable(Iterable<? extends E> initial) {
		this.initial = initial;
	}

	protected abstract Iterable<? extends E> getNext(E e);

	@Override
	public Iterator<E> iterator() {

		return new PostOrderDeepeningIterator<E>(initial) {
			@Override
			protected Iterable<? extends E> getNext(E e) {
				return PostOrderDeepeningIterable.this.getNext(e);
			}
		};
	}
}
