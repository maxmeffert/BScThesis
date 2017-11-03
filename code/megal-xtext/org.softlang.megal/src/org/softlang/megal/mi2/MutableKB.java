package org.softlang.megal.mi2;

import java.util.Map;
import java.util.Map.Entry;

import org.softlang.megal.util.HashMultitable;
import org.softlang.megal.util.Multitable;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Table.Cell;

public class MutableKB extends KB {
	private String title;
	private final SetMultimap<String, String> rawAnnotations;
	private final SetMultimap<String, String> rawTheEntityTypeAnnotations;
	private final Map<String, String> rawEntityTypes;
	private final Multitable<Ref, Ref, String> rawRelationshipTypes;
	private final Map<String, Ref> rawEntities;
	private final Map<String, Object> rawBindings;
	private final Multitable<String, String, String> rawRelationships;
	private final SetMultimap<Entry<String, String>, Entry<String, String>> rawEntityTypeAnnotations;
	private final SetMultimap<Cell<Ref, Ref, String>, Entry<String, String>> rawRelationshipTypeAnnotations;
	private final SetMultimap<Entry<String, Ref>, Entry<String, String>> rawEntityAnnotations;
	private final SetMultimap<Cell<String, String, String>, Entry<String, String>> rawRelationshipAnnotations;

	public MutableKB() {
		title = null;
		rawAnnotations = HashMultimap.create();
		rawTheEntityTypeAnnotations = HashMultimap.create();
		rawEntityTypes = Maps.newHashMap();
		rawRelationshipTypes = HashMultitable.create();
		rawEntities = Maps.newHashMap();
		rawBindings = Maps.newHashMap();
		rawRelationships = HashMultitable.create();
		rawEntityTypeAnnotations = HashMultimap.create();
		rawRelationshipTypeAnnotations = HashMultimap.create();
		rawEntityAnnotations = HashMultimap.create();
		rawRelationshipAnnotations = HashMultimap.create();
	}

	@Override
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public SetMultimap<String, String> getRawAnnotations() {
		return rawAnnotations;
	}

	@Override
	public SetMultimap<String, String> getRawTheEntityTypeAnnotations() {
		return rawTheEntityTypeAnnotations;
	}

	@Override
	public Map<String, String> getRawEntityTypes() {
		return rawEntityTypes;
	}

	@Override
	public Multitable<Ref, Ref, String> getRawRelationshipTypes() {
		return rawRelationshipTypes;
	}

	@Override
	public Map<String, Ref> getRawEntities() {
		return rawEntities;
	}

	@Override
	public Map<String, Object> getRawBindings() {
		return rawBindings;
	}

	@Override
	public Multitable<String, String, String> getRawRelationships() {
		return rawRelationships;
	}

	@Override
	public SetMultimap<Entry<String, String>, Entry<String, String>> getRawEntityTypeAnnotations() {
		return rawEntityTypeAnnotations;
	}

	@Override
	public SetMultimap<Cell<Ref, Ref, String>, Entry<String, String>> getRawRelationshipTypeAnnotations() {
		return rawRelationshipTypeAnnotations;
	}

	@Override
	public SetMultimap<Entry<String, Ref>, Entry<String, String>> getRawEntityAnnotations() {
		return rawEntityAnnotations;
	}

	@Override
	public SetMultimap<Cell<String, String, String>, Entry<String, String>> getRawRelationshipAnnotations() {
		return rawRelationshipAnnotations;
	}

}
