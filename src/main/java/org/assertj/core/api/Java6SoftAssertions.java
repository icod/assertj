/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2018 the original author or authors.
 */
package org.assertj.core.api;

import static org.assertj.core.groups.Properties.extractProperty;

import java.util.List;

import org.assertj.core.error.AssertionErrorCreator;

/**
 * Soft assertions compatible with Android. Duplicated from {@link SoftAssertions}.
 *
 * @see SoftAssertions
 *
 * @since 2.5.0 / 3.5.0
 */
public class Java6SoftAssertions extends Java6AbstractStandardSoftAssertions {

  private AssertionErrorCreator assertionErrorCreator = new AssertionErrorCreator();

  /**
   * Verifies that no proxied assertion methods have failed.
   *
   * @throws SoftAssertionError if any proxied assertion objects threw
   */
  public void assertAll() {
    List<Throwable> errors = errorsCollected();
    if (!errors.isEmpty()) {
      assertionErrorCreator.tryThrowingMultipleFailuresError(errors);
      throw new SoftAssertionError(extractProperty("message", String.class).from(errors));
    }
  }
}
