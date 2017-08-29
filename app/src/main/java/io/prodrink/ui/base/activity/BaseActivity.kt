package io.prodrink.ui.base.activity

import io.prodrink.ui.base.presenter.BasePresenter
import nucleus.view.NucleusAppCompatActivity

abstract class BaseActivity<P : BasePresenter<*>> : NucleusAppCompatActivity<P>()