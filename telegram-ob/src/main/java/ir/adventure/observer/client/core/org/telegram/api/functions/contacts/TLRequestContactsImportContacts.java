package ir.adventure.observer.client.core.org.telegram.api.functions.contacts;

import ir.adventure.observer.client.core.org.telegram.api.contacts.TLImportedContacts;
import ir.adventure.observer.client.core.org.telegram.api.input.TLInputPhoneContact;
import ir.adventure.observer.client.core.org.telegram.tl.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The type TL request contacts import contacts.
 */
public class TLRequestContactsImportContacts extends TLMethod<TLImportedContacts> {
    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xda30b32d;

    private TLVector<TLInputPhoneContact> contacts;
    private boolean replace;

    /**
     * Instantiates a new TL request contacts import contacts.
     */
    public TLRequestContactsImportContacts() {
        super();
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public TLImportedContacts deserializeResponse(InputStream stream, TLContext context)
            throws IOException {
        TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLImportedContacts))
            return (TLImportedContacts) res;
        throw new IOException("Incorrect response type. Expected org.telegram.api.contacts.TLImportedContacts, got: " + res.getClass().getCanonicalName());
    }

    /**
     * Gets contacts.
     *
     * @return the contacts
     */
    public TLVector<TLInputPhoneContact> getContacts() {
        return this.contacts;
    }

    /**
     * Sets contacts.
     *
     * @param value the value
     */
    public void setContacts(TLVector<TLInputPhoneContact> value) {
        this.contacts = value;
    }

    /**
     * Gets replace.
     *
     * @return the replace
     */
    public boolean getReplace() {
        return this.replace;
    }

    /**
     * Sets replace.
     *
     * @param value the value
     */
    public void setReplace(boolean value) {
        this.replace = value;
    }

    public void serializeBody(OutputStream stream)
            throws IOException {
        StreamingUtils.writeTLVector(this.contacts, stream);
        StreamingUtils.writeTLBool(this.replace, stream);
    }

    public void deserializeBody(InputStream stream, TLContext context)
            throws IOException {
        this.contacts = StreamingUtils.readTLVector(stream, context);
        this.replace = StreamingUtils.readTLBool(stream);
    }

    public String toString() {
        return "contacts.importContacts#da30b32d";
    }
}