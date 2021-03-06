package ir.adventure.observer.client.core.org.telegram.mtproto.tl;

import ir.adventure.observer.client.core.org.telegram.mtproto.util.BytesCache;
import ir.adventure.observer.client.core.org.telegram.tl.TLContext;
import ir.adventure.observer.client.core.org.telegram.tl.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static ir.adventure.observer.client.core.org.telegram.tl.StreamingUtils.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ruben Bermudez
 * Date: 03.11.13
 * Time: 22:06
 */
public class MTRpcResult extends TLObject {

    public static final int CLASS_ID = 0xf35c6d01;

    private long messageId;
    private byte[] content;
    private int contentLen;

    public MTRpcResult(long messageId, byte[] content, int contentLen) {
        this.messageId = messageId;
        this.content = content;
        this.contentLen = contentLen;
    }

    public MTRpcResult() {

    }

    public long getMessageId() {
        return this.messageId;
    }

    public byte[] getContent() {
        return this.content;
    }

    public int getContentLen() {
        return this.contentLen;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(this.messageId, stream);
        writeByteArray(this.content, 0, this.contentLen, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.messageId = readLong(stream);
        int contentSize = stream.available();
        this.content = BytesCache.getInstance().allocate(contentSize);
        readBytes(this.content, 0, contentSize, stream);
    }

    @Override
    public String toString() {
        return "rpc_result#f35c6d01";
    }
}
