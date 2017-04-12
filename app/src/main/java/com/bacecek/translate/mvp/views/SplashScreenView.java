package com.bacecek.translate.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Denis Buzmakov on 11/04/2017.
 * <buzmakov.da@gmail.com>
 */

public interface SplashScreenView extends MvpView {
	void showError();
	void hideError();
	void showLoading();
	void hideLoading();
	@StateStrategyType(OneExecutionStateStrategy.class)
	void goToMainScreen();
}
