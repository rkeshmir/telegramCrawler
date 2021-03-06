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

package ir.adventure.observer.client.core.org.telegram.api.input.messages.filter;

/**
 * The type TL messages filter audio.
 */
public class TLMessagesFilterChatPhoto extends TLAbsMessagesFilter {
    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x3a20ecb8;

    /**
     * Instantiates a new TL messages filter audio.
     */
    public TLMessagesFilterChatPhoto() {
        super();
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public String toString() {
        return "inputMessagesFilterChatPhotos#3a20ecb8";
    }
}