/**
 * This file is part of Support Bot.
 *
 *     Foobar is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Foobar is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */
package ir.adventure.observer.client.core.org.telegram.api.functions.help;

import ir.adventure.observer.client.core.org.telegram.api.help.TLTermsOfService;
import ir.adventure.observer.client.core.org.telegram.tl.StreamingUtils;
import ir.adventure.observer.client.core.org.telegram.tl.TLContext;
import ir.adventure.observer.client.core.org.telegram.tl.TLMethod;
import ir.adventure.observer.client.core.org.telegram.tl.TLObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * The type TL request help get app changelog.
 */
public class TLRequestHelpGetTermsOfService extends TLMethod<TLTermsOfService> {
    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x350170f3;

    /**
     * Instantiates a new TL request help get app changelog.
     */
    public TLRequestHelpGetTermsOfService() {
        super();
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public TLTermsOfService deserializeResponse(InputStream stream, TLContext context)
            throws IOException {
        final TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if ((res instanceof TLTermsOfService)) {
            return (TLTermsOfService) res;
        }
        throw new IOException("Incorrect response type. Expected " + TLTermsOfService.class.getName() + ", got: " + res.getClass().getCanonicalName());
    }

    public String toString() {
        return "help.getTermsOfService#350170f3";
    }
}