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

package ir.adventure.observer.client.core.org.telegram.api.input.privacy.inputprivacyrule;

import ir.adventure.observer.client.core.org.telegram.api.user.TLAbsUser;
import ir.adventure.observer.client.core.org.telegram.tl.StreamingUtils;
import ir.adventure.observer.client.core.org.telegram.tl.TLContext;
import ir.adventure.observer.client.core.org.telegram.tl.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The type TL input privacy value disallow users.
 */
public class TLInputPrivacyValueDisallowUsers extends TLAbsInputPrivacyRule {
    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x90110467;

    /**
     * The Users.
     */
    protected TLVector<TLAbsUser> users = new TLVector<>();

    /**
     * Instantiates a new TL input privacy value disallow users.
     */
    public TLInputPrivacyValueDisallowUsers() {
        super();
    }

    public int getClassId() {
        return CLASS_ID;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public TLVector<TLAbsUser> getUsers() {
        return this.users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }

    public void serializeBody(OutputStream stream)
            throws IOException {
        StreamingUtils.writeTLVector(this.users, stream);
    }

    public void deserializeBody(InputStream stream, TLContext context)
            throws IOException {
        this.users = (TLVector<TLAbsUser>) StreamingUtils.readTLVector(stream, context);
    }

    public String toString() {
        return "inputPrivacyValueDisallowUsers#90110467";
    }
}