package ir.adventure.observer.client.core.org.telegram.mtproto.tl.pq;

import ir.adventure.observer.client.core.org.telegram.tl.TLContext;
import ir.adventure.observer.client.core.org.telegram.tl.TLLongVector;
import ir.adventure.observer.client.core.org.telegram.tl.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static ir.adventure.observer.client.core.org.telegram.tl.StreamingUtils.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ruben Bermudez
 * Date: 03.11.13
 * Time: 5:31
 */
public class ResPQ extends TLObject {

    public static final int CLASS_ID = 0x05162463;

    protected byte[] nonce;
    protected byte[] serverNonce;
    protected byte[] pq;
    protected TLLongVector fingerprints;

    public ResPQ(byte[] nonce, byte[] serverNonce, byte[] pq, TLLongVector fingerprints) {
        this.nonce = nonce;
        this.serverNonce = serverNonce;
        this.pq = pq;
        this.fingerprints = fingerprints;
    }

    public ResPQ() {
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public byte[] getNonce() {
        return this.nonce;
    }

    public void setNonce(byte[] nonce) {
        this.nonce = nonce;
    }

    public byte[] getServerNonce() {
        return this.serverNonce;
    }

    public void setServerNonce(byte[] serverNonce) {
        this.serverNonce = serverNonce;
    }

    public byte[] getPq() {
        return this.pq;
    }

    public void setPq(byte[] pq) {
        this.pq = pq;
    }

    public TLLongVector getFingerprints() {
        return this.fingerprints;
    }

    public void setFingerprints(TLLongVector fingerprints) {
        this.fingerprints = fingerprints;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeByteArray(this.nonce, stream);
        writeByteArray(this.serverNonce, stream);
        writeTLBytes(this.pq, stream);
        writeTLVector(this.fingerprints, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.nonce = readBytes(16, stream);
        this.serverNonce = readBytes(16, stream);
        this.pq = readTLBytes(stream);
        this.fingerprints = readTLLongVector(stream, context);
    }

    @Override
    public String toString() {
        return "resPQ#05162463";
    }
}
