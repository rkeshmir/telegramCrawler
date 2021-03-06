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
package ir.adventure.observer.client.core.org.telegram.api.input.bot.inlinemessage;

import ir.adventure.observer.client.core.org.telegram.api.keyboard.replymarkup.TLAbsReplyMarkup;
import ir.adventure.observer.client.core.org.telegram.api.message.entity.TLAbsMessageEntity;
import ir.adventure.observer.client.core.org.telegram.tl.StreamingUtils;
import ir.adventure.observer.client.core.org.telegram.tl.TLContext;
import ir.adventure.observer.client.core.org.telegram.tl.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @brief TODO
 * @date 13 of February of 2016
 */
public class TLInputBotInlineMessageText extends TLAbsInputBotInlineMessage {
    public static final int CLASS_ID = 0x3dcd7a87;

    private static final int FLAG_NO_WEBPAGE    = 0x00000001; // 0
    private static final int FLAG_ENTITIES      = 0x00000002; // 1
    private static final int FLAG_REPLY_MARKUP  = 0x00000004; // 2

    private int flags;
    private String message;
    private TLVector<TLAbsMessageEntity> entities;
    private TLAbsReplyMarkup replyMarkup;

    public TLInputBotInlineMessageText() {
        super();
    }

    public int getFlags() {
        return flags;
    }

    public String getMessage() {
        return message;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public boolean hasWebPreview() {
        return (flags & FLAG_NO_WEBPAGE) == 0;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeInt(flags, stream);
        StreamingUtils.writeTLString(message, stream);
        if ((flags & FLAG_ENTITIES) != 0) {
            StreamingUtils.writeTLVector(entities, stream);
        }
        if ((flags & FLAG_REPLY_MARKUP) != 0) {
            StreamingUtils.writeTLObject(replyMarkup, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = StreamingUtils.readInt(stream);
        message = StreamingUtils.readTLString(stream);
        if ((flags & FLAG_ENTITIES) != 0) {
            entities = (TLVector<TLAbsMessageEntity>) StreamingUtils.readTLVector(stream, context);
        }
        if ((flags & FLAG_REPLY_MARKUP) != 0) {
            replyMarkup = (TLAbsReplyMarkup) StreamingUtils.readTLObject(stream, context);
        }
    }

    @Override
    public String toString() {
        return "inputBotInlineMessageText#3dcd7a87";
    }
}
