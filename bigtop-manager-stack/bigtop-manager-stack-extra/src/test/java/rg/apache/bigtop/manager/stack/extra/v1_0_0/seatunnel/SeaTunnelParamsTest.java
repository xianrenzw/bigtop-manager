/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package rg.apache.bigtop.manager.stack.extra.v1_0_0.seatunnel;

import org.apache.bigtop.manager.stack.extra.v1_0_0.seatunnel.SeaTunnelParams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SeaTunnelParamsTest {

    @Test
    public void testConfDir() {
        SeaTunnelParams seaTunnelParams = mock(SeaTunnelParams.class);
        when(seaTunnelParams.serviceHome()).thenReturn("/bigtop/seatunnel");
        when(seaTunnelParams.confDir()).thenCallRealMethod();
        assertEquals("/bigtop/seatunnel/config", seaTunnelParams.confDir());
    }

    @Test
    public void testSparkHome() {
        SeaTunnelParams seaTunnelParams = mock(SeaTunnelParams.class);
        when(seaTunnelParams.stackHome()).thenReturn("/stack");
        when(seaTunnelParams.sparkHome()).thenCallRealMethod();
        assertEquals("/stack/spark", seaTunnelParams.sparkHome());
    }

    @Test
    public void testFlinkHome() {
        SeaTunnelParams seaTunnelParams = mock(SeaTunnelParams.class);
        when(seaTunnelParams.stackHome()).thenReturn("/stack");
        when(seaTunnelParams.flinkHome()).thenCallRealMethod();
        assertEquals("/stack/flink", seaTunnelParams.flinkHome());
    }

    @Test
    public void testGetServiceName() {
        SeaTunnelParams seaTunnelParams = new SeaTunnelParams();
        assertEquals("seatunnel", seaTunnelParams.getServiceName());
    }
}
