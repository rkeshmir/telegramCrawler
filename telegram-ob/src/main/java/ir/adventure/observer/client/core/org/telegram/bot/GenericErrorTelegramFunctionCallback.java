package ir.adventure.observer.client.core.org.telegram.bot;

import ir.adventure.observer.client.core.org.telegram.api.engine.RpcException;
import ir.adventure.observer.client.core.org.telegram.api.engine.TimeoutException;
import ir.adventure.observer.client.core.org.telegram.tl.TLObject;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @brief Callback to execute telegram api method
 * @date 26 of September of 2015
 */
public abstract class GenericErrorTelegramFunctionCallback<T extends TLObject> implements TelegramFunctionCallback<T> {
    @Override
    public void onRpcError(RpcException e) {
        onError(e);
    }

    @Override
    public void onTimeout(TimeoutException e) {
        onError(e);
    }

    @Override
    public void onUnknownError(Throwable e) {
        onError(e);
    }

    public abstract void onError(Throwable e);
}
