/*
 * Copyright (c) 2011 Google Inc.
 *
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.google.eclipse.protobuf.ui.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

/**
 * A preference that stores a {@code boolean} value.
 *
 * @author alruiz@google.com (Alex Ruiz)
 */
public class BooleanPreference extends Preference<Boolean> {

  /**
   * Creates a new </code>{@link BooleanPreference}</code>.
   * @param name the name of this preference.
   * @param store the store for this preference.
   */
  public BooleanPreference(String name, IPreferenceStore store) {
    super(name, store);
  }

  /** {@inheritDoc} */
  @Override public Boolean value() {
    return store.getBoolean(name);
  }

  /** {@inheritDoc} */
  @Override public Boolean defaultValue() {
    return store.getDefaultBoolean(name);
  }

  /** {@inheritDoc} */
  @Override public void value(Boolean value) {
    store.setValue(name, value);
  }

  /** {@inheritDoc} */
  @Override public void defaultValue(Boolean value) {
    store.setDefault(name, value);
  }
}