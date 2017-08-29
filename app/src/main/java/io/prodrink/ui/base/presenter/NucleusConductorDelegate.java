package io.prodrink.ui.base.presenter;


import android.os.Bundle;
import android.support.annotation.Nullable;

import nucleus.factory.PresenterFactory;
import nucleus.presenter.Presenter;

public class NucleusConductorDelegate<P extends Presenter> {

    @Nullable private P presenter;
    @Nullable private Bundle bundle;

    private PresenterFactory<P> factory;

    public NucleusConductorDelegate(PresenterFactory<P> creator) {
        this.factory = creator;
    }

    public P getPresenter() {
        if (presenter == null) {
            presenter = factory.createPresenter();
            presenter.create(bundle);
            bundle = null;
        }
        return presenter;
    }

    Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        getPresenter();
        if (presenter != null) {
            presenter.save(bundle);
        }
        return bundle;
    }

    void onRestoreInstanceState(Bundle presenterState) {
        bundle = presenterState;
    }

    void onTakeView(Object view) {
        getPresenter();
        if (presenter != null) {
            //noinspection unchecked
            presenter.takeView(view);
        }
    }

    void onDropView() {
        if (presenter != null) {
            presenter.dropView();
        }
    }

    void onDestroy() {
        if (presenter != null) {
            presenter.destroy();
        }
    }
}