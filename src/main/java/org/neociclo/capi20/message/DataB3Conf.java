/**
 * The Accord Project, http://accordproject.org
 * Copyright (C) 2005-2013 Rafael Marins, http://rafaelmarins.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neociclo.capi20.message;

import static org.neociclo.capi20.message.MessageType.*;
import static org.neociclo.capi20.parameter.ParameterBuffers.*;
import static org.neociclo.capi20.util.CapiBuffers.readWord;

import net.sourceforge.jcapi.message.parameter.NCCI;

import org.jboss.netty.buffer.ChannelBuffer;
import org.neociclo.capi20.parameter.Info;

/**
 * @author Rafael Marins
 */
public class DataB3Conf extends ReceiveMessage {

    private NCCI ncci;
    private int dataHandle;
    private Info info;

    public DataB3Conf(ChannelBuffer buffer) {
        super(DATA_B3_CONF, buffer);
    }

    protected void setNcci(NCCI ncci) {
        this.ncci = ncci;
    }

    protected void setDataHandle(int dataHandle) {
        this.dataHandle = dataHandle;
    }

    protected void setInfo(Info info) {
        this.info = info;
    }

    public NCCI getNcci() {
        return ncci;
    }

    public int getDataHandle() {
        return dataHandle;
    }

    public Info getInfo() {
        return info;
    }

    // -------------------------------------------------------------------------
    // ReceiveMessage implementation overriding
    // -------------------------------------------------------------------------

    @Override
    protected void setValues(ChannelBuffer buf) {
        setNcci(readNcci(buf));
        setDataHandle(readWord(buf));
        setInfo(readInfo(buf));
    }

}
