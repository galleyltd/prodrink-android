package io.prodrink.ui.base.activity

import io.prodrink.ui.base.presenter.BasePresenter
import nucleus.view.NucleusAppCompatActivity

abstract class BaseRxActivity<P : BasePresenter<*>> : NucleusAppCompatActivity<P>()