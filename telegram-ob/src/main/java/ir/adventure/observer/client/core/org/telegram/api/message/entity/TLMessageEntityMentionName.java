package ir.adventure.observer.client.core.org.telegram.api.message.entity;

import ir.adventure.observer.client.core.org.telegram.tl.StreamingUtils;
import ir.adventure.observer.client.core.org.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @brief Abstract representation of entities in a message
 * @date 19 of September of 2015
 */
public class TLMessageEntityMentionName extends TLAbsMessageEntity {
    public static final int CLASS_ID = 0x352dca58;

    private int offset;
    private int length;
    private int userId;

    public TLMessageEntityMentionName() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeInt(offset, stream);
        StreamingUtils.writeInt(length, stream);
        StreamingUtils.writeInt(userId, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.offset = StreamingUtils.readInt(stream);
        this.length = StreamingUtils.readInt(stream);
        userId = StreamingUtils.readInt(stream);
    }

    @Override
    public String toString() {
        return "messageEntityMentionName#352dca58";
    }
}
