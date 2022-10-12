/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytedance.bitsail.flink.core.legacy.connector.transformer;

import com.bytedance.bitsail.common.configuration.BitSailConfiguration;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.typeutils.ResultTypeQueryable;
import org.apache.flink.api.java.typeutils.RowTypeInfo;
import org.apache.flink.types.Row;

import java.io.Serializable;

public abstract class AbstractTransform implements Serializable, ResultTypeQueryable<Row> {
  protected final BitSailConfiguration outputConf;
  private final RowTypeInfo outputRowTypeInfo;

  public AbstractTransform(BitSailConfiguration outputConf, RowTypeInfo outputRowTypeInfo) {
    this.outputConf = outputConf;
    this.outputRowTypeInfo = outputRowTypeInfo;
  }

  public void open() throws Exception {
  }

  public void close() throws Exception {
  }

  public Row process(Row input) throws Exception {
    return input;
  }

  @Override
  public TypeInformation<Row> getProducedType() {
    return outputRowTypeInfo;
  }

  public abstract String getTransformName();
}