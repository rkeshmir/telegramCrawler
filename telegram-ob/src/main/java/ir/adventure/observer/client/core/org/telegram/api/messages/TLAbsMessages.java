package ir.adventure.observer.client.core.org.telegram.api.messages;

import ir.adventure.observer.client.core.org.telegram.api.chat.TLAbsChat;
import ir.adventure.observer.client.core.org.telegram.api.message.TLAbsMessage;
import ir.adventure.observer.client.core.org.telegram.api.user.TLAbsUser;
import ir.adventure.observer.client.core.org.telegram.tl.TLObject;
import ir.adventure.observer.client.core.org.telegram.tl.TLVector;

/**
 * The type TL abs messages.
 */
public abstract class TLAbsMessages extends TLObject {
    /**
     * The Messages.
     */
    protected TLVector<TLAbsMessage> messages;
    /**
     * The Chats.
     */
    protected TLVector<TLAbsChat> chats;
    /**
     * The Users.
     */
    protected TLVector<TLAbsUser> users;

    /**
     * Gets messages.
     *
     * @return the messages
     */
    public TLVector<TLAbsMessage> getMessages() {
        return this.messages;
    }

    /**
     * Sets messages.
     *
     * @param value the value
     */
    public void setMessages(TLVector<TLAbsMessage> value) {
        this.messages = value;
    }

    /**
     * Gets chats.
     *
     * @return the chats
     */
    public TLVector<TLAbsChat> getChats() {
        return this.chats;
    }

    /**
     * Sets chats.
     *
     * @param value the value
     */
    public void setChats(TLVector<TLAbsChat> value) {
        this.chats = value;
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
     * @param value the value
     */
    public void setUsers(TLVector<TLAbsUser> value) {
        this.users = value;
    }
}