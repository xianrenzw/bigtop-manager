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
package org.apache.bigtop.manager.server.command.stage;

import org.apache.bigtop.manager.server.command.task.SetupJdkTask;
import org.apache.bigtop.manager.server.command.task.Task;
import org.apache.bigtop.manager.server.command.task.TaskContext;

public class SetupJdkStage extends AbstractStage {

    public SetupJdkStage(StageContext stageContext) {
        super(stageContext);
    }

    @Override
    protected void injectBeans() {
        super.injectBeans();
    }

    @Override
    protected void beforeCreateTasks() {}

    @Override
    protected Task createTask(String hostname) {
        TaskContext taskContext = new TaskContext();
        taskContext.setHostname(hostname);
        taskContext.setClusterId(stageContext.getClusterId());
        taskContext.setClusterName(stageContext.getClusterName());
        taskContext.setServiceName("cluster");
        taskContext.setServiceUser("root");
        taskContext.setComponentName("agent");
        taskContext.setComponentDisplayName("Agent");

        return new SetupJdkTask(taskContext);
    }

    @Override
    public String getName() {
        return "Setup JDK";
    }
}
