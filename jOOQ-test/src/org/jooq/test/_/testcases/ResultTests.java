/**
 * Copyright (c) 2009-2013, Data Geekery GmbH (http://www.datageekery.com)
 * All rights reserved.
 *
 * This work is dual-licensed
 * - under the Apache Software License 2.0 (the "ASL")
 * - under the jOOQ License and Maintenance Agreement (the "jOOQ License")
 * =============================================================================
 * You may choose which license applies to you:
 *
 * - If you're using this work with Open Source databases, you may choose
 *   either ASL or jOOQ License.
 * - If you're using this work with at least one commercial database, you must
 *   choose jOOQ License
 *
 * For more information, please visit http://www.jooq.org/licenses
 *
 * Apache Software License 2.0:
 * -----------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * jOOQ License and Maintenance Agreement:
 * -----------------------------------------------------------------------------
 * Data Geekery grants the Customer the non-exclusive, timely limited and
 * non-transferable license to install and use the Software under the terms of
 * the jOOQ License and Maintenance Agreement.
 *
 * This library is distributed with a LIMITED WARRANTY. See the jOOQ License
 * and Maintenance Agreement for more details: http://www.jooq.org/licensing
 */
package org.jooq.test._.testcases;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.sql.Date;
import java.util.Comparator;

import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Record6;
import org.jooq.Result;
import org.jooq.TableRecord;
import org.jooq.UpdatableRecord;
import org.jooq.test.BaseTest;
import org.jooq.test.jOOQAbstractTest;

import org.junit.Test;

public class ResultTests<
    A    extends UpdatableRecord<A> & Record6<Integer, String, String, Date, Integer, ?>,
    AP,
    B    extends UpdatableRecord<B>,
    S    extends UpdatableRecord<S> & Record1<String>,
    B2S  extends UpdatableRecord<B2S> & Record3<String, Integer, Integer>,
    BS   extends UpdatableRecord<BS>,
    L    extends TableRecord<L> & Record2<String, String>,
    X    extends TableRecord<X>,
    DATE extends UpdatableRecord<DATE>,
    BOOL extends UpdatableRecord<BOOL>,
    D    extends UpdatableRecord<D>,
    T    extends UpdatableRecord<T>,
    U    extends TableRecord<U>,
    UU   extends UpdatableRecord<UU>,
    I    extends TableRecord<I>,
    IPK  extends UpdatableRecord<IPK>,
    T725 extends UpdatableRecord<T725>,
    T639 extends UpdatableRecord<T639>,
    T785 extends TableRecord<T785>,
    CASE extends UpdatableRecord<CASE>>
extends BaseTest<A, AP, B, S, B2S, BS, L, X, DATE, BOOL, D, T, U, UU, I, IPK, T725, T639, T785, CASE> {

    public ResultTests(jOOQAbstractTest<A, AP, B, S, B2S, BS, L, X, DATE, BOOL, D, T, U, UU, I, IPK, T725, T639, T785, CASE> delegate) {
        super(delegate);
    }

    @Test
    public void testResultSort() throws Exception {
        Result<B> result = create().fetch(TBook());

        assertTrue(result == result.sortAsc(TBook_ID()));
        assertEquals(asList(1, 2, 3, 4), result.getValues(TBook_ID()));

        assertTrue(result == result.sortDesc(TBook_ID()));
        assertEquals(asList(4, 3, 2, 1), result.getValues(TBook_ID()));

        class C1 implements Comparator<Integer> {

            @Override
            public int compare(Integer o1, Integer o2) {

                // Put 1 at the end of everything
                if (o1 == 1 && o2 != 1) return 1;
                if (o2 == 1 && o1 != 1) return -1;

                return o1.compareTo(o2);
            }
        }

        assertTrue(result == result.sortAsc(TBook_ID(), new C1()));
        assertEquals(asList(2, 3, 4, 1), result.getValues(TBook_ID()));

        assertTrue(result == result.sortDesc(TBook_ID(), new C1()));
        assertEquals(asList(1, 4, 3, 2), result.getValues(TBook_ID()));

        class C2 implements Comparator<B> {

            private final C1 c1 = new C1();

            @Override
            public int compare(B book1, B book2) {
                return c1.compare(book1.getValue(TBook_ID()), book2.getValue(TBook_ID()));
            }
        }

        assertTrue(result == result.sortAsc(new C2()));
        assertEquals(asList(2, 3, 4, 1), result.getValues(TBook_ID()));

        assertTrue(result == result.sortDesc(new C2()));
        assertEquals(asList(1, 4, 3, 2), result.getValues(TBook_ID()));
    }
}