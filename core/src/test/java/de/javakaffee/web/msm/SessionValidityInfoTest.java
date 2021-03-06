/*
 * Copyright 2011 Martin Grotzke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an &quot;AS IS&quot; BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package de.javakaffee.web.msm;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

/**
 * Test the {@link SessionValidityInfo}.
 *
 * @author <a href="mailto:martin.grotzke@javakaffee.de">Martin Grotzke</a>
 */
public class SessionValidityInfoTest {

    @Test
    public void testDecodeEncodedData() {
        final byte[] encoded = SessionValidityInfo.encode( 23, 42, 4711 );
        final SessionValidityInfo decoded = SessionValidityInfo.decode( encoded );
        assertEquals( decoded.getMaxInactiveInterval(), 23 );
        assertEquals( decoded.getLastAccessedTime(), 42 );
        assertEquals( decoded.getThisAccessedTime(), 4711 );
    }

    @Test
    public void negativeInactivityAlwaysValid() {
        final SessionValidityInfo info = new SessionValidityInfo(-1, 0, 0);
        assertTrue(info.isValid());
    }
}
