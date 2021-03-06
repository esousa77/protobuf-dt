/*
 * Copyright (c) 2014 Google Inc.
 *
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.google.eclipse.protobuf.model.util;

import static com.google.common.collect.Sets.newHashSet;
import static org.eclipse.xtext.EcoreUtil2.getAllContentsOfType;

import com.google.eclipse.protobuf.protobuf.Message;
import com.google.eclipse.protobuf.protobuf.Protobuf;
import com.google.eclipse.protobuf.protobuf.TypeExtension;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Collection;
import java.util.Set;

/**
 * Utility methods related to <code>{@link Message}</code>s.
 *
 * @author alruiz@google.com (Alex Ruiz)
 */
@Singleton public class Messages {
  @Inject private ModelObjects modelObjects;
  @Inject private TypeExtensions typeExtensions;

  /**
   * Returns all the extensions of the given message declared in the same file as the message.
   * @param message the given message.
   * @return all the extensions of the given message declared in the same file as the message, or an empty collection if
   * none are found.
   */
  public Collection<TypeExtension> localExtensionsOf(Message message) {
    return extensionsOf(message, modelObjects.rootOf(message));
  }

  public Collection<TypeExtension> extensionsOf(Message message, Protobuf root) {
    Set<TypeExtension> extensions = newHashSet();
    for (TypeExtension extension : getAllContentsOfType(root, TypeExtension.class)) {
      Message referred = typeExtensions.messageFrom(extension);
      if (message.equals(referred)) {
        extensions.add(extension);
      }
    }
    return extensions;
  }
}
